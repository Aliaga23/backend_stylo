package com.stylo.backend.controller;

import com.stylo.backend.model.Permiso;
import com.stylo.backend.service.PermisoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    private final PermisoService permisoService;

    public PermisoController(PermisoService permisoService) {
        this.permisoService = permisoService;
    }

    @GetMapping
    public List<Permiso> getAllPermisos() {
        return permisoService.getAllPermisos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permiso> getPermisoById(@PathVariable int id) {
        Permiso permiso = permisoService.getPermisoById(id);
        if (permiso != null) {
            return ResponseEntity.ok(permiso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createPermiso(@RequestBody Permiso permiso) {
        permisoService.createPermiso(permiso);
    }

    @PutMapping("/{id}")
    public void updatePermiso(@PathVariable int id, @RequestBody Permiso permiso) {
        permisoService.updatePermiso(id, permiso);
    }

    @DeleteMapping("/{id}")
    public void deletePermiso(@PathVariable int id) {
        permisoService.deletePermiso(id);
    }
}
