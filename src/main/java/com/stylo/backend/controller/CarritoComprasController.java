package com.stylo.backend.controller;

import com.stylo.backend.model.CarritoCompras;
import com.stylo.backend.service.CarritoComprasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carritos")
public class CarritoComprasController {

    private final CarritoComprasService carritoService;

    public CarritoComprasController(CarritoComprasService carritoService) {
        this.carritoService = carritoService;
    }

    // Obtener todos los carritos
    @GetMapping
    public List<CarritoCompras> getAllCarritos() {
        return carritoService.getAllCarritos();
    }

    // Obtener un carrito por ID
    @GetMapping("/{id}")
    public ResponseEntity<CarritoCompras> getCarritoById(@PathVariable int id) {
        CarritoCompras carrito = carritoService.getCarritoById(id);
        if (carrito != null) {
            return ResponseEntity.ok(carrito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo carrito
    @PostMapping
    public void createCarrito(@RequestBody CarritoCompras carrito) {
        carritoService.createCarrito(carrito);
    }

    // Actualizar un carrito
    @PutMapping("/{id}")
    public void updateCarrito(@PathVariable int id, @RequestBody CarritoCompras carrito) {
        carritoService.updateCarrito(id, carrito);
    }

    // Eliminar un carrito
    @DeleteMapping("/{id}")
    public void deleteCarrito(@PathVariable int id) {
        carritoService.deleteCarrito(id);
    }
}
