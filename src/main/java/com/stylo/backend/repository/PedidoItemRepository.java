package com.stylo.backend.repository;

import com.stylo.backend.model.PedidoItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PedidoItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public PedidoItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<PedidoItem> pedidoItemRowMapper = (rs, rowNum) -> {
        PedidoItem pedidoItem = new PedidoItem();
        pedidoItem.setId(rs.getInt("ID"));
        pedidoItem.setPedidoId(rs.getInt("PEDIDO_ID"));
        pedidoItem.setProductoId(rs.getInt("PRODUCTO_ID"));
        pedidoItem.setCantidad(rs.getInt("CANTIDAD"));
        pedidoItem.setPrecioUnitario(rs.getDouble("PRECIO_UNITARIO"));
        return pedidoItem;
    };

    public List<PedidoItem> findAll() {
        return jdbcTemplate.query("SELECT * FROM PEDIDO_ITEMS", pedidoItemRowMapper);
    }

    public PedidoItem findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM PEDIDO_ITEMS WHERE ID = ?", pedidoItemRowMapper, id);
    }

    public void save(PedidoItem pedidoItem) {
        jdbcTemplate.update("INSERT INTO PEDIDO_ITEMS (PEDIDO_ID, PRODUCTO_ID, CANTIDAD, PRECIO_UNITARIO) VALUES (?, ?, ?, ?)",
                pedidoItem.getPedidoId(), pedidoItem.getProductoId(), pedidoItem.getCantidad(), pedidoItem.getPrecioUnitario());
    }

    public void update(int id, PedidoItem pedidoItem) {
        jdbcTemplate.update("UPDATE PEDIDO_ITEMS SET PEDIDO_ID = ?, PRODUCTO_ID = ?, CANTIDAD = ?, PRECIO_UNITARIO = ? WHERE ID = ?",
                pedidoItem.getPedidoId(), pedidoItem.getProductoId(), pedidoItem.getCantidad(), pedidoItem.getPrecioUnitario(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM PEDIDO_ITEMS WHERE ID = ?", id);
    }
}
