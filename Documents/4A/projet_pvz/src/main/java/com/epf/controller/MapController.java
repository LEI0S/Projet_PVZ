package com.epf.controller;

import com.epf.dto.MapDTO;
import com.epf.model.Map;
import com.epf.service.MapService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/maps")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    // Get all maps
    @GetMapping
    public List<MapDTO> getAllMaps() {
        List<Map> maps = mapService.getAllMaps();
        return maps.stream()
                .map(map -> new MapDTO(
                        map.getIdMap(),
                        map.getLigne(),
                        map.getColonne(),
                        map.getCheminImage()
                ))
                .collect(Collectors.toList());
    }

    // Get a map by its ID
    @GetMapping("/{idMap}")
    public MapDTO getMapById(@PathVariable Long idMap) {
        Map map = mapService.getMapById(idMap);
        return new MapDTO(
                map.getIdMap(),
                map.getLigne(),
                map.getColonne(),
                map.getCheminImage()
        );
    }

    // Add a new map
    @PostMapping
    public void addMap(@RequestBody MapDTO mapDTO) {
        Map map = new Map(
                mapDTO.getIdMap(),
                mapDTO.getLigne(),
                mapDTO.getColonne(),
                mapDTO.getCheminImage()
        );

        mapService.addMap(map);
    }

    // Update an existing map
    @PutMapping("/{idMap}")
    public void updateMap(@PathVariable Long idMap, @RequestBody MapDTO mapDTO) {
        Map map = new Map(
                idMap,
                mapDTO.getLigne(),
                mapDTO.getColonne(),
                mapDTO.getCheminImage()
        );

        mapService.updateMap(map);
    }

    // Delete a map by its ID
    @DeleteMapping("/{idMap}")
    public void deleteMap(@PathVariable Long idMap) {
        mapService.deleteMap(idMap);
    }
}
