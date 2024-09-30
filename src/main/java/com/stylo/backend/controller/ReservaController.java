package com.stylo.backend.controller;

import com.stylo.backend.model.Reserva;
import com.stylo.backend.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable int id) {
        Reserva reserva = reservaService.getReservaById(id);
        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createReserva(@RequestBody Reserva reserva) {
        reservaService.createReserva(reserva);
    }

    @PutMapping("/{id}")
    public void updateReserva(@PathVariable int id, @RequestBody Reserva reserva) {
        reservaService.updateReserva(id, reserva);
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable int id) {
        reservaService.deleteReserva(id);
    }
}
