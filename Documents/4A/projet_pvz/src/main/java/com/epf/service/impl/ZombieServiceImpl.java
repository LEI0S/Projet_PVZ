package com.epf.service.impl;
import com.epf.model.Zombie;
import com.epf.repository.ZombieRepository;
import com.epf.service.ZombieService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ZombieServiceImpl implements ZombieService {

    private final ZombieRepository zombieRepository;

    public ZombieServiceImpl(ZombieRepository zombieRepository) {
        this.zombieRepository = zombieRepository;
    }

    @Override
    public List<Zombie> getAllZombies() {
        return zombieRepository.findAll();
    }

    @Override
    public Zombie getZombieById(Long id) {
        return zombieRepository.findById(id);
    }

    @Override
    public void addZombie(Zombie zombie) {
        zombieRepository.save(zombie);
    }

    @Override
    public void updateZombie(Zombie zombie) {
        zombieRepository.update(zombie);
    }

    @Override
    public void deleteZombie(Long id) {
        zombieRepository.delete(id);
    }

    @Override
    public List<Zombie> getZombiesByMapId(Long mapId) {
        return zombieRepository.findByMapId(mapId);
    }
}
