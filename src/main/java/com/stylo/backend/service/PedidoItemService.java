package com.stylo.backend.service;

import com.stylo.backend.model.PedidoItem;
import com.stylo.backend.repository.PedidoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoItemService {

    private final PedidoItemRepository pedidoItemRepository;

    public PedidoItemService(PedidoItemRepository pedidoItemRepository) {
        this.pedidoItemRepository = pedidoItemRepository;
    }

    public List<PedidoItem> getAllPedidoItems() {
        return pedidoItemRepository.findAll();
    }

    public PedidoItem getPedidoItemById(int id) {
        return pedidoItemRepository.findById(id);
    }

    public void createPedidoItem(PedidoItem pedidoItem) {
        pedidoItemRepository.save(pedidoItem);
    }

    public void updatePedidoItem(int id, PedidoItem pedidoItem) {
        pedidoItemRepository.update(id, pedidoItem);
    }

    public void deletePedidoItem(int id) {
        pedidoItemRepository.delete(id);
    }
}
