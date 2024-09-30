package com.stylo.backend.service;

import com.stylo.backend.model.Pago;
import com.stylo.backend.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    public Pago getPagoById(int id) {
        return pagoRepository.findById(id);
    }

    public void createPago(Pago pago) {
        pagoRepository.save(pago);
    }

    public void updatePago(int id, Pago pago) {
        pagoRepository.update(id, pago);
    }

    public void deletePago(int id) {
        pagoRepository.delete(id);
    }
}
