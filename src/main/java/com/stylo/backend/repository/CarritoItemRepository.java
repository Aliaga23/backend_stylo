package com.stylo.backend.repository;

import com.stylo.backend.model.CarritoItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarritoItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public CarritoItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<CarritoItem> carritoItemRowMapper = (rs, rowNum) -> {
        CarritoItem carritoItem = new CarritoItem();
        carritoItem.setId(rs.getInt("ID"));
        carritoItem.setCarritoId(rs.getInt("CARRITO_ID"));
        carritoItem.setProductoId(rs.getInt("PRODUCTO_ID"));
        carritoItem.setCantidad(rs.getInt("CANTIDAD"));
        carritoItem.setPrecioUnitario(rs.getDouble("PRECIO_UNITARIO"));
        return carritoItem;
    };

    public List<CarritoItem> findAll() {
        return jdbcTemplate.query("SELECT * FROM CARRITO_ITEMS", carritoItemRowMapper);
    }

    public CarritoItem findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM CARRITO_ITEMS WHERE ID = ?", carritoItemRowMapper, id);
    }

    public void save(CarritoItem carritoItem) {
        jdbcTemplate.update("INSERT INTO CARRITO_ITEMS (CARRITO_ID, PRODUCTO_ID, CANTIDAD, PRECIO_UNITARIO) VALUES (?, ?, ?, ?)",
                carritoItem.getCarritoId(), carritoItem.getProductoId(), carritoItem.getCantidad(), carritoItem.getPrecioUnitario());
    }

    public void update(int id, CarritoItem carritoItem) {
        jdbcTemplate.update("UPDATE CARRITO_ITEMS SET CARRITO_ID = ?, PRODUCTO_ID = ?, CANTIDAD = ?, PRECIO_UNITARIO = ? WHERE ID = ?",
                carritoItem.getCarritoId(), carritoItem.getProductoId(), carritoItem.getCantidad(), carritoItem.getPrecioUnitario(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM CARRITO_ITEMS WHERE ID = ?", id);
    }
}
