package Vista;

import java.awt.Dimension;
import javax.swing.JOptionPane;

public class InterCompras extends javax.swing.JInternalFrame {

  /**
   * Creates new form InterCompras
   */
  public InterCompras() {
    initComponents();
    establecerFecha();
    this.setSize(new Dimension(400, 300));
    this.setTitle("Nueva Compra");

  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    tituloCompra = new javax.swing.JLabel();
    descripcion_Compra = new javax.swing.JLabel();
    campoDescripcion = new javax.swing.JTextField();
    numProveedor = new javax.swing.JLabel();
    campoProveedor = new javax.swing.JTextField();
    botonGuardar = new javax.swing.JButton();
    fecha = new javax.swing.JLabel();
    campoFecha = new javax.swing.JTextField();
    subTotal = new javax.swing.JLabel();
    campoSubtotal = new javax.swing.JTextField();
    iva = new javax.swing.JLabel();
    campoIVA = new javax.swing.JTextField();
    total = new javax.swing.JLabel();
    campoTotal = new javax.swing.JTextField();

    setClosable(true);
    setIconifiable(true);
    setResizable(true);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    tituloCompra.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    tituloCompra.setText("Nueva Compra");
    getContentPane().add(tituloCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

    descripcion_Compra.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    descripcion_Compra.setText("Descripcion de Compra:");
    getContentPane().add(descripcion_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
    getContentPane().add(campoDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 180, -1));

    numProveedor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    numProveedor.setText("Numero de Proveedor:");
    getContentPane().add(numProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
    getContentPane().add(campoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 180, -1));

    botonGuardar.setText("Guardar");
    botonGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        botonGuardarActionPerformed(evt);
      }
    });
    getContentPane().add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 100, 30));

    fecha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    fecha.setText("Fecha:");
    getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));
    getContentPane().add(campoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 150, -1));

    subTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    subTotal.setText("Sub-Total:");
    getContentPane().add(subTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

    campoSubtotal.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        campoSubtotalActionPerformed(evt);
      }
    });
    getContentPane().add(campoSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 150, -1));

    iva.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    iva.setText("IVA (16%):");
    getContentPane().add(iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));
    getContentPane().add(campoIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 150, -1));

    total.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    total.setText("Total:");
    getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));
    getContentPane().add(campoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 150, -1));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
    try {
      // 1. Obtener valores (la fecha ya viene en formato MySQL)
      String descripcion = campoDescripcion.getText().trim();
      String proveedorStr = campoProveedor.getText().trim();
      String fechaMySQL = campoFecha.getText().trim();  // Ya está en YYYY-MM-DD

      // 2. Validaciones básicas
      if (descripcion.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Ingrese una descripción para la compra",
                "Campo requerido", JOptionPane.WARNING_MESSAGE);
        campoDescripcion.requestFocus();
        return;
      }

      if (proveedorStr.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Ingrese el número de proveedor",
                "Campo requerido", JOptionPane.WARNING_MESSAGE);
        campoProveedor.requestFocus();
        return;
      }

      // 3. Convertir valores
      int proveedorId = Integer.parseInt(proveedorStr);

      // 4. Calcular totales si tienes sub-total
      double subTotal = 0;
      double iva = 0;
      double total = 0;

      // Si tienes campo para sub-total, úsalo
      if (campoSubtotal != null && !campoSubtotal.getText().trim().isEmpty()) {
        subTotal = Double.parseDouble(campoSubtotal.getText().trim());
        iva = subTotal * 0.16;
        total = subTotal + iva;

        // Mostrar valores calculados
        if (campoIVA != null) {
          campoIVA.setText(String.format("%.2f", iva));
        }
        if (campoTotal != null) {
          campoTotal.setText(String.format("%.2f", total));
        }
      }

      // 5. Crear objeto compra
      Modelo.Compras nuevaCompra = new Modelo.Compras();
      nuevaCompra.setDescripcion(descripcion);
      nuevaCompra.setId_proveedor(proveedorId);
      nuevaCompra.setFecha(fechaMySQL);  // ← Ya en formato correcto
      nuevaCompra.setSub_total(subTotal);
      nuevaCompra.setIva(iva);
      nuevaCompra.setTotal(total);

      // 6. Guardar usando controlador
      Controlador.ControladorCompras controlador = new Controlador.ControladorCompras();
      int idGenerado = controlador.guardarCompra(nuevaCompra);

      // 7. Mostrar resultado
      if (idGenerado > 0) {
        JOptionPane.showMessageDialog(this,
                "✓ COMPRA REGISTRADA EXITOSAMENTE\n\n"
                + "Número de compra: #" + idGenerado + "\n"
                + "Fecha: " + fechaMySQL + "\n"
                + "Proveedor: " + proveedorId + "\n"
                + "Descripción: " + descripcion,
                "ÉXITO", JOptionPane.INFORMATION_MESSAGE);

        // 8. Limpiar campos para nueva compra (opcional)
        limpiarCamposParaNuevaCompra();

      } else {
        JOptionPane.showMessageDialog(this,
                "✗ No se pudo guardar la compra\n"
                + "Verifique la conexión a la base de datos",
                "ERROR", JOptionPane.ERROR_MESSAGE);
      }

    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this,
              "El número de proveedor debe ser un valor numérico",
              "Error de formato", JOptionPane.ERROR_MESSAGE);
      campoProveedor.requestFocus();

    } catch (Exception e) {
      JOptionPane.showMessageDialog(this,
              "Error del sistema:\n" + e.getMessage(),
              "ERROR", JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();
    }
  }

  private void limpiarCamposParaNuevaCompra() {
    // Limpiar campos pero mantener la fecha actual
    campoDescripcion.setText("");
    campoProveedor.setText("");

    // Si tienes otros campos:
    if (campoSubtotal != null) {
      campoSubtotal.setText("");
    }
    if (campoIVA != null) {
      campoIVA.setText("");
    }
    if (campoTotal != null) {
      campoTotal.setText("");
    }

    // Actualizar fecha por si pasó a otro día
    establecerFecha();

    // Poner foco en el primer campo
    campoDescripcion.requestFocus();

  }//GEN-LAST:event_botonGuardarActionPerformed

  private void campoSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSubtotalActionPerformed
    calcularTotalesEnTiempoReal();
  }//GEN-LAST:event_campoSubtotalActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton botonGuardar;
  private javax.swing.JTextField campoDescripcion;
  private javax.swing.JTextField campoFecha;
  private javax.swing.JTextField campoIVA;
  private javax.swing.JTextField campoProveedor;
  private javax.swing.JTextField campoSubtotal;
  private javax.swing.JTextField campoTotal;
  private javax.swing.JLabel descripcion_Compra;
  private javax.swing.JLabel fecha;
  private javax.swing.JLabel iva;
  private javax.swing.JLabel numProveedor;
  private javax.swing.JLabel subTotal;
  private javax.swing.JLabel tituloCompra;
  private javax.swing.JLabel total;
  // End of variables declaration//GEN-END:variables

  private void limpiarCampos() {
    campoDescripcion.setText("");
    campoProveedor.setText("");
    campoFecha.setText("");
    campoSubtotal.setText("");
    campoIVA.setText("");
    campoTotal.setText("");
  }

  private void establecerFecha() {
    // Obtener fecha actual
    java.time.LocalDate fechaActual = java.time.LocalDate.now();

    // Formato YYYY-MM-DD (formato MySQL)
    String fechaMySQL = fechaActual.toString();

    // Mostrar en el campo de texto
    campoFecha.setText(fechaMySQL);
    campoFecha.setToolTipText("Fecha automática en formato MySQL (YYYY-MM-DD)");

  }

  private void calcularTotalesEnTiempoReal() {
    try {
      if (!campoSubtotal.getText().trim().isEmpty()) {
        double subTotal = Double.parseDouble(campoSubtotal.getText());
        double iva = subTotal * 0.16; // 16% de IVA
        double total = subTotal + iva;

        campoIVA.setText(String.format("%.2f", iva));
        campoTotal.setText(String.format("%.2f", total));
      }
    } catch (NumberFormatException e) {
      // Ignorar si no es un número válido aún
    }
  }

}
