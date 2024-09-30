package com.stylo.backend.repository;

import com.stylo.backend.model.Inventario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InventarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public InventarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapeo de los resultados SQL a un objeto Inventario
    private RowMapper<Inventario> rowMapper = new RowMapper<Inventario>() {
        @Override
        public Inventario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Inventario inventario = new Inventario();
            inventario.setId(rs.getInt("ID"));
            inventario.setProductoId(rs.getInt("PRODUCTO_ID"));
            inventario.setSucursalId(rs.getInt("SUCURSAL_ID"));
            inventario.setCantidadDisponible(rs.getInt("CANTIDAD_DISPONIBLE"));
            inventario.setFechaUltimaActualizacion(rs.getTimestamp("FECHA_ULTIMA_ACTUALIZACION"));
            return inventario;
        }
    };

    // Obtener todos los registros de inventario
    public List<Inventario> findAll() {
        String sql = "SELECT * FROM INVENTARIO";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Buscar un registro de inventario por ID
    @SuppressWarnings("deprecation")
    public Inventario findById(int id) {
        String sql = "SELECT * FROM INVENTARIO WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    // Crear un nuevo registro de inventario
    public void save(Inventario inventario) {
        String sql = "INSERT INTO INVENTARIO (PRODUCTO_ID, SUCURSAL_ID, CANTIDAD_DISPONIBLE) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, inventario.getProductoId(), inventario.getSucursalId(), inventario.getCantidadDisponible());
    }

    // Actualizar un registro de inventario
    public void update(int id, Inventario inventario) {
        String sql = "UPDATE INVENTARIO SET PRODUCTO_ID = ?, SUCURSAL_ID = ?, CANTIDAD_DISPONIBLE = ?, " +
                     "FECHA_ULTIMA_ACTUALIZACION = CURRENT_TIMESTAMP WHERE ID = ?";
        jdbcTemplate.update(sql, inventario.getProductoId(), inventario.getSucursalId(), inventario.getCantidadDisponible(), id);
    }

    // Eliminar un registro de inventario
    public void delete(int id) {
        String sql = "DELETE FROM INVENTARIO WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}