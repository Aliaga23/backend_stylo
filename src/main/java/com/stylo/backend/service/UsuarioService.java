package com.stylo.backend.service;

import com.stylo.backend.model.Usuario;
import com.stylo.backend.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id);
    }

    // Crear un nuevo usuario
    public void createUsuario(Usuario usuario) {
        String hashedPassword = passwordEncoder.encode(usuario.getPasswordHash());  // Hashear contraseña
        usuario.setPasswordHash(hashedPassword);  // Asignar contraseña hasheada
        usuario.setFechaRegistro(LocalDateTime.now());  // Fecha de registro actual
        usuarioRepository.save(usuario);
    }

    // Actualizar un usuario
    public void updateUsuario(int id, Usuario usuario) {
        if (usuario.getPasswordHash() != null && !usuario.getPasswordHash().isEmpty()) {
            String hashedPassword = passwordEncoder.encode(usuario.getPasswordHash());  // Hashear contraseña
            usuario.setPasswordHash(hashedPassword);
        }
        usuarioRepository.update(id, usuario);
    }

    // Eliminar un usuario
    public void deleteUsuario(int id) {
        usuarioRepository.delete(id);
    }
}
