package com.stylo.backend.repository;

import com.stylo.backend.model.Reserva;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaRepository {

    private final JdbcTemplate jdbcTemplate;

    public ReservaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Reserva> reservaRowMapper = (rs, rowNum) -> {
        Reserva reserva = new Reserva();
        reserva.setId(rs.getInt("ID"));
        reserva.setUsuarioId(rs.getInt("USUARIO_ID"));
        reserva.setProductoId(rs.getInt("PRODUCTO_ID"));
        reserva.setFechaReserva(rs.getTimestamp("FECHA_RESERVA").toLocalDateTime());
        reserva.setFechaLimite(rs.getTimestamp("FECHA_LIMITE") != null ? rs.getTimestamp("FECHA_LIMITE").toLocalDateTime() : null);
        reserva.setEstado(rs.getString("ESTADO"));
        return reserva;
    };

    public List<Reserva> findAll() {
        return jdbcTemplate.query("SELECT * FROM RESERVAS", reservaRowMapper);
    }

    public Reserva findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM RESERVAS WHERE ID = ?", reservaRowMapper, id);
    }

    public void save(Reserva reserva) {
        jdbcTemplate.update("INSERT INTO RESERVAS (USUARIO_ID, PRODUCTO_ID, FECHA_RESERVA, FECHA_LIMITE, ESTADO) VALUES (?, ?, ?, ?, ?)",
                reserva.getUsuarioId(), reserva.getProductoId(), reserva.getFechaReserva(), reserva.getFechaLimite(), reserva.getEstado());
    }

    public void update(int id, Reserva reserva) {
        jdbcTemplate.update("UPDATE RESERVAS SET USUARIO_ID = ?, PRODUCTO_ID = ?, FECHA_RESERVA = ?, FECHA_LIMITE = ?, ESTADO = ? WHERE ID = ?",
                reserva.getUsuarioId(), reserva.getProductoId(), reserva.getFechaReserva(), reserva.getFechaLimite(), reserva.getEstado(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM RESERVAS WHERE ID = ?", id);
    }
}
