package com.stylo.backend.controller;

import com.stylo.backend.model.Sucursal;
import com.stylo.backend.service.SucursalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    // Obtener todas las sucursales
    @GetMapping
    public List<Sucursal> getAllSucursales() {
        return sucursalService.getAllSucursales();
    }

    // Obtener una sucursal por ID
    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getSucursalById(@PathVariable int id) {
        Sucursal sucursal = sucursalService.getSucursalById(id);
        if (sucursal != null) {
            return ResponseEntity.ok(sucursal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva sucursal
    @PostMapping
    public void createSucursal(@RequestBody Sucursal sucursal) {
        sucursalService.createSucursal(sucursal);
    }

    // Actualizar una sucursal
    @PutMapping("/{id}")
    public void updateSucursal(@PathVariable int id, @RequestBody Sucursal sucursal) {
        sucursalService.updateSucursal(id, sucursal);
    }

    // Eliminar una sucursal
    @DeleteMapping("/{id}")
    public void deleteSucursal(@PathVariable int id) {
        sucursalService.deleteSucursal(id);
    }
}
