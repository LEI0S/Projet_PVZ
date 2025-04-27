package com.epf.service.impl;

import com.epf.model.Map;
import com.epf.repository.MapRepository;
import com.epf.service.impl.MapServiceImpl;
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
public class MapServiceImplTest {

    @Mock
    private MapRepository mapRepository;

    @InjectMocks
    private MapServiceImpl mapService;

    @Test
    void getAllMaps() {
        // GIVEN
        Map map1 = new Map(1L, 5, 5, "img1.png");
        Map map2 = new Map(2L, 6, 6, "img2.png");
        when(mapRepository.findAll()).thenReturn(Arrays.asList(map1, map2));

        // WHEN
        List<Map> result = mapService.getAllMaps();

        // THEN
        assertEquals(2, result.size());
        verify(mapRepository, times(1)).findAll();
    }

    @Test
    void getMapById() {
        // GIVEN
        Map map = new Map(1L, 4, 4, "img3.png");
        when(mapRepository.findById(1L)).thenReturn(map);

        // WHEN
        Map result = mapService.getMapById(1L);

        // THEN
        assertNotNull(result);
        assertEquals(4, result.getLigne());
        verify(mapRepository).findById(1L);
    }

    @Test
    void addMap() {
        // GIVEN
        Map map = new Map(3L, 3, 3, "img-new.png");

        // WHEN
        mapService.addMap(map);

        // THEN
        verify(mapRepository).save(map);
    }

    @Test
    void updateMap() {
        // GIVEN
        Map map = new Map(4L, 2, 2, "img-update.png");

        // WHEN
        mapService.updateMap(map);

        // THEN
        verify(mapRepository).update(map);
    }

    @Test
    void deleteMap() {
        // GIVEN
        Long id = 5L;

        // WHEN
        mapService.deleteMap(id);

        // THEN
        verify(mapRepository).delete(id);
    }
}

