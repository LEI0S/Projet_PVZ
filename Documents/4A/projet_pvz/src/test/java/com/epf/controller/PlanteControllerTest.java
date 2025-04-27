package com.epf.controller;

import com.epf.dto.PlanteDTO;
import com.epf.service.PlanteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlanteController.class)
class PlanteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanteService planteService;

    @Autowired
    private ObjectMapper objectMapper;

    private PlanteDTO planteDTO;

    @BeforeEach
    void setUp() {
        planteDTO = new PlanteDTO(
                1L, "Tournesol", 100, 0.0, 0, 50, 25, "Génère du soleil", "image.png"
        );
    }

    @Test
    void updatePlante() throws Exception {
        mockMvc.perform(put("/api/plantes/{idPlante}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(planteDTO)))
                .andExpect(status().isOk());

        Mockito.verify(planteService).updatePlante(Mockito.any());
    }
}
