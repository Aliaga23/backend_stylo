package com.stylo.backend.controller;

import com.stylo.backend.model.RolPermiso;
import com.stylo.backend.service.RolPermisoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol-permisos")
public class RolPermisoController {

    private final RolPermisoService rolPermisoService;

    public RolPermisoController(RolPermisoService rolPermisoService) {
        this.rolPermisoService = rolPermisoService;
    }

    // Obtener todas las asignaciones de permisos a roles
    @GetMapping
    public List<RolPermiso> getAllRolPermisos() {
        return rolPermisoService.getAllRolPermisos();
    }

    // Obtener una asignación por ID
    @GetMapping("/{id}")
    public ResponseEntity<RolPermiso> getRolPermisoById(@PathVariable int id) {
        RolPermiso rolPermiso = rolPermisoService.getRolPermisoById(id);
        if (rolPermiso != null) {
            return ResponseEntity.ok(rolPermiso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva asignación entre rol y permiso
    @PostMapping
    public void createRolPermiso(@RequestBody RolPermiso rolPermiso) {
        rolPermisoService.createRolPermiso(rolPermiso);
    }

    // Actualizar una asignación entre rol y permiso
    @PutMapping("/{id}")
    public void updateRolPermiso(@PathVariable int id, @RequestBody RolPermiso rolPermiso) {
        rolPermisoService.updateRolPermiso(id, rolPermiso);
    }

    // Eliminar una asignación entre rol y permiso
    @DeleteMapping("/{id}")
    public void deleteRolPermiso(@PathVariable int id) {
        rolPermisoService.deleteRolPermiso(id);
    }
}
