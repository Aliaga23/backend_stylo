package com.stylo.backend.repository;

import com.stylo.backend.model.MovimientoInventario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovimientoInventarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public MovimientoInventarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<MovimientoInventario> movimientoRowMapper = (rs, rowNum) -> {
        MovimientoInventario movimiento = new MovimientoInventario();
        movimiento.setId(rs.getInt("ID"));
        movimiento.setInventarioId(rs.getInt("INVENTARIO_ID"));
        movimiento.setTipoMovimiento(rs.getString("TIPO_MOVIMIENTO"));
        movimiento.setCantidad(rs.getInt("CANTIDAD"));
        movimiento.setFecha(rs.getTimestamp("FECHA").toLocalDateTime());
        movimiento.setDescripcion(rs.getString("DESCRIPCION"));
        return movimiento;
    };

    public List<MovimientoInventario> findAll() {
        return jdbcTemplate.query("SELECT * FROM MOVIMIENTOS_INVENTARIO", movimientoRowMapper);
    }

    public MovimientoInventario findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM MOVIMIENTOS_INVENTARIO WHERE ID = ?", movimientoRowMapper, id);
    }

    public void save(MovimientoInventario movimiento) {
        jdbcTemplate.update("INSERT INTO MOVIMIENTOS_INVENTARIO (INVENTARIO_ID, TIPO_MOVIMIENTO, CANTIDAD, FECHA, DESCRIPCION) VALUES (?, ?, ?, ?, ?)",
                movimiento.getInventarioId(), movimiento.getTipoMovimiento(), movimiento.getCantidad(), movimiento.getFecha(), movimiento.getDescripcion());
    }

    public void update(int id, MovimientoInventario movimiento) {
        jdbcTemplate.update("UPDATE MOVIMIENTOS_INVENTARIO SET INVENTARIO_ID = ?, TIPO_MOVIMIENTO = ?, CANTIDAD = ?, FECHA = ?, DESCRIPCION = ? WHERE ID = ?",
                movimiento.getInventarioId(), movimiento.getTipoMovimiento(), movimiento.getCantidad(), movimiento.getFecha(), movimiento.getDescripcion(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM MOVIMIENTOS_INVENTARIO WHERE ID = ?", id);
    }
}
