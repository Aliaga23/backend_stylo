package com.stylo.backend.service;

import com.stylo.backend.model.CarritoItem;
import com.stylo.backend.repository.CarritoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoItemService {

    private final CarritoItemRepository carritoItemRepository;

    public CarritoItemService(CarritoItemRepository carritoItemRepository) {
        this.carritoItemRepository = carritoItemRepository;
    }

    public List<CarritoItem> getAllCarritoItems() {
        return carritoItemRepository.findAll();
    }

    public CarritoItem getCarritoItemById(int id) {
        return carritoItemRepository.findById(id);
    }

    public void createCarritoItem(CarritoItem carritoItem) {
        carritoItemRepository.save(carritoItem);
    }

    public void updateCarritoItem(int id, CarritoItem carritoItem) {
        carritoItemRepository.update(id, carritoItem);
    }

    public void deleteCarritoItem(int id) {
        carritoItemRepository.delete(id);
    }
}
