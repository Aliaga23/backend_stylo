package com.stylo.backend.repository;

import com.stylo.backend.model.Rol;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RolRepository {

    private final JdbcTemplate jdbcTemplate;

    public RolRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapeo de los resultados SQL a un objeto Rol
    private RowMapper<Rol> rowMapper = new RowMapper<Rol>() {
        @Override
        public Rol mapRow(ResultSet rs, int rowNum) throws SQLException {
            Rol rol = new Rol();
            rol.setId(rs.getInt("ID"));
            rol.setNombre(rs.getString("NOMBRE"));
            rol.setDescripcion(rs.getString("DESCRIPCION"));
            return rol;
        }
    };

    // Obtener todos los roles
    public List<Rol> findAll() {
        String sql = "SELECT * FROM ROLES";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Buscar un rol por ID
    @SuppressWarnings("deprecation")
    public Rol findById(int id) {
        String sql = "SELECT * FROM ROLES WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    // Crear un nuevo rol
    public void save(Rol rol) {
        String sql = "INSERT INTO ROLES (NOMBRE, DESCRIPCION) VALUES (?, ?)";
        jdbcTemplate.update(sql, rol.getNombre(), rol.getDescripcion());
    }

    // Actualizar un rol
    public void update(int id, Rol rol) {
        String sql = "UPDATE ROLES SET NOMBRE = ?, DESCRIPCION = ? WHERE ID = ?";
        jdbcTemplate.update(sql, rol.getNombre(), rol.getDescripcion(), id);
    }

    // Eliminar un rol
    public void delete(int id) {
        String sql = "DELETE FROM ROLES WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
