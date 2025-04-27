package com.epf.service;

import com.epf.model.Zombie;
import com.epf.repository.ZombieRepository;
import com.epf.service.impl.ZombieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ZombieServiceTest {

    @Mock
    private ZombieRepository zombieRepository;

    @InjectMocks
    private ZombieServiceImpl zombieService;

    @Test
    void getAllZombies() {
        // GIVEN
        Zombie zombie1 = new Zombie(1L, "Zombie1", 1L);
        Zombie zombie2 = new Zombie(2L, "Zombie2", 1L);
        when(zombieRepository.findAll()).thenReturn(Arrays.asList(zombie1, zombie2));

        // WHEN
        List<Zombie> result = zombieService.getAllZombies();

        // THEN
        assertEquals(2, result.size());
        verify(zombieRepository, times(1)).findAll();
    }
}
