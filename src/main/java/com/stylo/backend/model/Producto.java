package com.stylo.backend.model;

public class Producto {

    private int id;  // Mapeo de la columna ID
    private String nombre;  // Mapeo de la columna NOMBRE
    private String descripcion;  // Mapeo de la columna DESCRIPCION
    private double precio;  // Mapeo de la columna PRECIO
    private String talla;  // Mapeo de la columna TALLA
    private String tipoPrenda;  // Mapeo de la columna TIPO_PRENDA
    private String color;  // Mapeo de la columna COLOR
    private String medidas;  // Mapeo de la columna MEDIDAS
    private int categoriaId;  // Mapeo de la columna CATEGORIA_ID
    private int stock;  // Mapeo de la columna STOCK
    private int sucursalId;  // Mapeo de la columna SUCURSAL_ID

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(String tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }
}
