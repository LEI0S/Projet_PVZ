package com.epf.service.impl;

import com.epf.model.Zombie;
import com.epf.repository.ZombieRepository;
import com.epf.service.impl.ZombieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ZombieServiceImplTest {

    @Mock
    private ZombieRepository zombieRepository;

    @InjectMocks
    private ZombieServiceImpl zombieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void GetAllZombies() {
        // Arrange
        Zombie zombie1 = new Zombie(1L, "Zombie1", 1L);
        Zombie zombie2 = new Zombie(2L, "Zombie2", 1L);

        when(zombieRepository.findAll()).thenReturn(Arrays.asList(zombie1, zombie2));

        // Act
        List<Zombie> result = zombieService.getAllZombies();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Zombie1", result.get(0).getNom());
        assertEquals("Zombie2", result.get(1).getNom());

        verify(zombieRepository, times(1)).findAll();
    }


    @Test
    void GetZombieById() {
        // Arrange
        Zombie zombie = new Zombie(1L, "ZombieTest", 1L);
        when(zombieRepository.findById(1L)).thenReturn(zombie);

        // Act
        Zombie result = zombieService.getZombieById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("ZombieTest", result.getNom());
        verify(zombieRepository, times(1)).findById(1L);
    }

    @Test
    void AddZombie() {
        // Arrange
        Zombie zombie = new Zombie(1L, "NewZombie", 1L);

        // Act
        zombieService.addZombie(zombie);

        // Assert
        verify(zombieRepository, times(1)).save(zombie);
    }

    @Test
    void UpdateZombie() {
        // Arrange
        Zombie zombie = new Zombie(1L, "UpdatedZombie", 1L);

        // Act
        zombieService.updateZombie(zombie);

        // Assert
        verify(zombieRepository, times(1)).update(zombie);
    }

    @Test
    void DeleteZombie() {
        // Act
        zombieService.deleteZombie(1L);

        // Assert
        verify(zombieRepository, times(1)).delete(1L);
    }
}
