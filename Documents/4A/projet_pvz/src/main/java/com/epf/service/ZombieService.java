package com.epf.service;

import com.epf.model.Zombie;
import java.util.List;

public interface ZombieService {
    List<Zombie> getAllZombies();
    Zombie getZombieById(Long idZombie);
    void addZombie(Zombie zombie);
    void updateZombie(Zombie zombie);
    void deleteZombie(Long idZombie);
    List<Zombie> getZombiesByMapId(Long mapId);
}
