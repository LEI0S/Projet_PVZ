package com.epf.repository;

import com.epf.model.Zombie;
import java.util.List;

public interface ZombieRepository {

    // Find all zombies
    List<Zombie> findAll();

    // Find a zombie by its ID
    Zombie findById(Long id);

    // Save a new zombie
    void save(Zombie zombie);

    // Update an existing zombie
    void update(Zombie zombie);

    // Delete a zombie by its ID
    void delete(Long id);

    // Find zombies by map ID
    List<Zombie> findByMapId(Long mapId);
}

