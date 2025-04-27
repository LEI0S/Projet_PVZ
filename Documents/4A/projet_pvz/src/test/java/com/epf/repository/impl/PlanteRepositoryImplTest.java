package com.epf.repository.impl;

import com.epf.model.Plante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlanteRepositoryImplTest {

    private JdbcTemplate jdbcTemplate;
    private PlanteRepositoryImpl planteRepository;

    @BeforeEach
    public void setup() {
        jdbcTemplate = mock(JdbcTemplate.class);
        planteRepository = new PlanteRepositoryImpl(jdbcTemplate);
    }

    @Test
    public void FindAll() {
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of(new Plante()));
        List<Plante> result = planteRepository.findAll();
        assertEquals(1, result.size());
        verify(jdbcTemplate).query(eq("SELECT * FROM plante"), any(RowMapper.class));
    }

    @Test
    public void FindById() {
        Plante mockPlante = new Plante();
        mockPlante.setIdPlante(1L);
        mockPlante.setNom("Tournesol");

        when(jdbcTemplate.queryForObject(eq("SELECT * FROM plante WHERE id_plante = ?"),
                any(Object[].class), any(RowMapper.class))).thenReturn(mockPlante);

        Plante result = planteRepository.findById(1L);
        assertEquals(1L, result.getIdPlante());
        assertEquals("Tournesol", result.getNom());
    }

    @Test
    public void Save() {
        Plante plante = new Plante();
        plante.setIdPlante(1L);
        plante.setNom("Pisto-pois");
        plante.setPointDeVie(100);
        plante.setAttaqueParSeconde(1.0);
        plante.setDegatAttaque(20);
        plante.setCout(50);
        plante.setSoleilParSeconde(0);
        plante.setEffet("tir");
        plante.setCheminImage("pisto-pois.png");

        planteRepository.save(plante);

        verify(jdbcTemplate).update(eq("INSERT INTO plante (id_plante, nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"),
                eq(1L), eq("Pisto-pois"), eq(100), eq(1.0), eq(20), eq(50), eq(0.0), eq("tir"), eq("pisto-pois.png"));
    }

    @Test
    public void Update() {
        Plante plante = new Plante();
        plante.setIdPlante(2L);
        plante.setNom("Plante gel");
        plante.setPointDeVie(80);
        plante.setAttaqueParSeconde(0.8);
        plante.setDegatAttaque(15);
        plante.setCout(75);
        plante.setSoleilParSeconde(0);
        plante.setEffet("ralentit");
        plante.setCheminImage("plante-gel.png");

        planteRepository.update(plante);

        verify(jdbcTemplate).update(eq("UPDATE plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?"),
                eq("Plante gel"), eq(80), eq(0.8), eq(15), eq(75), eq(0.0), eq("ralentit"), eq("plante-gel.png"), eq(2L));
    }

    @Test
    public void Delete() {
        planteRepository.delete(3L);
        verify(jdbcTemplate).update(eq("DELETE FROM plante WHERE id_plante = ?"), eq(3L));
    }
}
