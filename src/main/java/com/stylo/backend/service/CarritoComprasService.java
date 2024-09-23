package com.stylo.backend.service;

import com.stylo.backend.model.CarritoCompras;
import com.stylo.backend.repository.CarritoComprasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoComprasService {

    private final CarritoComprasRepository carritoRepository;

    public CarritoComprasService(CarritoComprasRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    // Obtener todos los carritos
    public List<CarritoCompras> getAllCarritos() {
        return carritoRepository.findAll();
    }

    // Obtener un carrito por ID
    public CarritoCompras getCarritoById(int id) {
        return carritoRepository.findById(id);
    }

    // Crear un nuevo carrito
    public void createCarrito(CarritoCompras carrito) {
        carritoRepository.save(carrito);
    }

    // Actualizar un carrito
    public void updateCarrito(int id, CarritoCompras carrito) {
        carritoRepository.update(id, carrito);
    }

    // Eliminar un carrito
    public void deleteCarrito(int id) {
        carritoRepository.delete(id);
    }
}
