package com.stylo.backend.controller;

import com.stylo.backend.model.MovimientoInventario;
import com.stylo.backend.service.MovimientoInventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos-inventario")
public class MovimientoInventarioController {

    private final MovimientoInventarioService movimientoInventarioService;

    public MovimientoInventarioController(MovimientoInventarioService movimientoInventarioService) {
        this.movimientoInventarioService = movimientoInventarioService;
    }

    @GetMapping
    public List<MovimientoInventario> getAllMovimientos() {
        return movimientoInventarioService.getAllMovimientos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoInventario> getMovimientoById(@PathVariable int id) {
        MovimientoInventario movimiento = movimientoInventarioService.getMovimientoById(id);
        if (movimiento != null) {
            return ResponseEntity.ok(movimiento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createMovimiento(@RequestBody MovimientoInventario movimiento) {
        movimientoInventarioService.createMovimiento(movimiento);
    }

    @PutMapping("/{id}")
    public void updateMovimiento(@PathVariable int id, @RequestBody MovimientoInventario movimiento) {
        movimientoInventarioService.updateMovimiento(id, movimiento);
    }

    @DeleteMapping("/{id}")
    public void deleteMovimiento(@PathVariable int id) {
        movimientoInventarioService.deleteMovimiento(id);
    }
}
