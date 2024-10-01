package com.stylo.backend.service;

import com.stylo.backend.dto.UsuarioInfoDTO;
import com.stylo.backend.model.Usuario;
import com.stylo.backend.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id);
    }

    public void createUsuario(Usuario usuario) {
        String hashedPassword = passwordEncoder.encode(usuario.getPasswordHash());
        usuario.setPasswordHash(hashedPassword);
        usuarioRepository.save(usuario);
    }

    public void updateUsuario(int id, Usuario usuario) {
        if (usuario.getPasswordHash() != null && !usuario.getPasswordHash().isEmpty()) {
            String hashedPassword = passwordEncoder.encode(usuario.getPasswordHash());
            usuario.setPasswordHash(hashedPassword);
        }
        usuarioRepository.update(id, usuario);
    }

    public void deleteUsuario(int id) {
        usuarioRepository.delete(id);
    }

    public Usuario obtenerPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public boolean verificarContraseña(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public void registrarUsuario(Usuario usuario) {
        usuario.setPasswordHash(passwordEncoder.encode(usuario.getPasswordHash()));
        usuarioRepository.save(usuario);
    }
    public List<UsuarioInfoDTO> obtenerInfoUsuarios() {
        return usuarioRepository.obtenerInfoUsuarios();
    }
}
