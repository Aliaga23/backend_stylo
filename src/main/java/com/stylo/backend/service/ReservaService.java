package com.stylo.backend.service;

import com.stylo.backend.model.Reserva;
import com.stylo.backend.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva getReservaById(int id) {
        return reservaRepository.findById(id);
    }

    public void createReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    public void updateReserva(int id, Reserva reserva) {
        reservaRepository.update(id, reserva);
    }

    public void deleteReserva(int id) {
        reservaRepository.delete(id);
    }
}
