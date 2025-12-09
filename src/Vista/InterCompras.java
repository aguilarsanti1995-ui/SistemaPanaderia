package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class InterCompras extends javax.swing.JInternalFrame {

  /**
   * Creates new form InterCompras
   */
  public InterCompras() {
    initComponents();
    configurarModeloTabla();
    establecerFecha();
    this.setSize(new Dimension(800, 600));
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
    total = new javax.swing.JLabel();
    campoTotal = new javax.swing.JTextField();
    panelCentro = new javax.swing.JScrollPane();
    tablaIngredientes = new javax.swing.JTable();
    panelNuevoIngrediente = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    campoIngrediente = new javax.swing.JTextField();
    campoCantidad = new javax.swing.JTextField();
    comboUnidades = new javax.swing.JComboBox<>();
    campoPrecio = new javax.swing.JTextField();
    botonAgregar = new javax.swing.JButton();
    botonEliminar = new javax.swing.JButton();
    botonLimpiar = new javax.swing.JButton();
    campoIVA = new javax.swing.JTextField();

    setClosable(true);
    setIconifiable(true);
    setResizable(true);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    tituloCompra.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    tituloCompra.setText("Nueva Compra");
    getContentPane().add(tituloCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

    descripcion_Compra.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    descripcion_Compra.setText("Descripcion de Compra:");
    getContentPane().add(descripcion_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));
    getContentPane().add(campoDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 280, -1));

    numProveedor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    numProveedor.setText("Numero de Proveedor:");
    getContentPane().add(numProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
    getContentPane().add(campoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 280, -1));

    botonGuardar.setText("Guardar");
    botonGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        botonGuardarActionPerformed(evt);
      }
    });
    getContentPane().add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 100, 30));

    fecha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    fecha.setText("Fecha:");
    getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));
    getContentPane().add(campoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 150, -1));

    subTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    subTotal.setText("Sub-Total:");
    getContentPane().add(subTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));
    getContentPane().add(campoSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 150, -1));

    iva.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    iva.setText("IVA (16%):");
    getContentPane().add(iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, -1, -1));

    total.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    total.setText("Total:");
    getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, -1, -1));
    getContentPane().add(campoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, 150, -1));

    tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {

      }
    ));
    panelCentro.setViewportView(tablaIngredientes);

    getContentPane().add(panelCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 710, 190));

    panelNuevoIngrediente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel1.setText("Ingrediente: ");
    panelNuevoIngrediente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

    jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel2.setText("Cantidad:");
    panelNuevoIngrediente.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

    jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel3.setText("Unidad: ");
    panelNuevoIngrediente.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

    jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel4.setText("Precio: ");
    panelNuevoIngrediente.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));
    panelNuevoIngrediente.add(campoIngrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 240, -1));
    panelNuevoIngrediente.add(campoCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 150, -1));

    comboUnidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kg", "g", "L", "ml", "Unidades" }));
    panelNuevoIngrediente.add(comboUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));
    panelNuevoIngrediente.add(campoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 150, -1));

    botonAgregar.setText("Agregar");
    botonAgregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        botonAgregarActionPerformed(evt);
      }
    });
    panelNuevoIngrediente.add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 100, 30));

    botonEliminar.setText("Eliminar");
    botonEliminar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        botonEliminarActionPerformed(evt);
      }
    });
    panelNuevoIngrediente.add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 100, 30));

    getContentPane().add(panelNuevoIngrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 710, 160));

    botonLimpiar.setText("Limpiar");
    botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        botonLimpiarActionPerformed(evt);
      }
    });
    getContentPane().add(botonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 100, 30));
    getContentPane().add(campoIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 150, -1));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
    try {
      // 1. Validar datos básicos
      String descripcion = campoDescripcion.getText().trim();
      String proveedorStr = campoProveedor.getText().trim();
      String fecha = campoFecha.getText().trim();

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

      if (fecha.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Ingrese la fecha de la compra",
                "Campo requerido", JOptionPane.WARNING_MESSAGE);
        campoFecha.requestFocus();
        return;
      }

      // Validar formato de fecha (YYYY-MM-DD)
      if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
        JOptionPane.showMessageDialog(this,
                "Formato de fecha incorrecto. Use YYYY-MM-DD\n"
                + "Ejemplo: 2024-01-15",
                "Formato inválido", JOptionPane.WARNING_MESSAGE);
        campoFecha.requestFocus();
        return;
      }

      // 2. Validar que haya ingredientes en la tabla
      if (tablaIngredientes.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this,
                "Debe agregar al menos un ingrediente a la compra",
                "Sin ingredientes", JOptionPane.WARNING_MESSAGE);
        campoIngrediente.requestFocus();
        return;
      }

      // 3. Convertir valores
      int proveedorId;
      try {
        proveedorId = Integer.parseInt(proveedorStr);
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "El número de proveedor debe ser un valor numérico",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        campoProveedor.requestFocus();
        return;
      }

      double subtotal = Double.parseDouble(campoSubtotal.getText().replace(",", ""));
      double iva = Double.parseDouble(campoIVA.getText().replace(",", ""));
      double total = Double.parseDouble(campoTotal.getText().replace(",", ""));

      // 4. Crear objeto Compra
      Modelo.Compras nuevaCompra = new Modelo.Compras();
      nuevaCompra.setDescripcion(descripcion);
      nuevaCompra.setId_proveedor(proveedorId);
      nuevaCompra.setFecha(fecha);
      nuevaCompra.setSub_total(subtotal);
      nuevaCompra.setIva(iva);
      nuevaCompra.setTotal(total);

      // 5. Agregar detalles desde la tabla
      DefaultTableModel modelo = (DefaultTableModel) tablaIngredientes.getModel();

      for (int i = 0; i < modelo.getRowCount(); i++) {
        Modelo.DetalleCompra detalle = new Modelo.DetalleCompra();

        // Obtener valores de la fila
        Object idObj = modelo.getValueAt(i, 0);
        int idIngrediente = (idObj != null) ? (Integer) idObj : 0;

        detalle.setId_inventario(idIngrediente);
        detalle.setCantidad((Double) modelo.getValueAt(i, 2));
        detalle.setPrecio((Double) modelo.getValueAt(i, 4));
        detalle.setCosto((Double) modelo.getValueAt(i, 5));

        nuevaCompra.agregarDetalle(detalle);
      }

      // 6. Mostrar resumen antes de guardar
      StringBuilder resumen = new StringBuilder();
      resumen.append("=== RESUMEN DE COMPRA ===\n\n");
      resumen.append("Descripción: ").append(descripcion).append("\n");
      resumen.append("Proveedor: ").append(proveedorId).append("\n");
      resumen.append("Fecha: ").append(fecha).append("\n");
      resumen.append("Ingredientes: ").append(modelo.getRowCount()).append("\n");
      resumen.append("Subtotal: $").append(String.format("%.2f", subtotal)).append("\n");
      resumen.append("IVA (16%): $").append(String.format("%.2f", iva)).append("\n");
      resumen.append("TOTAL: $").append(String.format("%.2f", total)).append("\n\n");
      resumen.append("¿Desea guardar esta compra?");

      int confirmacion = JOptionPane.showConfirmDialog(this,
              resumen.toString(),
              "Confirmar guardado", JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE);

      if (confirmacion != JOptionPane.YES_OPTION) {
        return; // El usuario canceló
      }

      // 7. Guardar en base de datos
      Controlador.ControladorCompras controlador = new Controlador.ControladorCompras();
      int idCompraGenerado = controlador.guardarCompraCompleta(nuevaCompra);

      // 8. Mostrar resultado
      if (idCompraGenerado > 0) {
        // Crear mensaje de éxito con detalles
        StringBuilder mensajeExito = new StringBuilder();
        mensajeExito.append("✓ COMPRA GUARDADA EXITOSAMENTE\n\n");
        mensajeExito.append("Número de compra: #").append(idCompraGenerado).append("\n");
        mensajeExito.append("Fecha: ").append(fecha).append("\n");
        mensajeExito.append("Proveedor: ").append(proveedorId).append("\n");
        mensajeExito.append("Descripción: ").append(descripcion).append("\n");
        mensajeExito.append("Ingredientes: ").append(modelo.getRowCount()).append("\n");
        mensajeExito.append("Total: $").append(String.format("%.2f", total)).append("\n");
        mensajeExito.append("\n¿Desea realizar otra compra?");

        int opcion = JOptionPane.showConfirmDialog(this,
                mensajeExito.toString(),
                "COMPRA EXITOSA", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
          // Limpiar para nueva compra
          limpiarFormulario();
        } else {
          // Cerrar ventana
          this.dispose();
        }

      } else {
        JOptionPane.showMessageDialog(this,
                "✗ Error al guardar la compra\n"
                + "Verifique:\n"
                + "1. Conexión a la base de datos\n"
                + "2. Datos del proveedor\n"
                + "3. Ingredientes válidos",
                "ERROR AL GUARDAR", JOptionPane.ERROR_MESSAGE);
      }

    } catch (Exception e) {
      JOptionPane.showMessageDialog(this,
              "Error del sistema:\n" + e.getMessage()
              + "\n\nRevise que todos los datos sean correctos.",
              "ERROR", JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();
    }
  }//GEN-LAST:event_botonGuardarActionPerformed

  private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
    try {
      // 1. Obtener datos del formulario
      String ingredienteNombre = campoIngrediente.getText().trim();
      String cantidadStr = campoCantidad.getText().trim();
      String unidad = comboUnidades.getSelectedItem().toString();
      String precioStr = campoPrecio.getText().trim();

      // 2. Validaciones
      if (ingredienteNombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el nombre del ingrediente",
                "Campo requerido", JOptionPane.WARNING_MESSAGE);
        campoIngrediente.requestFocus();
        return;
      }

      if (cantidadStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese la cantidad",
                "Campo requerido", JOptionPane.WARNING_MESSAGE);
        campoCantidad.requestFocus();
        return;
      }

      if (precioStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el precio unitario",
                "Campo requerido", JOptionPane.WARNING_MESSAGE);
        campoPrecio.requestFocus();
        return;
      }

      // 3. Convertir valores
      double cantidad = Double.parseDouble(cantidadStr);
      double precioUnitario = Double.parseDouble(precioStr.replace(",", ""));
      double costo = cantidad * precioUnitario;

      // 4. BUSCAR EL ID DEL INGREDIENTE EN LA BASE DE DATOS
      Controlador.ControladorInventario ctrlInventario = new Controlador.ControladorInventario();
      int idIngrediente = ctrlInventario.buscarIdPorNombre(ingredienteNombre);

      if (idIngrediente <= 0) {
        // Si no existe, preguntar si se desea crear
        int opcion = JOptionPane.showConfirmDialog(this,
                "El ingrediente '" + ingredienteNombre + "' no existe.\n¿Desea crearlo?",
                "Ingrediente no encontrado", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
          // Crear nuevo ingrediente
          Modelo.Inventario nuevoIngrediente = new Modelo.Inventario();
          nuevoIngrediente.setNombre(ingredienteNombre);
          nuevoIngrediente.setId_compra(0);
          nuevoIngrediente.setUnidad_medida(unidad);
          nuevoIngrediente.setCantidad_disponible(0.0); // Iniciar con 0
          nuevoIngrediente.setPrecio(precioUnitario);

          idIngrediente = ctrlInventario.agregarInventario(nuevoIngrediente);

          if (idIngrediente <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Error al crear el ingrediente",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
          }
        } else {
          return; // Usuario canceló
        }
      }

      // 5. Agregar a la tabla
      DefaultTableModel modelo = (DefaultTableModel) tablaIngredientes.getModel();
      modelo.addRow(new Object[]{
        idIngrediente,
        ingredienteNombre,
        cantidad,
        unidad,
        precioUnitario,
        costo
      });

      // 6. Limpiar campos
      campoIngrediente.setText("");
      campoCantidad.setText("");
      campoPrecio.setText("");
      campoIngrediente.requestFocus();

      // 7. Actualizar totales
      calcularTotales();

    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this,
              "Error en formato numérico: " + e.getMessage(),
              "Error de formato", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this,
              "Error al agregar ingrediente: " + e.getMessage(),
              "Error", JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();
    }
  }

  private void limpiarCamposIngrediente() {
    campoIngrediente.setText("");
    campoCantidad.setText("");
    campoPrecio.setText("");
    comboUnidades.setSelectedIndex(0); // Primer item
  }//GEN-LAST:event_botonAgregarActionPerformed

  private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
    int filaSeleccionada = tablaIngredientes.getSelectedRow();

    if (filaSeleccionada >= 0) {
      // Obtener nombre del ingrediente a eliminar
      String nombreIngrediente = tablaIngredientes.getValueAt(filaSeleccionada, 1).toString();

      // Pedir confirmación
      int confirmacion = JOptionPane.showConfirmDialog(this,
              "¿Está seguro de eliminar '" + nombreIngrediente + "' de la compra?",
              "Confirmar eliminación", JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE);

      if (confirmacion == JOptionPane.YES_OPTION) {
        // Eliminar fila de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tablaIngredientes.getModel();
        modelo.removeRow(filaSeleccionada);

        // Actualizar totales
        calcularTotales();

        // Mensaje de confirmación
        JOptionPane.showMessageDialog(this,
                "Ingrediente eliminado correctamente",
                "Eliminado", JOptionPane.INFORMATION_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(this,
              "Seleccione un ingrediente de la tabla para eliminar",
              "Sin selección", JOptionPane.WARNING_MESSAGE);
    }

  }//GEN-LAST:event_botonEliminarActionPerformed

  private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed

    // Preguntar confirmación
    int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de limpiar todo el formulario?\n"
            + "Se perderán todos los datos ingresados.",
            "Confirmar limpieza", JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

    if (confirmacion == JOptionPane.YES_OPTION) {
      limpiarFormulario();
    }
  }

  private void limpiarFormulario() {
    // Limpiar campos básicos
    campoDescripcion.setText("");
    campoProveedor.setText("");

    // Poner fecha actual
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    campoFecha.setText(sdf.format(new Date()));

    // Limpiar campos de ingrediente
    limpiarCamposIngrediente();

    // Limpiar tabla
    DefaultTableModel modelo = (DefaultTableModel) tablaIngredientes.getModel();
    modelo.setRowCount(0);

    // Reiniciar totales
    campoSubtotal.setText("0.00");
    campoIVA.setText("0.00");
    campoTotal.setText("0.00");

    // Poner foco en primer campo
    campoDescripcion.requestFocus();

    JOptionPane.showMessageDialog(this,
            "Formulario limpiado correctamente",
            "Limpieza completada", JOptionPane.INFORMATION_MESSAGE);
  }//GEN-LAST:event_botonLimpiarActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton botonAgregar;
  private javax.swing.JButton botonEliminar;
  private javax.swing.JButton botonGuardar;
  private javax.swing.JButton botonLimpiar;
  private javax.swing.JTextField campoCantidad;
  private javax.swing.JTextField campoDescripcion;
  private javax.swing.JTextField campoFecha;
  private javax.swing.JTextField campoIVA;
  private javax.swing.JTextField campoIngrediente;
  private javax.swing.JTextField campoPrecio;
  private javax.swing.JTextField campoProveedor;
  private javax.swing.JTextField campoSubtotal;
  private javax.swing.JTextField campoTotal;
  private javax.swing.JComboBox<String> comboUnidades;
  private javax.swing.JLabel descripcion_Compra;
  private javax.swing.JLabel fecha;
  private javax.swing.JLabel iva;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel numProveedor;
  private javax.swing.JScrollPane panelCentro;
  private javax.swing.JPanel panelNuevoIngrediente;
  private javax.swing.JLabel subTotal;
  private javax.swing.JTable tablaIngredientes;
  private javax.swing.JLabel tituloCompra;
  private javax.swing.JLabel total;
  // End of variables declaration//GEN-END:variables

  private void establecerFecha() {
    // Obtener fecha actual
    java.time.LocalDate fechaActual = java.time.LocalDate.now();

    // Formato YYYY-MM-DD (formato MySQL)
    String fechaMySQL = fechaActual.toString();

    // Mostrar en el campo de texto
    campoFecha.setText(fechaMySQL);
    campoFecha.setToolTipText("Fecha automática en formato MySQL (YYYY-MM-DD)");

  }

  private void calcularTotales() {
    try {
      DefaultTableModel modelo = (DefaultTableModel) tablaIngredientes.getModel();

      double subtotal = 0.0;

      // Sumar todos los costos de la tabla
      for (int i = 0; i < modelo.getRowCount(); i++) {
        Object valorCosto = modelo.getValueAt(i, 5); // Columna Costo

        if (valorCosto instanceof Number) {
          subtotal += ((Number) valorCosto).doubleValue();
        } else if (valorCosto instanceof String) {
          try {
            String str = ((String) valorCosto).replace("$", "").replace(",", "").trim();
            subtotal += Double.parseDouble(str);
          } catch (NumberFormatException e) {
            // Ignorar si no es número
          }
        }
      }

      // Calcular IVA (16%)
      double iva = subtotal * 0.16;

      // Calcular total
      double total = subtotal + iva;

      // Formatear y mostrar
      DecimalFormat df = new DecimalFormat("#,##0.00");

      campoSubtotal.setText(df.format(subtotal));
      campoIVA.setText(df.format(iva));
      campoTotal.setText(df.format(total));

      // Cambiar color del total si es mayor a 0
      if (total > 0) {
        campoTotal.setForeground(Color.RED);
        campoTotal.setFont(new Font("Arial", Font.BOLD, 14));
      } else {
        campoTotal.setForeground(Color.BLACK);
        campoTotal.setFont(new Font("Arial", Font.PLAIN, 12));
      }

    } catch (Exception e) {
      System.err.println("Error calculando totales: " + e.getMessage());
    }
  }

  private void configurarModeloTabla() {
    // Crear modelo de tabla
    String[] nombresColumnas = {"ID", "Ingrediente", "Cantidad", "Unidad", "Precio Unit.", "Costo"};

    DefaultTableModel modelo = new DefaultTableModel(nombresColumnas, 0) {
      @Override
      public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
          case 0:
            return Integer.class;
          case 1:
            return String.class;
          case 2:
            return Double.class;
          case 3:
            return String.class;
          case 4:
            return Double.class;
          case 5:
            return Double.class;
          default:
            return Object.class;
        }
      }

      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };

    // Aplicar modelo a la tabla
    tablaIngredientes.setModel(modelo);

    // Configurar anchos DESPUÉS de establecer el modelo
    SwingUtilities.invokeLater(() -> {
      try {
        javax.swing.table.TableColumnModel columnModel = tablaIngredientes.getColumnModel();

        if (columnModel.getColumnCount() >= 6) {
          columnModel.getColumn(0).setPreferredWidth(40);
          columnModel.getColumn(1).setPreferredWidth(150);
          columnModel.getColumn(2).setPreferredWidth(70);
          columnModel.getColumn(3).setPreferredWidth(60);
          columnModel.getColumn(4).setPreferredWidth(90);
          columnModel.getColumn(5).setPreferredWidth(90);
        }

        tablaIngredientes.setRowHeight(25);
        tablaIngredientes.getTableHeader().setReorderingAllowed(false);

      } catch (Exception e) {
        System.err.println("Error configurando anchos de columnas: " + e.getMessage());
      }
    });

  }

}
