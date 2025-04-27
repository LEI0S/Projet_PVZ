package com.epf.controller;

import com.epf.dto.ZombieDTO;
import com.epf.model.Zombie;
import com.epf.service.ZombieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/zombies")
public class ZombieController {

    private final ZombieService zombieService;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    // Get all zombies
    @GetMapping
    public List<ZombieDTO> getAllZombies() {
        List<Zombie> zombies = zombieService.getAllZombies();
        return zombies.stream()
                .map(zombie -> new ZombieDTO(
                        zombie.getIdZombie(),
                        zombie.getNom(),
                        zombie.getPointDeVie(),
                        zombie.getAttaqueParSeconde(),
                        zombie.getDegatAttaque(),
                        zombie.getVitesseDeDeplacement(),
                        zombie.getCheminImage(),
                        zombie.getIdMap()
                ))
                .collect(Collectors.toList());
    }

    // Get a zombie by its ID
    @GetMapping("/{idZombie}")
    public ZombieDTO getZombieById(@PathVariable Long idZombie) {
        Zombie zombie = zombieService.getZombieById(idZombie);
        return new ZombieDTO(
                zombie.getIdZombie(),
                zombie.getNom(),
                zombie.getPointDeVie(),
                zombie.getAttaqueParSeconde(),
                zombie.getDegatAttaque(),
                zombie.getVitesseDeDeplacement(),
                zombie.getCheminImage(),
                zombie.getIdMap()
        );
    }

    // Add a new zombie
    @PostMapping
    public void addZombie(@RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = new Zombie(
                zombieDTO.getIdZombie(),
                zombieDTO.getNom(),
                zombieDTO.getIdMap()
        );
        zombie.setPointDeVie(zombieDTO.getPointDeVie());
        zombie.setAttaqueParSeconde(zombieDTO.getAttaqueParSeconde());
        zombie.setDegatAttaque(zombieDTO.getDegatAttaque());
        zombie.setVitesseDeDeplacement(zombieDTO.getVitesseDeDeplacement());
        zombie.setCheminImage(zombieDTO.getCheminImage());

        zombieService.addZombie(zombie);
    }

    // Update an existing zombie
    @PutMapping("/{idZombie}")
    public void updateZombie(@PathVariable Long idZombie, @RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = new Zombie(
                idZombie,
                zombieDTO.getNom(),
                zombieDTO.getIdMap()
        );
        zombie.setPointDeVie(zombieDTO.getPointDeVie());
        zombie.setAttaqueParSeconde(zombieDTO.getAttaqueParSeconde());
        zombie.setDegatAttaque(zombieDTO.getDegatAttaque());
        zombie.setVitesseDeDeplacement(zombieDTO.getVitesseDeDeplacement());
        zombie.setCheminImage(zombieDTO.getCheminImage());

        zombieService.updateZombie(zombie);
    }

    // Delete a zombie by its ID
    @DeleteMapping("/{idZombie}")
    public void deleteZombie(@PathVariable Long idZombie) {
        zombieService.deleteZombie(idZombie);
    }

    // Get zombies by map ID
    @GetMapping("/map/{mapId}")
    public List<ZombieDTO> getZombiesByMapId(@PathVariable Long mapId) {
        List<Zombie> zombies = zombieService.getZombiesByMapId(mapId);
        return zombies.stream()
                .map(zombie -> new ZombieDTO(
                        zombie.getIdZombie(),
                        zombie.getNom(),
                        zombie.getPointDeVie(),
                        zombie.getAttaqueParSeconde(),
                        zombie.getDegatAttaque(),
                        zombie.getVitesseDeDeplacement(),
                        zombie.getCheminImage(),
                        zombie.getIdMap()
                ))
                .collect(Collectors.toList());
    }
}
