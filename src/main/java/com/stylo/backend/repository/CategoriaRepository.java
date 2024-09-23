package com.stylo.backend.repository;

import com.stylo.backend.model.Categoria;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoriaRepository {

    private final JdbcTemplate jdbcTemplate;

    public CategoriaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapeo de los resultados SQL a un objeto Categoria
    private RowMapper<Categoria> rowMapper = new RowMapper<Categoria>() {
        @Override
        public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("ID"));
            categoria.setNombre(rs.getString("NOMBRE"));
            categoria.setDescripcion(rs.getString("DESCRIPCION"));
            return categoria;
        }
    };

    // Obtener todas las categorías
    public List<Categoria> findAll() {
        String sql = "SELECT * FROM CATEGORIAS";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Buscar una categoría por ID
    public Categoria findById(int id) {
        String sql = "SELECT * FROM CATEGORIAS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    // Crear una nueva categoría
    public void save(Categoria categoria) {
        String sql = "INSERT INTO CATEGORIAS (NOMBRE, DESCRIPCION) VALUES (?, ?)";
        jdbcTemplate.update(sql, categoria.getNombre(), categoria.getDescripcion());
    }

    // Actualizar una categoría
    public void update(int id, Categoria categoria) {
        String sql = "UPDATE CATEGORIAS SET NOMBRE = ?, DESCRIPCION = ? WHERE ID = ?";
        jdbcTemplate.update(sql, categoria.getNombre(), categoria.getDescripcion(), id);
    }

    // Eliminar una categoría
    public void delete(int id) {
        String sql = "DELETE FROM CATEGORIAS WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
