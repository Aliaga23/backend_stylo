package com.stylo.backend.repository;

import com.stylo.backend.dto.UsuarioInfoDTO;
import com.stylo.backend.model.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Usuario> usuarioRowMapper = (rs, rowNum) -> {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("ID"));
        usuario.setNombre(rs.getString("NOMBRE"));
        usuario.setEmail(rs.getString("EMAIL"));
        usuario.setPasswordHash(rs.getString("PASSWORD_HASH"));
        usuario.setRolId(rs.getInt("ROL_ID"));
        return usuario;
    };

    public List<Usuario> findAll() {
        return jdbcTemplate.query("SELECT * FROM USUARIOS", usuarioRowMapper);
    }

    public Usuario findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM USUARIOS WHERE ID = ?", usuarioRowMapper, id);
    }

    public Usuario findByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM USUARIOS WHERE EMAIL = ?", usuarioRowMapper, email);
        } catch (Exception e) {
            return null;
        }
    }

    public void save(Usuario usuario) {
        jdbcTemplate.update("INSERT INTO USUARIOS (NOMBRE, EMAIL, PASSWORD_HASH, ROL_ID) VALUES (?, ?, ?, ?)",
                usuario.getNombre(), usuario.getEmail(), usuario.getPasswordHash(), usuario.getRolId());
    }

    public void update(int id, Usuario usuario) {
        jdbcTemplate.update("UPDATE USUARIOS SET NOMBRE = ?, EMAIL = ?, PASSWORD_HASH = ?, ROL_ID = ? WHERE ID = ?",
                usuario.getNombre(), usuario.getEmail(), usuario.getPasswordHash(), usuario.getRolId(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM USUARIOS WHERE ID = ?", id);
    }

   
    public List<UsuarioInfoDTO> obtenerInfoUsuarios() {
        String sql = """
            SELECT
                U.ID AS UsuarioID,
                U.NOMBRE AS NombreUsuario,
                U.EMAIL AS EmailUsuario,
                U.FECHA_REGISTRO AS FechaRegistroUsuario,
                R.NOMBRE AS RolUsuario,
                S.NOMBRE AS NombreSucursal,
                S.DIRECCION AS DireccionSucursal,
                P.NOMBRE AS NombreProducto,
                P.DESCRIPCION AS DescripcionProducto,
                P.TIPO_PRENDA AS TipoPrenda,
                P.COLOR AS ColorProducto,
                P.PRECIO AS PrecioProducto,
                P.STOCK AS StockProducto,
                P.MEDIDAS AS MedidasProducto,
                C.NOMBRE AS CategoriaProducto,
                IMG.URL_IMAGEN AS ImagenProducto,
                CAI.CANTIDAD AS CantidadCarrito,
                CAI.PRECIO_UNITARIO AS PrecioUnitarioCarrito,
                CARRITO.TOTAL AS TotalCarrito,
                PE.TOTAL AS TotalPedido,
                PE.ESTADO AS EstadoPedido,
                PE.FECHA AS FechaPedido,
                PI.CANTIDAD AS CantidadProductoPedido,
                PI.PRECIO_UNITARIO AS PrecioUnitarioPedido,
                PA.METODO_PAGO AS MetodoPago,
                PA.MONTO AS MontoPago,
                PA.FECHA AS FechaPago,
                RES.FECHA_RESERVA AS FechaReserva,
                RES.FECHA_LIMITE AS FechaLimiteReserva,
                RES.ESTADO AS EstadoReserva,
                VV.FECHA AS FechaVestidorVirtual,
                VV.PRODUCTO_ID AS ProductoVestidorVirtual,
                REP.TIPO_REPORTE AS TipoReporte,
                REP.DESCRIPCION AS DescripcionReporte,
                REP.FECHA_GENERACION AS FechaGeneracionReporte
            FROM
                USUARIOS U
                LEFT JOIN ROLES R ON U.ROL_ID = R.ID
                LEFT JOIN PEDIDOS PE ON U.ID = PE.USUARIO_ID
                LEFT JOIN PEDIDO_ITEMS PI ON PE.ID = PI.PEDIDO_ID
                LEFT JOIN PRODUCTOS P ON PI.PRODUCTO_ID = P.ID
                LEFT JOIN CATEGORIAS C ON P.CATEGORIA_ID = C.ID
                LEFT JOIN SUCURSALES S ON P.SUCURSAL_ID = S.ID
                LEFT JOIN IMAGENES_PRODUCTOS IMG ON P.ID = IMG.PRODUCTO_ID
                LEFT JOIN PAGOS PA ON PE.ID = PA.PEDIDO_ID
                LEFT JOIN RESERVAS RES ON U.ID = RES.USUARIO_ID AND P.ID = RES.PRODUCTO_ID
                LEFT JOIN VESTIDORES_VIRTUALES VV ON U.ID = VV.USUARIO_ID AND P.ID = VV.PRODUCTO_ID
                LEFT JOIN CARRITO_COMPRAS CARRITO ON U.ID = CARRITO.USUARIO_ID
                LEFT JOIN CARRITO_ITEMS CAI ON CARRITO.ID = CAI.CARRITO_ID AND P.ID = CAI.PRODUCTO_ID
                LEFT JOIN REPORTES REP ON REP.ID = U.ID
            ORDER BY
                U.ID, PE.FECHA DESC, RES.FECHA_RESERVA DESC, VV.FECHA DESC, REP.FECHA_GENERACION DESC;
        """;

        RowMapper<UsuarioInfoDTO> rowMapper = (rs, rowNum) -> {
            UsuarioInfoDTO usuarioInfoDTO = new UsuarioInfoDTO();
            usuarioInfoDTO.setUsuarioId(rs.getInt("UsuarioID"));
            usuarioInfoDTO.setNombreUsuario(rs.getString("NombreUsuario"));
            usuarioInfoDTO.setEmailUsuario(rs.getString("EmailUsuario"));
            usuarioInfoDTO.setFechaRegistroUsuario(rs.getTimestamp("FechaRegistroUsuario"));
            usuarioInfoDTO.setRolUsuario(rs.getString("RolUsuario"));
            usuarioInfoDTO.setNombreSucursal(rs.getString("NombreSucursal"));
            usuarioInfoDTO.setDireccionSucursal(rs.getString("DireccionSucursal"));
            usuarioInfoDTO.setNombreProducto(rs.getString("NombreProducto"));
            usuarioInfoDTO.setDescripcionProducto(rs.getString("DescripcionProducto"));
            usuarioInfoDTO.setTipoPrenda(rs.getString("TipoPrenda"));
            usuarioInfoDTO.setColorProducto(rs.getString("ColorProducto"));
            usuarioInfoDTO.setPrecioProducto(rs.getBigDecimal("PrecioProducto"));
            usuarioInfoDTO.setStockProducto(rs.getInt("StockProducto"));
            usuarioInfoDTO.setMedidasProducto(rs.getString("MedidasProducto"));
            usuarioInfoDTO.setCategoriaProducto(rs.getString("CategoriaProducto"));
            usuarioInfoDTO.setImagenProducto(rs.getString("ImagenProducto"));
            usuarioInfoDTO.setCantidadCarrito(rs.getInt("CantidadCarrito"));
            usuarioInfoDTO.setPrecioUnitarioCarrito(rs.getBigDecimal("PrecioUnitarioCarrito"));
            usuarioInfoDTO.setTotalCarrito(rs.getBigDecimal("TotalCarrito"));
            usuarioInfoDTO.setTotalPedido(rs.getBigDecimal("TotalPedido"));
            usuarioInfoDTO.setEstadoPedido(rs.getString("EstadoPedido"));
            usuarioInfoDTO.setFechaPedido(rs.getTimestamp("FechaPedido"));
            usuarioInfoDTO.setCantidadProductoPedido(rs.getInt("CantidadProductoPedido"));
            usuarioInfoDTO.setPrecioUnitarioPedido(rs.getBigDecimal("PrecioUnitarioPedido"));
            usuarioInfoDTO.setMetodoPago(rs.getString("MetodoPago"));
            usuarioInfoDTO.setMontoPago(rs.getBigDecimal("MontoPago"));
            usuarioInfoDTO.setFechaPago(rs.getTimestamp("FechaPago"));
            usuarioInfoDTO.setFechaReserva(rs.getTimestamp("FechaReserva"));
            usuarioInfoDTO.setFechaLimiteReserva(rs.getTimestamp("FechaLimiteReserva"));
            usuarioInfoDTO.setEstadoReserva(rs.getString("EstadoReserva"));
            usuarioInfoDTO.setFechaVestidorVirtual(rs.getTimestamp("FechaVestidorVirtual"));
            usuarioInfoDTO.setProductoVestidorVirtual(rs.getInt("ProductoVestidorVirtual"));
            usuarioInfoDTO.setTipoReporte(rs.getString("TipoReporte"));
            usuarioInfoDTO.setDescripcionReporte(rs.getString("DescripcionReporte"));
            usuarioInfoDTO.setFechaGeneracionReporte(rs.getTimestamp("FechaGeneracionReporte"));
            return usuarioInfoDTO;
        };

        return jdbcTemplate.query(sql, rowMapper);
    }
}
