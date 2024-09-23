package com.stylo.backend.model;

import java.sql.Timestamp;

public class Pedido {

    private int id;  // Mapeo de la columna ID
    private int usuarioId;  // Mapeo de la columna USUARIO_ID
    private double total;  // Mapeo de la columna TOTAL
    private String estado;  // Mapeo de la columna ESTADO
    private Timestamp fecha;  // Mapeo de la columna FECHA

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
