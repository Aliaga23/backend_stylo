package com.stylo.backend.controller;

import com.stylo.backend.model.VestidorVirtual;
import com.stylo.backend.service.VestidorVirtualService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vestidores-virtuales")
public class VestidorVirtualController {

    private final VestidorVirtualService vestidorVirtualService;

    public VestidorVirtualController(VestidorVirtualService vestidorVirtualService) {
        this.vestidorVirtualService = vestidorVirtualService;
    }

    @GetMapping
    public List<VestidorVirtual> getAllVestidores() {
        return vestidorVirtualService.getAllVestidores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VestidorVirtual> getVestidorById(@PathVariable int id) {
        VestidorVirtual vestidor = vestidorVirtualService.getVestidorById(id);
        if (vestidor != null) {
            return ResponseEntity.ok(vestidor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createVestidor(@RequestBody VestidorVirtual vestidor) {
        vestidorVirtualService.createVestidor(vestidor);
    }

    @PutMapping("/{id}")
    public void updateVestidor(@PathVariable int id, @RequestBody VestidorVirtual vestidor) {
        vestidorVirtualService.updateVestidor(id, vestidor);
    }

    @DeleteMapping("/{id}")
    public void deleteVestidor(@PathVariable int id) {
        vestidorVirtualService.deleteVestidor(id);
    }
}
