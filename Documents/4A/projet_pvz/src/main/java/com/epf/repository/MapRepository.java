package com.epf.repository;

import com.epf.model.Map;
import java.util.List;

public interface MapRepository {

    // Find all maps
    List<Map> findAll();

    // Find a map by its ID
    Map findById(Long id);

    // Save a new map
    void save(Map map);

    // Update an existing map
    void update(Map map);

    // Delete a map by its ID
    void delete(Long id);
}
