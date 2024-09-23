package com.stylo.backend.service;

import com.stylo.backend.model.Categoria;
import com.stylo.backend.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Obtener todas las categorías
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    // Obtener una categoría por ID
    public Categoria getCategoriaById(int id) {
        return categoriaRepository.findById(id);
    }

    // Crear una nueva categoría
    public void createCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    // Actualizar una categoría
    public void updateCategoria(int id, Categoria categoria) {
        categoriaRepository.update(id, categoria);
    }

    // Eliminar una categoría
    public void deleteCategoria(int id) {
        categoriaRepository.delete(id);
    }
}
