package Controlador;

import Modelo.Compras;
import java.sql.*;

public class ControladorCompras {

  // Método para guardar compra (con auto_increment)
  public int guardarCompra(Compras compra) {
    // Ahora retorna el ID generado, en lugar de boolean
    try {
      Connection cn = Conexion.Conexion.conectar();

      // NO incluimos id_compra en el INSERT
      String sql = "INSERT INTO compras (id_proveedor, fecha, descripcion, "
              + "sub_total, iva, total) VALUES (?, ?, ?, ?, ?, ?)";

      // Usamos RETURN_GENERATED_KEYS para obtener el ID
      PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

      ps.setInt(1, compra.getId_proveedor());
      ps.setString(2, compra.getFecha());
      ps.setString(3, compra.getDescripcion());
      ps.setDouble(4, compra.getSub_total());
      ps.setDouble(5, compra.getIva());
      ps.setDouble(6, compra.getTotal());

      int filas = ps.executeUpdate();

      int idGenerado = 0;

      if (filas > 0) {
        // Obtener el ID que MySQL generó automáticamente
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
          idGenerado = rs.getInt(1);
        }
        rs.close();
      }

      ps.close();
      cn.close();

      return idGenerado; // Retorna 0 si hubo error, o el ID si fue exitoso

    } catch (Exception e) {
      System.out.println("Error al guardar compra: " + e.getMessage());
      return 0;
    }
  }

  // Método simplificado para guardar (sin necesidad de calcular ID)
  public int guardarCompraSimple(int idProveedor, String fecha, String descripcion) {
    try {
      Connection cn = Conexion.Conexion.conectar();

      String sql = "INSERT INTO compras (id_proveedor, fecha, descripcion, "
              + "sub_total, iva, total) VALUES (?, ?, ?, 0, 0, 0)";

      PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      ps.setInt(1, idProveedor);
      ps.setString(2, fecha);
      ps.setString(3, descripcion);

      ps.executeUpdate();

      // Obtener ID generado
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
