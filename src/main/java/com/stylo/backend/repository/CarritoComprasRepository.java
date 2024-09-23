package com.stylo.backend.repository;

import com.stylo.backend.model.CarritoCompras;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarritoComprasRepository {

    private final JdbcTemplate jdbcTemplate;

    public CarritoComprasRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapeo de los resultados SQL a un objeto CarritoCompras
    private RowMapper<CarritoCompras> rowMapper = new RowMapper<CarritoCompras>() {
        @Override
        public CarritoCompras mapRow(ResultSet rs, int rowNum) throws SQLException {
            CarritoCompras carrito = new CarritoCompras();
            carrito.setId(rs.getInt("ID"));
            carrito.setUsuarioId(rs.getInt("USUARIO_ID"));
            carrito.setTotal(rs.getDouble("TOTAL"));
            carrito.setFecha(rs.getTimestamp("FECHA"));
            return carrito;
        }
    };

    // Obtener todos los carritos
    public List<CarritoCompras> findAll() {
        String sql = "SELECT * FROM CARRITO_COMPRAS";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Buscar un carrito por ID
    @SuppressWarnings("deprecation")
    public CarritoCompras findById(int id) {
        String sql = "SELECT * FROM CARRITO_COMPRAS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    // Crear un nuevo carrito
    public void save(CarritoCompras carrito) {
        String sql = "INSERT INTO CARRITO_COMPRAS (USUARIO_ID, TOTAL) VALUES (?, ?)";
        jdbcTemplate.update(sql, carrito.getUsuarioId(), carrito.getTotal());
    }

    // Actualizar un carrito
    public void update(int id, CarritoCompras carrito) {
        String sql = "UPDATE CARRITO_COMPRAS SET USUARIO_ID = ?, TOTAL = ?, FECHA = CURRENT_TIMESTAMP WHERE ID = ?";
        jdbcTemplate.update(sql, carrito.getUsuarioId(), carrito.getTotal(), id);
    }

    // Eliminar un carrito
    public void delete(int id) {
        String sql = "DELETE FROM CARRITO_COMPRAS WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
