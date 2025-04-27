package com.epf.service.impl;

import com.epf.model.Plante;
import com.epf.repository.PlanteRepository;
import com.epf.service.impl.PlanteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlanteServiceImplTest {

    @Mock
    private PlanteRepository planteRepository;

    @InjectMocks
    private PlanteServiceImpl planteService;

    @Test
    void getAllPlantes() {
        // GIVEN
        Plante p1 = new Plante(1L, "Tournesol");
        Plante p2 = new Plante(2L, "Pisto-pois");
        when(planteRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        // WHEN
        List<Plante> result = planteService.getAllPlantes();

        // THEN
        assertEquals(2, result.size());
        verify(planteRepository, times(1)).findAll();
    }

    @Test
    void getPlanteById() {
        // GIVEN
        Plante p = new Plante(1L, "Noix");
        when(planteRepository.findById(1L)).thenReturn(p);

        // WHEN
        Plante result = planteService.getPlanteById(1L);

        // THEN
        assertNotNull(result);
        assertEquals("Noix", result.getNom());
        verify(planteRepository).findById(1L);
    }

    @Test
    void addPlante() {
        // GIVEN
        Plante p = new Plante(3L, "Chardon");

        // WHEN
        planteService.addPlante(p);

        // THEN
        verify(planteRepository).save(p);
    }

    @Test
    void updatePlante() {
        // GIVEN
        Plante p = new Plante(4L, "Mur de Noix");

        // WHEN
        planteService.updatePlante(p);

        // THEN
        verify(planteRepository).update(p);
    }

    @Test
    void deletePlante() {
        // GIVEN
        Long id = 5L;

        // WHEN
        planteService.deletePlante(id);

        // THEN
        verify(planteRepository).delete(id);
    }
}
