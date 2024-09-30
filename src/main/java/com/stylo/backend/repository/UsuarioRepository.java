package com.stylo.backend.repository;

import com.stylo.backend.model.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Usuario> usuarioRowMapper = (rs, rowNum) -> {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("ID"));
        usuario.setNombre(rs.getString("NOMBRE"));
        usuario.setEmail(rs.getString("EMAIL"));
        usuario.setPasswordHash(rs.getString("PASSWORD_HASH"));
        usuario.setRolId(rs.getInt("ROL_ID"));
        return usuario;
    };

    public List<Usuario> findAll() {
        return jdbcTemplate.query("SELECT * FROM USUARIOS", usuarioRowMapper);
    }

    public Usuario findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM USUARIOS WHERE ID = ?", usuarioRowMapper, id);
    }

    public Usuario findByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM USUARIOS WHERE EMAIL = ?", usuarioRowMapper, email);
        } catch (Exception e) {
            return null;
        }
    }

    public void save(Usuario usuario) {
        jdbcTemplate.update("INSERT INTO USUARIOS (NOMBRE, EMAIL, PASSWORD_HASH, ROL_ID) VALUES (?, ?, ?, ?)",
                usuario.getNombre(), usuario.getEmail(), usuario.getPasswordHash(), usuario.getRolId());
    }

    public void update(int id, Usuario usuario) {
        jdbcTemplate.update("UPDATE USUARIOS SET NOMBRE = ?, EMAIL = ?, PASSWORD_HASH = ?, ROL_ID = ? WHERE ID = ?",
                usuario.getNombre(), usuario.getEmail(), usuario.getPasswordHash(), usuario.getRolId(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM USUARIOS WHERE ID = ?", id);
    }
}
