package com.epf.service.impl;

import com.epf.model.Map;
import com.epf.repository.MapRepository;
import com.epf.service.MapService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MapServiceImpl implements MapService {

    private final MapRepository mapRepository;

    public MapServiceImpl(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public List<Map> getAllMaps() {
        return mapRepository.findAll();
    }

    @Override
    public Map getMapById(Long id) {
        return mapRepository.findById(id);
    }

    @Override
    public void addMap(Map map) {
        mapRepository.save(map);
    }

    @Override
    public void updateMap(Map map) {
        mapRepository.update(map);
    }

    @Override
    public void deleteMap(Long id) {
        mapRepository.delete(id);
    }
}
