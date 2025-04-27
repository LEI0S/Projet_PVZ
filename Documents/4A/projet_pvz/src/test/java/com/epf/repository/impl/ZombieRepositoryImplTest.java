package com.epf.repository.impl;

import com.epf.model.Zombie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ZombieRepositoryImplTest {

    private JdbcTemplate jdbcTemplate;
    private ZombieRepositoryImpl zombieRepository;

    @BeforeEach
    public void setup() {
        jdbcTemplate = mock(JdbcTemplate.class);
        zombieRepository = new ZombieRepositoryImpl(jdbcTemplate);
    }

    @Test
    public void FindAll() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of(new Zombie()));
        List<Zombie> result = zombieRepository.findAll();
        assertEquals(1, result.size());
        verify(jdbcTemplate).query(eq("SELECT * FROM zombie"), any(RowMapper.class));
    }

    @Test
    public void FindById() {
        Zombie mockZombie = new Zombie();
        mockZombie.setIdZombie(1L);

        when(jdbcTemplate.queryForObject(eq("SELECT * FROM zombie WHERE id_zombie = ?"), any(Object[].class), any(RowMapper.class)))
                .thenReturn(mockZombie);

        Zombie result = zombieRepository.findById(1L);
        assertEquals(1L, result.getIdZombie());
    }

    @Test
    public void Save() {
        Zombie zombie = new Zombie();
        zombie.setIdZombie(1L);
        zombie.setNom("Zombie Test");
        zombie.setPointDeVie(100);
        zombie.setAttaqueParSeconde(1.0);
        zombie.setDegatAttaque(10);
        zombie.setVitesseDeDeplacement(2.0);
        zombie.setCheminImage("zombie.png");
        zombie.setIdMap(2L);

        zombieRepository.save(zombie);

        verify(jdbcTemplate).update(anyString(), eq(1L), eq("Zombie Test"), eq(100), eq(1.0), eq(10), eq(2.0), eq("zombie.png"), eq(2L));
    }

    @Test
    public void Update() {
        Zombie zombie = new Zombie();
        zombie.setIdZombie(1L);
        zombie.setNom("Updated Zombie");
        zombie.setPointDeVie(150);
        zombie.setAttaqueParSeconde(1.5);
        zombie.setDegatAttaque(15);
        zombie.setVitesseDeDeplacement(1.5);
        zombie.setCheminImage("updated.png");
        zombie.setIdMap(3L);

        zombieRepository.update(zombie);

        verify(jdbcTemplate).update(anyString(), eq("Updated Zombie"), eq(150), eq(1.5), eq(15), eq(1.5), eq("updated.png"), eq(3L), eq(1L));
    }

    @Test
    public void Delete() {
        zombieRepository.delete(1L);
        verify(jdbcTemplate).update("DELETE FROM zombie WHERE id_zombie = ?", 1L);
    }

    @Test
    public void FindByMapId() {
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(RowMapper.class)))
                .thenReturn(List.of(new Zombie()));

        List<Zombie> result = zombieRepository.findByMapId(2L);
        assertEquals(1, result.size());
        verify(jdbcTemplate).query(eq("SELECT * FROM zombie WHERE id_map = ?"), eq(new Object[]{2L}), any(RowMapper.class));
    }
}
