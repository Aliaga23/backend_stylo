package com.stylo.backend.controller;

import com.stylo.backend.model.Categoria;
import com.stylo.backend.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Obtener todas las categorías
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable int id) {
        Categoria categoria = categoriaService.getCategoriaById(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva categoría
    @PostMapping
    public void createCategoria(@RequestBody Categoria categoria) {
        categoriaService.createCategoria(categoria);
    }

    // Actualizar una categoría
    @PutMapping("/{id}")
    public void updateCategoria(@PathVariable int id, @RequestBody Categoria categoria) {
        categoriaService.updateCategoria(id, categoria);
    }

    // Eliminar una categoría
    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable int id) {
        categoriaService.deleteCategoria(id);
    }
}
