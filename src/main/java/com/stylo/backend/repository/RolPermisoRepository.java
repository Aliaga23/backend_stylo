package com.stylo.backend.repository;

import com.stylo.backend.model.RolPermiso;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RolPermisoRepository {

    private final JdbcTemplate jdbcTemplate;

    public RolPermisoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapeo de los resultados SQL a un objeto RolPermiso
    private RowMapper<RolPermiso> rowMapper = new RowMapper<RolPermiso>() {
        @Override
        public RolPermiso mapRow(ResultSet rs, int rowNum) throws SQLException {
            RolPermiso rolPermiso = new RolPermiso();
            rolPermiso.setId(rs.getInt("ID"));
            rolPermiso.setRolId(rs.getInt("ROL_ID"));
            rolPermiso.setPermisoId(rs.getInt("PERMISO_ID"));
            return rolPermiso;
        }
    };

    // Obtener todas las asignaciones de permisos a roles
    public List<RolPermiso> findAll() {
        String sql = "SELECT * FROM ROL_PERMISOS";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Buscar una asignación por ID
    @SuppressWarnings("deprecation")
    public RolPermiso findById(int id) {
        String sql = "SELECT * FROM ROL_PERMISOS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

    // Crear una nueva asignación (relación) entre rol y permiso
    public void save(RolPermiso rolPermiso) {
        String sql = "INSERT INTO ROL_PERMISOS (ROL_ID, PERMISO_ID) VALUES (?, ?)";
        jdbcTemplate.update(sql, rolPermiso.getRolId(), rolPermiso.getPermisoId());
    }

    // Actualizar una asignación entre rol y permiso
    public void update(int id, RolPermiso rolPermiso) {
        String sql = "UPDATE ROL_PERMISOS SET ROL_ID = ?, PERMISO_ID = ? WHERE ID = ?";
        jdbcTemplate.update(sql, rolPermiso.getRolId(), rolPermiso.getPermisoId(), id);
    }

    // Eliminar una asignación entre rol y permiso
    public void delete(int id) {
        String sql = "DELETE FROM ROL_PERMISOS WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
