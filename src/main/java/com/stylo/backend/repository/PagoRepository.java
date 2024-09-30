package com.stylo.backend.repository;

import com.stylo.backend.model.Pago;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class PagoRepository {

    private final JdbcTemplate jdbcTemplate;

    public PagoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Pago> pagoRowMapper = (rs, rowNum) -> {
        Pago pago = new Pago();
        pago.setId(rs.getInt("ID"));
        pago.setPedidoId(rs.getInt("PEDIDO_ID"));
        pago.setMetodoPago(rs.getString("METODO_PAGO"));
        pago.setMonto(rs.getDouble("MONTO"));
        pago.setFecha(rs.getTimestamp("FECHA").toLocalDateTime());
        return pago;
    };

    public List<Pago> findAll() {
        return jdbcTemplate.query("SELECT * FROM PAGOS", pagoRowMapper);
    }

    public Pago findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM PAGOS WHERE ID = ?", pagoRowMapper, id);
    }

    public void save(Pago pago) {
        jdbcTemplate.update("INSERT INTO PAGOS (PEDIDO_ID, METODO_PAGO, MONTO, FECHA) VALUES (?, ?, ?, ?)",
                pago.getPedidoId(), pago.getMetodoPago(), pago.getMonto(), pago.getFecha());
    }

    public void update(int id, Pago pago) {
        jdbcTemplate.update("UPDATE PAGOS SET PEDIDO_ID = ?, METODO_PAGO = ?, MONTO = ?, FECHA = ? WHERE ID = ?",
                pago.getPedidoId(), pago.getMetodoPago(), pago.getMonto(), pago.getFecha(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM PAGOS WHERE ID = ?", id);
    }
}
