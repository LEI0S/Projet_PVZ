package com.epf.controller;

import com.epf.dto.ZombieDTO;
import com.epf.model.Zombie;
import com.epf.service.ZombieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ZombieControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ZombieService zombieService;

    @InjectMocks
    private ZombieController zombieController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(zombieController).build();
    }

    @Test
    void GetAllZombies() throws Exception {
        List<Zombie> zombies = Arrays.asList(new Zombie(1L, "Zombie1", 1L), new Zombie(2L, "Zombie2", 1L));
        when(zombieService.getAllZombies()).thenReturn(zombies);

        mockMvc.perform(get("/api/zombies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));

        verify(zombieService, times(1)).getAllZombies();
    }

    @Test
    void AddZombie() throws Exception {
        ZombieDTO zombieDTO = new ZombieDTO(1L, "NewZombie", 100, 1.0, 10, 1.5, "image.png", 1L);

        mockMvc.perform(post("/api/zombies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(zombieDTO)))
                .andExpect(status().isOk());

        verify(zombieService, times(1)).addZombie(any(Zombie.class));
    }

    @Test
    void DeleteZombie() throws Exception {
        mockMvc.perform(delete("/api/zombies/1"))
                .andExpect(status().isOk());

        verify(zombieService, times(1)).deleteZombie(1L);
    }
}
