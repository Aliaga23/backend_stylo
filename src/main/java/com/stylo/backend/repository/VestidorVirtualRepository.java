package com.stylo.backend.repository;

import com.stylo.backend.model.VestidorVirtual;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VestidorVirtualRepository {

    private final JdbcTemplate jdbcTemplate;

    public VestidorVirtualRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<VestidorVirtual> vestidorRowMapper = (rs, rowNum) -> {
        VestidorVirtual vestidor = new VestidorVirtual();
        vestidor.setId(rs.getInt("ID"));
        vestidor.setUsuarioId(rs.getInt("USUARIO_ID"));
        vestidor.setProductoId(rs.getInt("PRODUCTO_ID"));
        vestidor.setFecha(rs.getTimestamp("FECHA").toLocalDateTime());
        return vestidor;
    };

    public List<VestidorVirtual> findAll() {
        return jdbcTemplate.query("SELECT * FROM VESTIDORES_VIRTUALES", vestidorRowMapper);
    }

    public VestidorVirtual findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM VESTIDORES_VIRTUALES WHERE ID = ?", vestidorRowMapper, id);
    }

    public void save(VestidorVirtual vestidor) {
        jdbcTemplate.update("INSERT INTO VESTIDORES_VIRTUALES (USUARIO_ID, PRODUCTO_ID, FECHA) VALUES (?, ?, ?)",
                vestidor.getUsuarioId(), vestidor.getProductoId(), vestidor.getFecha());
    }

    public void update(int id, VestidorVirtual vestidor) {
        jdbcTemplate.update("UPDATE VESTIDORES_VIRTUALES SET USUARIO_ID = ?, PRODUCTO_ID = ?, FECHA = ? WHERE ID = ?",
                vestidor.getUsuarioId(), vestidor.getProductoId(), vestidor.getFecha(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM VESTIDORES_VIRTUALES WHERE ID = ?", id);
    }
}
