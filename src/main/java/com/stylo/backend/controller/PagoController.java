package com.stylo.backend.controller;

import com.stylo.backend.model.Pago;
import com.stylo.backend.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoService.getAllPagos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable int id) {
        Pago pago = pagoService.getPagoById(id);
        if (pago != null) {
            return ResponseEntity.ok(pago);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createPago(@RequestBody Pago pago) {
        pagoService.createPago(pago);
    }

    @PutMapping("/{id}")
    public void updatePago(@PathVariable int id, @RequestBody Pago pago) {
        pagoService.updatePago(id, pago);
    }

    @DeleteMapping("/{id}")
    public void deletePago(@PathVariable int id) {
        pagoService.deletePago(id);
    }
}
