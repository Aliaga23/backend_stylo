package com.stylo.backend.repository;

import com.stylo.backend.model.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class UsuarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapeo de los resultados SQL a un objeto Usuario
    private RowMapper<Usuario> rowMapper = new RowMapper<Usuario>() {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("ID"));
            usuario.setNombre(rs.getString("NOMBRE"));
            usuario.setEmail(rs.getString("EMAIL"));
            usuario.setPasswordHash(rs.getString("PASSWORD_HASH"));
            usuario.setRolId(rs.getInt("ROL_ID"));
            
            // Convertir FECHA_REGISTRO de Timestamp a LocalDateTime
            Timestamp timestamp = rs.getTimestamp("FECHA_REGISTRO");
            if (timestamp != null) {
                usuario.setFechaRegistro(timestamp.toLocalDateTime());
            }

            return usuario;
        }
    };

    // Obtener todos los usuarios
    public List<Usuario> findAll() {
        String sql = "SELECT * FROM USUARIOS";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Buscar un usuario por ID
    @SuppressWarnings("deprecation")
    public Usuario findById(int id) {
        String sql = "SELECT * FROM USUARIOS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    // Crear un nuevo usuario
    public void save(Usuario usuario) {
        String sql = "INSERT INTO USUARIOS (NOMBRE, EMAIL, PASSWORD_HASH, ROL_ID, FECHA_REGISTRO) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, usuario.getNombre(), usuario.getEmail(), usuario.getPasswordHash(), usuario.getRolId(), usuario.getFechaRegistro());
    }

    // Actualizar un usuario
    public void update(int id, Usuario usuario) {
        String sql = "UPDATE USUARIOS SET NOMBRE = ?, EMAIL = ?, PASSWORD_HASH = ?, ROL_ID = ?, FECHA_REGISTRO = ? WHERE ID = ?";
        jdbcTemplate.update(sql, usuario.getNombre(), usuario.getEmail(), usuario.getPasswordHash(), usuario.getRolId(), usuario.getFechaRegistro(), id);
    }

    // Eliminar un usuario
    public void delete(int id) {
        String sql = "DELETE FROM USUARIOS WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
