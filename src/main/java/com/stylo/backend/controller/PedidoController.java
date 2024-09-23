package com.stylo.backend.controller;

import com.stylo.backend.model.Pedido;
import com.stylo.backend.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Obtener todos los pedidos
    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    // Obtener un pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable int id) {
        Pedido pedido = pedidoService.getPedidoById(id);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo pedido
    @PostMapping
    public void createPedido(@RequestBody Pedido pedido) {
        pedidoService.createPedido(pedido);
    }

    // Actualizar un pedido
    @PutMapping("/{id}")
    public void updatePedido(@PathVariable int id, @RequestBody Pedido pedido) {
        pedidoService.updatePedido(id, pedido);
    }

    // Eliminar un pedido
    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable int id) {
        pedidoService.deletePedido(id);
    }
}
