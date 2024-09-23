package com.stylo.backend.repository;

import com.stylo.backend.model.Sucursal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SucursalRepository {

    private final JdbcTemplate jdbcTemplate;

    public SucursalRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapeo de los resultados SQL a un objeto Sucursal
    private RowMapper<Sucursal> rowMapper = new RowMapper<Sucursal>() {
        @Override
        public Sucursal mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sucursal sucursal = new Sucursal();
            sucursal.setId(rs.getInt("ID"));
            sucursal.setNombre(rs.getString("NOMBRE"));
            sucursal.setDireccion(rs.getString("DIRECCION"));
            return sucursal;
        }
    };

    // Obtener todas las sucursales
    public List<Sucursal> findAll() {
        String sql = "SELECT * FROM SUCURSALES";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Buscar una sucursal por ID
    @SuppressWarnings("deprecation")
    public Sucursal findById(int id) {
        String sql = "SELECT * FROM SUCURSALES WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    // Crear una nueva sucursal
    public void save(Sucursal sucursal) {
        String sql = "INSERT INTO SUCURSALES (NOMBRE, DIRECCION) VALUES (?, ?)";
        jdbcTemplate.update(sql, sucursal.getNombre(), sucursal.getDireccion());
    }

    // Actualizar una sucursal
    public void update(int id, Sucursal sucursal) {
        String sql = "UPDATE SUCURSALES SET NOMBRE = ?, DIRECCION = ? WHERE ID = ?";
        jdbcTemplate.update(sql, sucursal.getNombre(), sucursal.getDireccion(), id);
    }

    // Eliminar una sucursal
    public void delete(int id) {
        String sql = "DELETE FROM SUCURSALES WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
