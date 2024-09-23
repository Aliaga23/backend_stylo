package com.stylo.backend.controller;

import com.stylo.backend.model.Usuario;
import com.stylo.backend.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.createUsuario(usuario);
            return ResponseEntity.ok("Usuario creado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el usuario: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        try {
            usuarioService.updateUsuario(id, usuario);
            return ResponseEntity.ok("Usuario actualizado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
        try {
            usuarioService.deleteUsuario(id);
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar el usuario: " + e.getMessage());
        }
    }
}
