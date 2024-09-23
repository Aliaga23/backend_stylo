package com.stylo.backend.model;

import java.time.LocalDateTime;

public class Usuario {

    private int id;  // Mapeo de la columna ID
    private String nombre;  // Mapeo de la columna NOMBRE
    private String email;  // Mapeo de la columna EMAIL
    private String passwordHash;  // Mapeo de la columna PASSWORD_HASH
    private int rolId;  // Mapeo de la columna ROL_ID
    private LocalDateTime fechaRegistro;  // Mapeo de la columna FECHA_REGISTRO

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
