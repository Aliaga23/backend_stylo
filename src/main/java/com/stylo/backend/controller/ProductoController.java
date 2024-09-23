package com.stylo.backend.controller;

import com.stylo.backend.model.Producto;
import com.stylo.backend.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Obtener todos los productos
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable int id) {
        Producto producto = productoService.getProductoById(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo producto
    @PostMapping
    public void createProducto(@RequestBody Producto producto) {
        productoService.createProducto(producto);
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    public void updateProducto(@PathVariable int id, @RequestBody Producto producto) {
        productoService.updateProducto(id, producto);
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
    }
}
