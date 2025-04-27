package com.epf.repository.impl;

import com.epf.model.Zombie;
import com.epf.repository.ZombieRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZombieRepositoryImpl implements ZombieRepository {

    private final JdbcTemplate jdbcTemplate;

    public ZombieRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Zombie> findAll() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Zombie zombie = new Zombie();
            zombie.setIdZombie(rs.getLong("id_zombie"));
            zombie.setNom(rs.getString("nom"));
            zombie.setPointDeVie(rs.getInt("point_de_vie"));
            zombie.setAttaqueParSeconde(rs.getDouble("attaque_par_seconde"));
            zombie.setDegatAttaque(rs.getInt("degat_attaque"));
            zombie.setVitesseDeDeplacement(rs.getDouble("vitesse_de_deplacement"));
            zombie.setCheminImage(rs.getString("chemin_image"));
            zombie.setIdMap(rs.getLong("id_map"));
            return zombie;
        });
    }

    @Override
    public Zombie findById(Long id) {
        String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Zombie zombie = new Zombie();
            zombie.setIdZombie(rs.getLong("id_zombie"));
            zombie.setNom(rs.getString("nom"));
            zombie.setPointDeVie(rs.getInt("point_de_vie"));
            zombie.setAttaqueParSeconde(rs.getDouble("attaque_par_seconde"));
            zombie.setDegatAttaque(rs.getInt("degat_attaque"));
            zombie.setVitesseDeDeplacement(rs.getDouble("vitesse_de_deplacement"));
            zombie.setCheminImage(rs.getString("chemin_image"));
            zombie.setIdMap(rs.getLong("id_map"));
            return zombie;
        });
    }

    @Override
    public void save(Zombie zombie) {
        String sql = "INSERT INTO zombie (id_zombie, nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getIdZombie(), zombie.getNom(), zombie.getPointDeVie(), zombie.getAttaqueParSeconde(), zombie.getDegatAttaque(), zombie.getVitesseDeDeplacement(), zombie.getCheminImage(), zombie.getIdMap());
    }

    @Override
    public void update(Zombie zombie) {
        String sql = "UPDATE zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPointDeVie(), zombie.getAttaqueParSeconde(), zombie.getDegatAttaque(), zombie.getVitesseDeDeplacement(), zombie.getCheminImage(), zombie.getIdMap(), zombie.getIdZombie());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Zombie> findByMapId(Long mapId) {
        String sql = "SELECT * FROM zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new Object[]{mapId}, (rs, rowNum) -> {
            Zombie zombie = new Zombie();
            zombie.setIdZombie(rs.getLong("id_zombie"));
            zombie.setNom(rs.getString("nom"));
            zombie.setPointDeVie(rs.getInt("point_de_vie"));
            zombie.setAttaqueParSeconde(rs.getDouble("attaque_par_seconde"));
            zombie.setDegatAttaque(rs.getInt("degat_attaque"));
            zombie.setVitesseDeDeplacement(rs.getDouble("vitesse_de_deplacement"));
            zombie.setCheminImage(rs.getString("chemin_image"));
            zombie.setIdMap(rs.getLong("id_map"));
            return zombie;
        });
    }
}
