package com.stylo.backend.repository;

import com.stylo.backend.model.Producto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapeo de los resultados SQL a un objeto Producto
    private RowMapper<Producto> rowMapper = new RowMapper<Producto>() {
        @Override
        public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Producto producto = new Producto();
            producto.setId(rs.getInt("ID"));
            producto.setNombre(rs.getString("NOMBRE"));
            producto.setDescripcion(rs.getString("DESCRIPCION"));
            producto.setPrecio(rs.getDouble("PRECIO"));
            producto.setTalla(rs.getString("TALLA"));
            producto.setTipoPrenda(rs.getString("TIPO_PRENDA"));
            producto.setColor(rs.getString("COLOR"));
            producto.setMedidas(rs.getString("MEDIDAS"));
            producto.setCategoriaId(rs.getInt("CATEGORIA_ID"));
            producto.setStock(rs.getInt("STOCK"));
            producto.setSucursalId(rs.getInt("SUCURSAL_ID"));
            return producto;
        }
    };

    // Obtener todos los productos
    public List<Producto> findAll() {
        String sql = "SELECT * FROM PRODUCTOS";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Buscar un producto por ID
    @SuppressWarnings("deprecation")
    public Producto findById(int id) {
        String sql = "SELECT * FROM PRODUCTOS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    // Crear un nuevo producto
    public void save(Producto producto) {
        String sql = "INSERT INTO PRODUCTOS (NOMBRE, DESCRIPCION, PRECIO, TALLA, TIPO_PRENDA, COLOR, MEDIDAS, CATEGORIA_ID, STOCK, SUCURSAL_ID) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getTalla(),
                            producto.getTipoPrenda(), producto.getColor(), producto.getMedidas(), producto.getCategoriaId(), producto.getStock(),
                            producto.getSucursalId());
    }

    // Actualizar un producto
    public void update(int id, Producto producto) {
        String sql = "UPDATE PRODUCTOS SET NOMBRE = ?, DESCRIPCION = ?, PRECIO = ?, TALLA = ?, TIPO_PRENDA = ?, COLOR = ?, MEDIDAS = ?, " +
                     "CATEGORIA_ID = ?, STOCK = ?, SUCURSAL_ID = ? WHERE ID = ?";
        jdbcTemplate.update(sql, producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getTalla(),
                            producto.getTipoPrenda(), producto.getColor(), producto.getMedidas(), producto.getCategoriaId(), producto.getStock(),
                            producto.getSucursalId(), id);
    }

    // Eliminar un producto
    public void delete(int id) {
        String sql = "DELETE FROM PRODUCTOS WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
