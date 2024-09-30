package com.stylo.backend.service;

import com.stylo.backend.model.VestidorVirtual;
import com.stylo.backend.repository.VestidorVirtualRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VestidorVirtualService {

    private final VestidorVirtualRepository vestidorVirtualRepository;

    public VestidorVirtualService(VestidorVirtualRepository vestidorVirtualRepository) {
        this.vestidorVirtualRepository = vestidorVirtualRepository;
    }

    public List<VestidorVirtual> getAllVestidores() {
        return vestidorVirtualRepository.findAll();
    }

    public VestidorVirtual getVestidorById(int id) {
        return vestidorVirtualRepository.findById(id);
    }

    public void createVestidor(VestidorVirtual vestidor) {
        vestidorVirtualRepository.save(vestidor);
    }

    public void updateVestidor(int id, VestidorVirtual vestidor) {
        vestidorVirtualRepository.update(id, vestidor);
    }

    public void deleteVestidor(int id) {
        vestidorVirtualRepository.delete(id);
    }
}
