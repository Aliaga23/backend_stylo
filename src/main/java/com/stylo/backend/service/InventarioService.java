package com.stylo.backend.service;

import com.stylo.backend.model.Inventario;
import com.stylo.backend.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    // Obtener todos los registros de inventario
    public List<Inventario> getAllInventarios() {
        return inventarioRepository.findAll();
    }

    // Obtener un registro de inventario por ID
    public Inventario getInventarioById(int id) {
        return inventarioRepository.findById(id);
    }

    // Crear un nuevo registro de inventario
    public void createInventario(Inventario inventario) {
        inventarioRepository.save(inventario);
    }

    // Actualizar un registro de inventario
    public void updateInventario(int id, Inventario inventario) {
        inventarioRepository.update(id, inventario);
    }

    // Eliminar un registro de inventario
    public void deleteInventario(int id) {
        inventarioRepository.delete(id);
    }
}
