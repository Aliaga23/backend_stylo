package com.stylo.backend.service;

import com.stylo.backend.model.Producto;
import com.stylo.backend.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por ID
    public Producto getProductoById(int id) {
        return productoRepository.findById(id);
    }

    // Crear un nuevo producto
    public void createProducto(Producto producto) {
        productoRepository.save(producto);
    }

    // Actualizar un producto
    public void updateProducto(int id, Producto producto) {
        productoRepository.update(id, producto);
    }

    // Eliminar un producto
    public void deleteProducto(int id) {
        productoRepository.delete(id);
    }
}
