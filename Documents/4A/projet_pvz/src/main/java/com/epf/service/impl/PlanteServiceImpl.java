package com.epf.service.impl;

import com.epf.model.Plante;
import com.epf.repository.PlanteRepository;
import com.epf.service.PlanteService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlanteServiceImpl implements PlanteService {

    private final PlanteRepository planteRepository;

    public PlanteServiceImpl(PlanteRepository planteRepository) {
        this.planteRepository = planteRepository;
    }

    @Override
    public List<Plante> getAllPlantes() {
        return planteRepository.findAll();
    }

    @Override
    public Plante getPlanteById(Long id) {
        return planteRepository.findById(id);
    }

    @Override
    public void addPlante(Plante plante) {
        planteRepository.save(plante);
    }

    @Override
    public void updatePlante(Plante plante) {
        planteRepository.update(plante);
    }

    @Override
    public void deletePlante(Long id) {
        planteRepository.delete(id);
    }
}
