package com.stylo.backend.repository;

import com.stylo.backend.model.Permiso;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PermisoRepository {

    private final JdbcTemplate jdbcTemplate;

    public PermisoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Permiso> permisoRowMapper = (rs, rowNum) -> {
        Permiso permiso = new Permiso();
        permiso.setId(rs.getInt("ID"));
        permiso.setNombre(rs.getString("NOMBRE"));
        permiso.setDescripcion(rs.getString("DESCRIPCION"));
        return permiso;
    };

    public List<Permiso> findAll() {
        return jdbcTemplate.query("SELECT * FROM PERMISOS", permisoRowMapper);
    }

    public Permiso findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM PERMISOS WHERE ID = ?", permisoRowMapper, id);
    }

    public void save(Permiso permiso) {
        jdbcTemplate.update("INSERT INTO PERMISOS (NOMBRE, DESCRIPCION) VALUES (?, ?)",
                permiso.getNombre(), permiso.getDescripcion());
    }

    public void update(int id, Permiso permiso) {
        jdbcTemplate.update("UPDATE PERMISOS SET NOMBRE = ?, DESCRIPCION = ? WHERE ID = ?",
                permiso.getNombre(), permiso.getDescripcion(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM PERMISOS WHERE ID = ?", id);
    }
}
