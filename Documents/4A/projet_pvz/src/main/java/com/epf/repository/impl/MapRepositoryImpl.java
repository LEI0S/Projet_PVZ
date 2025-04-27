package com.epf.repository.impl;

import com.epf.model.Map;
import com.epf.repository.MapRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapRepositoryImpl implements MapRepository {

    private final JdbcTemplate jdbcTemplate;

    public MapRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map> findAll() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Map map = new Map();
            map.setIdMap(rs.getLong("id_map"));
            map.setLigne(rs.getInt("ligne"));
            map.setColonne(rs.getInt("colonne"));
            map.setCheminImage(rs.getString("chemin_image"));
            return map;
        });
    }

    @Override
    public Map findById(Long id) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Map map = new Map();
            map.setIdMap(rs.getLong("id_map"));
            map.setLigne(rs.getInt("ligne"));
            map.setColonne(rs.getInt("colonne"));
            map.setCheminImage(rs.getString("chemin_image"));
            return map;
        });
    }

    @Override
    public void save(Map map) {
        String sql = "INSERT INTO map (id_map, ligne, colonne, chemin_image) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, map.getIdMap(), map.getLigne(), map.getColonne(), map.getCheminImage());
    }

    @Override
    public void update(Map map) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage(), map.getIdMap());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM map WHERE id_map = ?";
        jdbcTemplate.update(sql, id);
    }
}
