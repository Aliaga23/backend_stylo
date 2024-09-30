package com.stylo.backend.controller;

import com.stylo.backend.model.CarritoItem;
import com.stylo.backend.service.CarritoItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito-items")
public class CarritoItemController {

    private final CarritoItemService carritoItemService;

    public CarritoItemController(CarritoItemService carritoItemService) {
        this.carritoItemService = carritoItemService;
    }

    @GetMapping
    public List<CarritoItem> getAllCarritoItems() {
        return carritoItemService.getAllCarritoItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoItem> getCarritoItemById(@PathVariable int id) {
        CarritoItem carritoItem = carritoItemService.getCarritoItemById(id);
        if (carritoItem != null) {
            return ResponseEntity.ok(carritoItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createCarritoItem(@RequestBody CarritoItem carritoItem) {
        carritoItemService.createCarritoItem(carritoItem);
    }

    @PutMapping("/{id}")
    public void updateCarritoItem(@PathVariable int id, @RequestBody CarritoItem carritoItem) {
        carritoItemService.updateCarritoItem(id, carritoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteCarritoItem(@PathVariable int id) {
        carritoItemService.deleteCarritoItem(id);
    }
}
