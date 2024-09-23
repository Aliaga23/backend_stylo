package com.stylo.backend.controller;

import com.stylo.backend.model.Inventario;
import com.stylo.backend.service.InventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    // Obtener todos los registros de inventario
    @GetMapping
    public List<Inventario> getAllInventarios() {
        return inventarioService.getAllInventarios();
    }

    // Obtener un registro de inventario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Inventario> getInventarioById(@PathVariable int id) {
        Inventario inventario = inventarioService.getInventarioById(id);
        if (inventario != null) {
            return ResponseEntity.ok(inventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo registro de inventario
    @PostMapping
    public void createInventario(@RequestBody Inventario inventario) {
        inventarioService.createInventario(inventario);
    }

    // Actualizar un registro de inventario
    @PutMapping("/{id}")
    public void updateInventario(@PathVariable int id, @RequestBody Inventario inventario) {
        inventarioService.updateInventario(id, inventario);
    }

    // Eliminar un registro de inventario
    @DeleteMapping("/{id}")
    public void deleteInventario(@PathVariable int id) {
        inventarioService.deleteInventario(id);
    }
}
