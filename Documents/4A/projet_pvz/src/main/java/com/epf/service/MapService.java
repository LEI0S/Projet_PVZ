package com.epf.service;

import com.epf.model.Map;
import java.util.List;

public interface MapService {
    List<Map> getAllMaps();
    Map getMapById(Long idMap);
    void addMap(Map map);
    void updateMap(Map map);
    void deleteMap(Long idMap);
}
