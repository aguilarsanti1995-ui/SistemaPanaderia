package Controlador;

import Conexion.Conexion;
import Modelo.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;

public class ControladorUsuario {
    
    // Método para iniciar sesión CORREGIDO (sin inyección SQL)
    public boolean loginUser(Usuario usuario) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            cn = (Connection) Conexion.conectar();
            
            // Usar PreparedStatement para evitar inyección SQL
            String sql = "SELECT id_empleado FROM empleados WHERE id_empleado = ? AND password = ?";
            ps = cn.prepareStatement(sql);
            
            // Establecer parámetros
            ps.setInt(1, usuario.getId_Empleado()); // id_empleado es INT
            ps.setString(2, usuario.getPassword());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                respuesta = true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
        } finally {
            // Cerrar recursos en orden inverso
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexiones: " + e.getMessage());
            }
        }
        return respuesta;
    }
}