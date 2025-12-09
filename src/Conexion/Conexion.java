package Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

  //conexion local 
  // Método para conectar a la base de datos
  public static Connection conectar() {
    Connection cn = null;

    try {      
      // 1. IMPORTANTE: Cargar el driver de MySQL
      Class.forName("com.mysql.jdbc.Driver");

      // 2. URL CORREGIDA (nota los dos puntos después de mysql)
      //String url = "jdbc:mysql://localhost:3306/panaderia_base";
      String url = "jdbc:mysql://localhost:3306/panaderia_base?useSSL=false&allowPublicKeyRetrieval=true";
      String usuario = "root";
      String password = "Jias1993.A";

      // 3. Establecer conexión
      cn = (Connection) DriverManager.getConnection(url, usuario, password);

      // Verificar conexión
      if (cn != null && !cn.isClosed()) {
        System.out.println("Conexión exitosa a la base de datos");
      }

    } catch (ClassNotFoundException e) {
      System.err.println("Error: No se encontró el driver de MySQL");
      JOptionPane.showMessageDialog(null,
              "Error: Driver de MySQL no encontrado\n"
              + "Asegúrate de agregar mysql-connector-java.jar al proyecto",
              "Error de Driver", JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();

    } catch (SQLException e) {
      System.err.println("Error de conexión SQL: " + e.getMessage());
      JOptionPane.showMessageDialog(null,
              "Error al conectar con la base de datos:\n" + e.getMessage(),
              "Error de Conexión", JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();
    }

    return cn;
  }
}
