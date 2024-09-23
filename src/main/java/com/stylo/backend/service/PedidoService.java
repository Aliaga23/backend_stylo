package com.stylo.backend.service;

import com.stylo.backend.model.Pedido;
import com.stylo.backend.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Obtener todos los pedidos
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    // Obtener un pedido por ID
    public Pedido getPedidoById(int id) {
        return pedidoRepository.findById(id);
    }

    // Crear un nuevo pedido
    public void createPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    // Actualizar un pedido
    public void updatePedido(int id, Pedido pedido) {
        pedidoRepository.update(id, pedido);
    }

    // Eliminar un pedido
    public void deletePedido(int id) {
        pedidoRepository.delete(id);
    }
}
