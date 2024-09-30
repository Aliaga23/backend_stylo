package com.stylo.backend.controller;

import com.stylo.backend.model.Usuario;
import com.stylo.backend.service.UsuarioService;
import com.stylo.backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        // Verifica si el correo electrónico ya está registrado
        if (usuarioService.obtenerPorEmail(usuario.getEmail()) != null) {
            return ResponseEntity.status(400).body("El email ya está registrado.");
        }

        // Asignar rol 2 automáticamente al usuario
        usuario.setRolId(2);  // Asegúrate de que el modelo Usuario tenga un campo roleId

        // Registrar usuario
        usuarioService.registrarUsuario(usuario);

        // Generar el token JWT
        String token = jwtUtil.generateToken(usuario.getEmail());

        // Devolver el token como respuesta
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        // Obtener usuario por email
        Usuario usuarioDb = usuarioService.obtenerPorEmail(usuario.getEmail());

        // Verificar credenciales
        if (usuarioDb != null && usuarioService.verificarContraseña(usuario.getPasswordHash(), usuarioDb.getPasswordHash())) {
            // Generar token JWT
            String token = jwtUtil.generateToken(usuario.getEmail());
            return ResponseEntity.ok(Map.of("token", token));
        }

        // Si las credenciales son inválidas
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }
}
