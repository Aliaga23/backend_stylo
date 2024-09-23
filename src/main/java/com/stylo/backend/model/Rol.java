package com.stylo.backend.model;

public class Rol {

    private int id;  // Mapeo de la columna ID
    private String nombre;  // Mapeo de la columna NOMBRE
    private String descripcion;  // Mapeo de la columna DESCRIPCION

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
