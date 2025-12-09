package Controlador;

import Conexion.Conexion;
import Modelo.Inventario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorInventario {

  // Método para buscar ID por nombre (NUEVO - para InterCompras)
  public int buscarIdPorNombre(String nombre) {
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
      cn = Conexion.conectar();
      ps = cn.prepareStatement("SELECT id_inventario FROM inventario WHERE nombre = ?");
      ps.setString(1, nombre);
      rs = ps.executeQuery();

      if (rs.next()) {
        return rs.getInt("id_inventario");
      }
      return 0;

    } catch (Exception e) {
      System.out.println("Error en buscarIdPorNombre: " + e.getMessage());
      return 0;
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (ps != null) {
          ps.close();
        }
        if (cn != null) {
          cn.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  // 1. Buscar por nombre
  public Inventario buscarPorNombre(String nombre) throws Exception {
    Connection cn = Conexion.conectar();
    PreparedStatement ps = cn.prepareStatement(
            "SELECT * FROM inventario WHERE nombre = ?");
    ps.setString(1, nombre);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
      return mapearInventario(rs);
    }
    return null;
  }

  // 2. Listar todo el inventario
  public List<Inventario> listarTodo() throws Exception {
    List<Inventario> lista = new ArrayList<>();
    Connection cn = Conexion.conectar();
    ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM inventario ORDER BY nombre");

    while (rs.next()) {
      lista.add(mapearInventario(rs));
    }
    return lista;
  }

  // 3. Actualizar cantidad
  public boolean actualizarCantidad(int id, double cantidad) throws Exception {
    Connection cn = Conexion.conectar();
    PreparedStatement ps = cn.prepareStatement(
            "UPDATE inventario SET cantidad_disponible = ? WHERE id_inventario = ?");
    ps.setDouble(1, cantidad);
    ps.setInt(2, id);
    return ps.executeUpdate() > 0;
  }

  // Método privado para mapear el ResultSet
  private Inventario mapearInventario(ResultSet rs) throws SQLException {
    return new Inventario(
            rs.getInt("id_inventario"),
            rs.getInt("id_compra"),
            rs.getString("nombre"),
            rs.getString("unidad_medida"),
            rs.getDouble("cantidad_disponible"),
            rs.getDouble("precio")
    );
  }

  public int agregarInventario(Inventario ingrediente) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = Conexion.conectar();

      // PRIMERO: Obtener el máximo ID actual
      String sqlMaxId = "SELECT MAX(Id_inventario) FROM inventario";
      pstmt = conn.prepareStatement(sqlMaxId);
      rs = pstmt.executeQuery();

      int nuevoId = 1; // Valor por defecto si la tabla está vacía
      if (rs.next()) {
        int maxId = rs.getInt(1);
        nuevoId = maxId + 1;
      }
      rs.close();
      pstmt.close();

      // SEGUNDO: Insertar con el nuevo ID
      String sqlInsert = "INSERT INTO inventario (Id_inventario, Id_compra, nombre, unidad_medida, cantidad_disponible, precio) VALUES (?, ?, ?, ?, ?, ?)";
      pstmt = conn.prepareStatement(sqlInsert);

      pstmt.setInt(1, nuevoId);  // ← Usar el ID generado
      pstmt.setInt(2, ingrediente.getId_compra());
      pstmt.setString(3, ingrediente.getNombre());
      pstmt.setString(4, ingrediente.getUnidad_medida());
      pstmt.setDouble(5, ingrediente.getCantidad_disponible());
      pstmt.setDouble(6, ingrediente.getPrecio());

      int filasAfectadas = pstmt.executeUpdate();

      if (filasAfectadas > 0) {
        return nuevoId;  // ← Devolver el ID generado
      } else {
        return 0;
      }

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "ERROR en agregarInventario: " + e.getMessage());
      e.printStackTrace();
      return 0;
    } finally {
      try {
        if (pstmt != null) {
          pstmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

 }
