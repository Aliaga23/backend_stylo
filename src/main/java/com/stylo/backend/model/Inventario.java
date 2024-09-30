package com.stylo.backend.model;

import java.sql.Timestamp;

public class Inventario {

    private int id;  // Mapeo de la columna ID
    private int productoId;  // Mapeo de la columna PRODUCTO_ID
    private int sucursalId;  // Mapeo de la columna SUCURSAL_ID
    private int cantidadDisponible;  // Mapeo de la columna CANTIDAD_DISPONIBLE
    private Timestamp fechaUltimaActualizacion;  // Mapeo de la columna FECHA_ULTIMA_ACTUALIZACION

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Timestamp getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }
}