package com.stylo.backend.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class UsuarioInfoDTO {
    private int usuarioId;
    private String nombreUsuario;
    private String emailUsuario;
    private Timestamp fechaRegistroUsuario;
    private String rolUsuario;
    private String nombreSucursal;
    private String direccionSucursal;
    private String nombreProducto;
    private String descripcionProducto;
    private String tipoPrenda;
    private String colorProducto;
    private BigDecimal precioProducto;
    private int stockProducto;
    private String medidasProducto;
    private String categoriaProducto;
    private String imagenProducto;
    private int cantidadCarrito;
    private BigDecimal precioUnitarioCarrito;
    private BigDecimal totalCarrito;
    private BigDecimal totalPedido;
    private String estadoPedido;
    private Timestamp fechaPedido;
    private int cantidadProductoPedido;
    private BigDecimal precioUnitarioPedido;
    private String metodoPago;
    private BigDecimal montoPago;
    private Timestamp fechaPago;
    private Timestamp fechaReserva;
    private Timestamp fechaLimiteReserva;
    private String estadoReserva;
    private Timestamp fechaVestidorVirtual;
    private int productoVestidorVirtual;
    private String tipoReporte;
    private String descripcionReporte;
    private Timestamp fechaGeneracionReporte;

    // Getters y Setters para todos los campos
    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public String getEmailUsuario() { return emailUsuario; }
    public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }
    public Timestamp getFechaRegistroUsuario() { return fechaRegistroUsuario; }
    public void setFechaRegistroUsuario(Timestamp fechaRegistroUsuario) { this.fechaRegistroUsuario = fechaRegistroUsuario; }
    public String getRolUsuario() { return rolUsuario; }
    public void setRolUsuario(String rolUsuario) { this.rolUsuario = rolUsuario; }
    public String getNombreSucursal() { return nombreSucursal; }
    public void setNombreSucursal(String nombreSucursal) { this.nombreSucursal = nombreSucursal; }
    public String getDireccionSucursal() { return direccionSucursal; }
    public void setDireccionSucursal(String direccionSucursal) { this.direccionSucursal = direccionSucursal; }
    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }
    public String getDescripcionProducto() { return descripcionProducto; }
    public void setDescripcionProducto(String descripcionProducto) { this.descripcionProducto = descripcionProducto; }
    public String getTipoPrenda() { return tipoPrenda; }
    public void setTipoPrenda(String tipoPrenda) { this.tipoPrenda = tipoPrenda; }
    public String getColorProducto() { return colorProducto; }
    public void setColorProducto(String colorProducto) { this.colorProducto = colorProducto; }
    public BigDecimal getPrecioProducto() { return precioProducto; }
    public void setPrecioProducto(BigDecimal precioProducto) { this.precioProducto = precioProducto; }
    public int getStockProducto() { return stockProducto; }
    public void setStockProducto(int stockProducto) { this.stockProducto = stockProducto; }
    public String getMedidasProducto() { return medidasProducto; }
    public void setMedidasProducto(String medidasProducto) { this.medidasProducto = medidasProducto; }
    public String getCategoriaProducto() { return categoriaProducto; }
    public void setCategoriaProducto(String categoriaProducto) { this.categoriaProducto = categoriaProducto; }
    public String getImagenProducto() { return imagenProducto; }
    public void setImagenProducto(String imagenProducto) { this.imagenProducto = imagenProducto; }
    public int getCantidadCarrito() { return cantidadCarrito; }
    public void setCantidadCarrito(int cantidadCarrito) { this.cantidadCarrito = cantidadCarrito; }
    public BigDecimal getPrecioUnitarioCarrito() { return precioUnitarioCarrito; }
    public void setPrecioUnitarioCarrito(BigDecimal precioUnitarioCarrito) { this.precioUnitarioCarrito = precioUnitarioCarrito; }
    public BigDecimal getTotalCarrito() { return totalCarrito; }
    public void setTotalCarrito(BigDecimal totalCarrito) { this.totalCarrito = totalCarrito; }
    public BigDecimal getTotalPedido() { return totalPedido; }
    public void setTotalPedido(BigDecimal totalPedido) { this.totalPedido = totalPedido; }
    public String getEstadoPedido() { return estadoPedido; }
    public void setEstadoPedido(String estadoPedido) { this.estadoPedido = estadoPedido; }
    public Timestamp getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(Timestamp fechaPedido) { this.fechaPedido = fechaPedido; }
    public int getCantidadProductoPedido() { return cantidadProductoPedido; }
    public void setCantidadProductoPedido(int cantidadProductoPedido) { this.cantidadProductoPedido = cantidadProductoPedido; }
    public BigDecimal getPrecioUnitarioPedido() { return precioUnitarioPedido; }
    public void setPrecioUnitarioPedido(BigDecimal precioUnitarioPedido) { this.precioUnitarioPedido = precioUnitarioPedido; }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public BigDecimal getMontoPago() { return montoPago; }
    public void setMontoPago(BigDecimal montoPago) { this.montoPago = montoPago; }
    public Timestamp getFechaPago() { return fechaPago; }
    public void setFechaPago(Timestamp fechaPago) { this.fechaPago = fechaPago; }
    public Timestamp getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(Timestamp fechaReserva) { this.fechaReserva = fechaReserva; }
    public Timestamp getFechaLimiteReserva() { return fechaLimiteReserva; }
    public void setFechaLimiteReserva(Timestamp fechaLimiteReserva) { this.fechaLimiteReserva = fechaLimiteReserva; }
    public String getEstadoReserva() { return estadoReserva; }
    public void setEstadoReserva(String estadoReserva) { this.estadoReserva = estadoReserva; }
    public Timestamp getFechaVestidorVirtual() { return fechaVestidorVirtual; }
    public void setFechaVestidorVirtual(Timestamp fechaVestidorVirtual) { this.fechaVestidorVirtual = fechaVestidorVirtual; }
    public int getProductoVestidorVirtual() { return productoVestidorVirtual; }
    public void setProductoVestidorVirtual(int productoVestidorVirtual) { this.productoVestidorVirtual = productoVestidorVirtual; }
    public String getTipoReporte() { return tipoReporte; }
    public void setTipoReporte(String tipoReporte) { this.tipoReporte = tipoReporte; }
    public String getDescripcionReporte() { return descripcionReporte; }
    public void setDescripcionReporte(String descripcionReporte) { this.descripcionReporte = descripcionReporte; }
    public Timestamp getFechaGeneracionReporte() { return fechaGeneracionReporte; }
    public void setFechaGeneracionReporte(Timestamp fechaGeneracionReporte) { this.fechaGeneracionReporte = fechaGeneracionReporte; }
}
