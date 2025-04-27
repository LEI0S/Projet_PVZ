package com.epf.repository.impl;

import com.epf.model.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MapRepositoryImplTest {

    private JdbcTemplate jdbcTemplate;
    private MapRepositoryImpl mapRepository;

    @BeforeEach
    public void setup() {
        jdbcTemplate = mock(JdbcTemplate.class);
        mapRepository = new MapRepositoryImpl(jdbcTemplate);
    }

    @Test
    public void FindAll() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of(new Map()));
        List<Map> result = mapRepository.findAll();
        assertEquals(1, result.size());
        verify(jdbcTemplate).query(eq("SELECT * FROM map"), any(RowMapper.class));
    }

    @Test
    public void FindById() {
        Map mockMap = new Map();
        mockMap.setIdMap(1L);
        mockMap.setLigne(5);
        mockMap.setColonne(9);
        mockMap.setCheminImage("map.png");

        when(jdbcTemplate.queryForObject(eq("SELECT * FROM map WHERE id_map = ?"), any(Object[].class), any(RowMapper.class)))
                .thenReturn(mockMap);

        Map result = mapRepository.findById(1L);
        assertEquals(1L, result.getIdMap());
        assertEquals(5, result.getLigne());
        assertEquals(9, result.getColonne());
        assertEquals("map.png", result.getCheminImage());
    }

    @Test
    public void Save() {
        Map map = new Map();
        map.setIdMap(1L);
        map.setLigne(5);
        map.setColonne(9);
        map.setCheminImage("map.png");

        mapRepository.save(map);

        verify(jdbcTemplate).update(eq("INSERT INTO map (id_map, ligne, colonne, chemin_image) VALUES (?, ?, ?, ?)"),
                eq(1L), eq(5), eq(9), eq("map.png"));
    }

    @Test
    public void Update() {
        Map map = new Map();
        map.setIdMap(1L);
        map.setLigne(6);
        map.setColonne(10);
        map.setCheminImage("updated.png");

        mapRepository.update(map);

        verify(jdbcTemplate).update(eq("UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?"),
                eq(6), eq(10), eq("updated.png"), eq(1L));
    }

    @Test
    public void Delete() {
        mapRepository.delete(1L);
        verify(jdbcTemplate).update(eq("DELETE FROM map WHERE id_map = ?"), eq(1L));
    }
}
