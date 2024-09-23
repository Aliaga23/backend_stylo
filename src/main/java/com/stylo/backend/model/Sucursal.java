package com.stylo.backend.model;

public class Sucursal {

    private int id;  // Mapeo de la columna ID
    private String nombre;  // Mapeo de la columna NOMBRE
    private String direccion;  // Mapeo de la columna DIRECCION

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
