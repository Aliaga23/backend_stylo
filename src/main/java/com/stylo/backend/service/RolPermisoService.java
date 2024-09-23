package com.stylo.backend.service;

import com.stylo.backend.model.RolPermiso;
import com.stylo.backend.repository.RolPermisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolPermisoService {

    private final RolPermisoRepository rolPermisoRepository;

    public RolPermisoService(RolPermisoRepository rolPermisoRepository) {
        this.rolPermisoRepository = rolPermisoRepository;
    }

    // Obtener todas las asignaciones de permisos a roles
    public List<RolPermiso> getAllRolPermisos() {
        return rolPermisoRepository.findAll();
    }

    // Obtener una asignación por ID
    public RolPermiso getRolPermisoById(int id) {
        return rolPermisoRepository.findById(id);
    }

    // Crear una nueva asignación entre rol y permiso
    public void createRolPermiso(RolPermiso rolPermiso) {
        rolPermisoRepository.save(rolPermiso);
    }

    // Actualizar una asignación entre rol y permiso
    public void updateRolPermiso(int id, RolPermiso rolPermiso) {
        rolPermisoRepository.update(id, rolPermiso);
    }

    // Eliminar una asignación entre rol y permiso
    public void deleteRolPermiso(int id) {
        rolPermisoRepository.delete(id);
    }
}
