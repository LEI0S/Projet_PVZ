package com.epf.repository.impl;

import com.epf.model.Plante;
import com.epf.repository.PlanteRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanteRepositoryImpl implements PlanteRepository {

    private final JdbcTemplate jdbcTemplate;

    public PlanteRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Plante> findAll() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Plante plante = new Plante();
            plante.setIdPlante(rs.getLong("id_plante"));
            plante.setNom(rs.getString("nom"));
            plante.setPointDeVie(rs.getInt("point_de_vie"));
            plante.setAttaqueParSeconde(rs.getDouble("attaque_par_seconde"));
            plante.setDegatAttaque(rs.getInt("degat_attaque"));
            plante.setCout(rs.getInt("cout"));
            plante.setSoleilParSeconde(rs.getDouble("soleil_par_seconde"));
            plante.setEffet(rs.getString("effet"));
            plante.setCheminImage(rs.getString("chemin_image"));
            return plante;
        });
    }

    @Override
    public Plante findById(Long id) {
        String sql = "SELECT * FROM plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Plante plante = new Plante();
            plante.setIdPlante(rs.getLong("id_plante"));
            plante.setNom(rs.getString("nom"));
            plante.setPointDeVie(rs.getInt("point_de_vie"));
            plante.setAttaqueParSeconde(rs.getDouble("attaque_par_seconde"));
            plante.setDegatAttaque(rs.getInt("degat_attaque"));
            plante.setCout(rs.getInt("cout"));
            plante.setSoleilParSeconde(rs.getDouble("soleil_par_seconde"));
            plante.setEffet(rs.getString("effet"));
            plante.setCheminImage(rs.getString("chemin_image"));
            return plante;
        });
    }

    @Override
    public void save(Plante plante) {
        String sql = "INSERT INTO plante (id_plante, nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, plante.getIdPlante(), plante.getNom(), plante.getPointDeVie(), plante.getAttaqueParSeconde(), plante.getDegatAttaque(), plante.getCout(), plante.getSoleilParSeconde(), plante.getEffet(), plante.getCheminImage());
    }

    @Override
    public void update(Plante plante) {
        String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPointDeVie(), plante.getAttaqueParSeconde(), plante.getDegatAttaque(), plante.getCout(), plante.getSoleilParSeconde(), plante.getEffet(), plante.getCheminImage(), plante.getIdPlante());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
    }
}
