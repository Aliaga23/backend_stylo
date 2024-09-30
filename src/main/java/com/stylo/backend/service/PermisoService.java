package com.stylo.backend.service;

import com.stylo.backend.model.Permiso;
import com.stylo.backend.repository.PermisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoService {

    private final PermisoRepository permisoRepository;

    public PermisoService(PermisoRepository permisoRepository) {
        this.permisoRepository = permisoRepository;
    }

    public List<Permiso> getAllPermisos() {
        return permisoRepository.findAll();
    }

    public Permiso getPermisoById(int id) {
        return permisoRepository.findById(id);
    }

    public void createPermiso(Permiso permiso) {
        permisoRepository.save(permiso);
    }

    public void updatePermiso(int id, Permiso permiso) {
        permisoRepository.update(id, permiso);
    }

    public void deletePermiso(int id) {
        permisoRepository.delete(id);
    }
}
