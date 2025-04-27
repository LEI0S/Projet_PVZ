package com.epf.repository;

import com.epf.model.Plante;
import java.util.List;

public interface PlanteRepository {

    // Find all plants
    List<Plante> findAll();

    // Find a plant by its ID
    Plante findById(Long id);

    // Save a new plant
    void save(Plante plante);

    // Update an existing plant
    void update(Plante plante);

    // Delete a plant by its ID
    void delete(Long id);
}
