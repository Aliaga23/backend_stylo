package com.stylo.backend.controller;

import com.stylo.backend.model.PedidoItem;
import com.stylo.backend.service.PedidoItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido-items")
public class PedidoItemController {

    private final PedidoItemService pedidoItemService;

    public PedidoItemController(PedidoItemService pedidoItemService) {
        this.pedidoItemService = pedidoItemService;
    }

    @GetMapping
    public List<PedidoItem> getAllPedidoItems() {
        return pedidoItemService.getAllPedidoItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoItem> getPedidoItemById(@PathVariable int id) {
        PedidoItem pedidoItem = pedidoItemService.getPedidoItemById(id);
        if (pedidoItem != null) {
            return ResponseEntity.ok(pedidoItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createPedidoItem(@RequestBody PedidoItem pedidoItem) {
        pedidoItemService.createPedidoItem(pedidoItem);
    }

    @PutMapping("/{id}")
    public void updatePedidoItem(@PathVariable int id, @RequestBody PedidoItem pedidoItem) {
        pedidoItemService.updatePedidoItem(id, pedidoItem);
    }

    @DeleteMapping("/{id}")
    public void deletePedidoItem(@PathVariable int id) {
        pedidoItemService.deletePedidoItem(id);
    }
}
