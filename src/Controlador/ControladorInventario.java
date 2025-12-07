package Controlador;

import Modelo.Inventario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ControladorInventario {
  // 1. Buscar por ID

  public Inventario buscarId(int id_inventario) throws Exception {
    Connection cn = Conexion.Conexion.conectar();
    PreparedStatement ps = cn.prepareStatement("SELECT * FROM inventario WHERE id_inventario = ?");
    ps.setInt(1, id_inventario);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
      return mapearInventario(rs);
    }
    return null;
  }

  // 2. Listar todo el inventario
  public List<Inventario> listarTodo() throws Exception {
    List<Inventario> lista = new ArrayList<>();
    Connection cn = Conexion.Conexion.conectar();
    ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM inventario ORDER BY nombre");

    while (rs.next()) {
      lista.add(mapearInventario(rs));
    }
    return lista;
  }

  // 3. Actualizar cantidad
  public boolean actualizarCantidad(int id, double cantidad) throws Exception {
    Connection cn = Conexion.Conexion.conectar();
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

}
