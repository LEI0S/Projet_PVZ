package com.epf.controller;

import com.epf.dto.PlanteDTO;
import com.epf.model.Plante;
import com.epf.service.PlanteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/plantes")
public class PlanteController {

    private final PlanteService planteService;

    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    // Get all plants
    @GetMapping
    public List<PlanteDTO> getAllPlantes() {
        List<Plante> plantes = planteService.getAllPlantes();
        return plantes.stream()
                .map(plante -> new PlanteDTO(
                        plante.getIdPlante(),
                        plante.getNom(),
                        plante.getPointDeVie(),
                        plante.getAttaqueParSeconde(),
                        plante.getDegatAttaque(),
                        plante.getCout(),
                        plante.getSoleilParSeconde(),
                        plante.getEffet(),
                        plante.getCheminImage()
                ))
                .collect(Collectors.toList());
    }

    // Get a plant by its ID
    @GetMapping("/{idPlante}")
    public PlanteDTO getPlanteById(@PathVariable Long idPlante) {
        Plante plante = planteService.getPlanteById(idPlante);
        return new PlanteDTO(
                plante.getIdPlante(),
                plante.getNom(),
                plante.getPointDeVie(),
                plante.getAttaqueParSeconde(),
                plante.getDegatAttaque(),
                plante.getCout(),
                plante.getSoleilParSeconde(),
                plante.getEffet(),
                plante.getCheminImage()
        );
    }

    // Add a new plant
    @PostMapping
    public void addPlante(@RequestBody PlanteDTO planteDTO) {
        Plante plante = new Plante(
                planteDTO.getIdPlante(),
                planteDTO.getNom(),
                planteDTO.getPointDeVie(),
                planteDTO.getAttaqueParSeconde(),
                planteDTO.getDegatAttaque(),
                planteDTO.getCout(),
                planteDTO.getSoleilParSeconde(),
                planteDTO.getEffet(),
                planteDTO.getCheminImage()
        );

        planteService.addPlante(plante);
    }

    // Update an existing plant
    @PutMapping("/{idPlante}")
    public void updatePlante(@PathVariable Long idPlante, @RequestBody PlanteDTO planteDTO) {
        Plante plante = new Plante(
                idPlante,
                planteDTO.getNom(),
                planteDTO.getPointDeVie(),
                planteDTO.getAttaqueParSeconde(),
                planteDTO.getDegatAttaque(),
                planteDTO.getCout(),
                planteDTO.getSoleilParSeconde(),
                planteDTO.getEffet(),
                planteDTO.getCheminImage()
        );

        planteService.updatePlante(plante);
    }

    // Delete a plant by its ID
    @DeleteMapping("/{idPlante}")
    public void deletePlante(@PathVariable Long idPlante) {
        planteService.deletePlante(idPlante);
    }
}
