package com.epf.service;

import com.epf.model.Plante;
import java.util.List;

public interface PlanteService {
    List<Plante> getAllPlantes();
    Plante getPlanteById(Long idPlante);
    void addPlante(Plante plante);
    void updatePlante(Plante plante);
    void deletePlante(Long idPlante);
}
