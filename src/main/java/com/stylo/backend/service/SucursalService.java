package com.stylo.backend.service;

import com.stylo.backend.model.Sucursal;
import com.stylo.backend.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    // Obtener todas las sucursales
    public List<Sucursal> getAllSucursales() {
        return sucursalRepository.findAll();
    }

    // Obtener una sucursal por ID
    public Sucursal getSucursalById(int id) {
        return sucursalRepository.findById(id);
    }

    // Crear una nueva sucursal
    public void createSucursal(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    // Actualizar una sucursal
    public void updateSucursal(int id, Sucursal sucursal) {
        sucursalRepository.update(id, sucursal);
    }

    // Eliminar una sucursal
    public void deleteSucursal(int id) {
        sucursalRepository.delete(id);
    }
}
