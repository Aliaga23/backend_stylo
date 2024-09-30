package com.stylo.backend.service;

import com.stylo.backend.model.MovimientoInventario;
import com.stylo.backend.repository.MovimientoInventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoInventarioService {

    private final MovimientoInventarioRepository movimientoInventarioRepository;

    public MovimientoInventarioService(MovimientoInventarioRepository movimientoInventarioRepository) {
        this.movimientoInventarioRepository = movimientoInventarioRepository;
    }

    public List<MovimientoInventario> getAllMovimientos() {
        return movimientoInventarioRepository.findAll();
    }

    public MovimientoInventario getMovimientoById(int id) {
        return movimientoInventarioRepository.findById(id);
    }

    public void createMovimiento(MovimientoInventario movimiento) {
        movimientoInventarioRepository.save(movimiento);
    }

    public void updateMovimiento(int id, MovimientoInventario movimiento) {
        movimientoInventarioRepository.update(id, movimiento);
    }

    public void deleteMovimiento(int id) {
        movimientoInventarioRepository.delete(id);
    }
}
