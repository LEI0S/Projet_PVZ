package com.epf.controller;

import com.epf.dto.MapDTO;
import com.epf.model.Map;
import com.epf.service.MapService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MapController.class)
class MapControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MapService mapService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllMaps() throws Exception {
        Map map1 = new Map(1L, 5, 5, "img1.png");
        Map map2 = new Map(2L, 6, 6, "img2.png");

        when(mapService.getAllMaps()).thenReturn(Arrays.asList(map1, map2));

        mockMvc.perform(get("/api/maps"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].idMap").value(1L))
                .andExpect(jsonPath("$[1].colonne").value(6));
    }

    @Test
    void getMapById() throws Exception {
        Map map = new Map(1L, 3, 4, "map.png");

        when(mapService.getMapById(1L)).thenReturn(map);

        mockMvc.perform(get("/api/maps/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idMap").value(1))
                .andExpect(jsonPath("$.ligne").value(3))
                .andExpect(jsonPath("$.cheminImage").value("map.png"));
    }

    @Test
    void addMap() throws Exception {
        MapDTO mapDTO = new MapDTO(3L, 7, 7, "newmap.png");

        mockMvc.perform(post("/api/maps")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mapDTO)))
                .andExpect(status().isOk());

        verify(mapService, times(1)).addMap(any(Map.class));
    }

    @Test
    void updateMap() throws Exception {
        MapDTO mapDTO = new MapDTO(null, 10, 10, "updated.png");

        mockMvc.perform(put("/api/maps/5")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mapDTO)))
                .andExpect(status().isOk());

        verify(mapService).updateMap(argThat(map ->
                map.getIdMap() == 5L &&
                        map.getLigne() == 10 &&
                        map.getColonne() == 10 &&
                        "updated.png".equals(map.getCheminImage())
        ));
    }

    @Test
    void deleteMap() throws Exception {
        mockMvc.perform(delete("/api/maps/9"))
                .andExpect(status().isOk());

        verify(mapService).deleteMap(9L);
    }
}
