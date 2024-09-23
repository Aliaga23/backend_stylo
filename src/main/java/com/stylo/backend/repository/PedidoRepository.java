package com.stylo.backend.repository;

import com.stylo.backend.model.Pedido;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PedidoRepository {

    private final JdbcTemplate jdbcTemplate;

    public PedidoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapeo de los resultados SQL a un objeto Pedido
    private RowMapper<Pedido> rowMapper = new RowMapper<Pedido>() {
        @Override
        public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
            Pedido pedido = new Pedido();
            pedido.setId(rs.getInt("ID"));
            pedido.setUsuarioId(rs.getInt("USUARIO_ID"));
            pedido.setTotal(rs.getDouble("TOTAL"));
            pedido.setEstado(rs.getString("ESTADO"));
            pedido.setFecha(rs.getTimestamp("FECHA"));
            return pedido;
        }
    };

    // Obtener todos los pedidos
    public List<Pedido> findAll() {
        String sql = "SELECT * FROM PEDIDOS";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Buscar un pedido por ID
    @SuppressWarnings("deprecation")
    public Pedido findById(int id) {
        String sql = "SELECT * FROM PEDIDOS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    // Crear un nuevo pedido
    public void save(Pedido pedido) {
        String sql = "INSERT INTO PEDIDOS (USUARIO_ID, TOTAL, ESTADO) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, pedido.getUsuarioId(), pedido.getTotal(), pedido.getEstado());
    }

    // Actualizar un pedido
    public void update(int id, Pedido pedido) {
        String sql = "UPDATE PEDIDOS SET USUARIO_ID = ?, TOTAL = ?, ESTADO = ?, FECHA = CURRENT_TIMESTAMP WHERE ID = ?";
        jdbcTemplate.update(sql, pedido.getUsuarioId(), pedido.getTotal(), pedido.getEstado(), id);
    }

    // Eliminar un pedido
    public void delete(int id) {
        String sql = "DELETE FROM PEDIDOS WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
