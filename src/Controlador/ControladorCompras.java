package Controlador;

import Modelo.Compras;
import Modelo.DetalleCompra;
import java.sql.*;

public class ControladorCompras {

  // Método para guardar compra COMPLETA (con detalles)
  public int guardarCompraCompleta(Compras compra) {
    Connection cn = null;
    PreparedStatement psCompra = null;
    PreparedStatement psDetalle = null;
    ResultSet rs = null;

    try {
      cn = Conexion.Conexion.conectar();
      cn.setAutoCommit(false); // Iniciar transacción

      // 1. Guardar la compra principal
      String sqlCompra = "INSERT INTO compras (id_proveedor, fecha, descripcion, "
              + "sub_total, iva, total) VALUES (?, ?, ?, ?, ?, ?)";

      psCompra = cn.prepareStatement(sqlCompra, Statement.RETURN_GENERATED_KEYS);
      psCompra.setInt(1, compra.getId_proveedor());
      psCompra.setString(2, compra.getFecha());
      psCompra.setString(3, compra.getDescripcion());
      psCompra.setDouble(4, compra.getSub_total());
      psCompra.setDouble(5, compra.getIva());
      psCompra.setDouble(6, compra.getTotal());

      psCompra.executeUpdate();

      // Obtener el ID generado de la compra
      rs = psCompra.getGeneratedKeys();
      int idCompraGenerado = 0;
      if (rs.next()) {
        idCompraGenerado = rs.getInt(1);
      }

      if (idCompraGenerado == 0) {
        cn.rollback();
        return 0;
      }

      // 2. Guardar los detalles de la compra
      String sqlDetalle = "INSERT INTO detalle_compra (id_compra, id_inventario, "
              + "cantidad, precio, costo) VALUES (?, ?, ?, ?, ?)";

      psDetalle = cn.prepareStatement(sqlDetalle);

      for (DetalleCompra detalle : compra.getDetalles()) {
        psDetalle.setInt(1, idCompraGenerado);
        psDetalle.setInt(2, detalle.getId_inventario());
        psDetalle.setDouble(3, detalle.getCantidad());
        psDetalle.setDouble(4, detalle.getPrecio());
        psDetalle.setDouble(5, detalle.getCosto());
        psDetalle.addBatch();
      }

      psDetalle.executeBatch();

      // 3. Actualizar el inventario con las nuevas cantidades
      String sqlActualizarInventario = "UPDATE inventario SET "
              + "cantidad_disponible = cantidad_disponible + ?, "
              + "precio = ?, "
              + "Id_compra = ? WHERE Id_inventario = ?"; // ← AÑADIR Id_compra

      PreparedStatement psInventario = cn.prepareStatement(sqlActualizarInventario);

      for (DetalleCompra detalle : compra.getDetalles()) {
        psInventario.setDouble(1, detalle.getCantidad());
        psInventario.setDouble(2, detalle.getPrecio());
        psInventario.setInt(3, idCompraGenerado);
        psInventario.setInt(4, detalle.getId_inventario());
        psInventario.addBatch();
      }

      psInventario.executeBatch();
      psInventario.close();

      // Confirmar la transacción
      cn.commit();

      return idCompraGenerado;

    } catch (Exception e) {
      try {
        if (cn != null) {
          cn.rollback();
        }
      } catch (SQLException ex) {
        System.out.println("Error al hacer rollback: " + ex.getMessage());
      }
      System.out.println("Error al guardar compra completa: " + e.getMessage());
      e.printStackTrace();
      return 0;
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (psCompra != null) {
          psCompra.close();
        }
        if (psDetalle != null) {
          psDetalle.close();
        }
        if (cn != null) {
          cn.close();
        }
      } catch (SQLException e) {
        System.out.println("Error al cerrar conexiones: " + e.getMessage());
      }
    }
  }

  // Método para guardar un detalle individual
  public boolean guardarDetalleCompra(DetalleCompra detalle) {
    try {
      Connection cn = Conexion.Conexion.conectar();

      String sql = "INSERT INTO detalle_compra (id_compra, id_inventario, "
              + "cantidad, precio, costo) VALUES (?, ?, ?, ?, ?)";

      PreparedStatement ps = cn.prepareStatement(sql);
      ps.setInt(1, detalle.getId_compra());
      ps.setInt(2, detalle.getId_inventario());
      ps.setDouble(3, detalle.getCantidad());
      ps.setDouble(4, detalle.getPrecio());
      ps.setDouble(5, detalle.getCosto());

      boolean resultado = ps.executeUpdate() > 0;

      ps.close();
      cn.close();

      return resultado;

    } catch (Exception e) {
      System.out.println("Error al guardar detalle: " + e.getMessage());
      return false;
    }
  }

  // Método original para guardar solo la compra (se mantiene)
  public int guardarCompra(Compras compra) {
    // Código original que ya tienes...
    return guardarCompraSimple(compra.getId_proveedor(), compra.getFecha(), compra.getDescripcion());
  }

  // Método simplificado (se mantiene)
  public int guardarCompraSimple(int idProveedor, String fecha, String descripcion) {
    // Código original que ya tienes...
    try {
      Connection cn = Conexion.Conexion.conectar();
      String sql = "INSERT INTO compras (id_proveedor, fecha, descripcion, "
              + "sub_total, iva, total) VALUES (?, ?, ?, 0, 0, 0)";

      PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      ps.setInt(1, idProveedor);
      ps.setString(2, fecha);
      ps.setString(3, descripcion);

      ps.executeUpdate();

      ResultSet rs = ps.getGeneratedKeys();
      int idGenerado = 0;
      if (rs.next()) {
        idGenerado = rs.getInt(1);
      }

      rs.close();
      ps.close();
      cn.close();

      return idGenerado;

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return 0;
    }
  }

}
