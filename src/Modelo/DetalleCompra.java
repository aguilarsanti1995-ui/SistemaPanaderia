package Modelo;

public class DetalleCompra {

  private int id_detalle_compra;
  private int id_compra;
  private int id_inventario;
  private double cantidad;
  private double precio;
  private double costo;  // costo = cantidad * precio

  // Constructores
  public DetalleCompra() {
    this.id_detalle_compra = 0;
    this.id_compra = 0;
    this.id_inventario = 0;
    this.cantidad = 0;
    this.precio = 0;
    this.costo = 0;
  }

  public DetalleCompra(int id_compra, int id_inventario, double cantidad, double precio) {
    this.id_compra = id_compra;
    this.id_inventario = id_inventario;
    this.cantidad = cantidad;
    this.precio = precio;
    this.costo = cantidad * precio;
  }

  // Getters y Setters
  public int getId_detalle_compra() {
    return id_detalle_compra;
  }

  public void setId_detalle_compra(int id_detalle_compra) {
    this.id_detalle_compra = id_detalle_compra;
  }

  public int getId_compra() {
    return id_compra;
  }

  public void setId_compra(int id_compra) {
    this.id_compra = id_compra;
  }

  public int getId_inventario() {
    return id_inventario;
  }

  public void setId_inventario(int id_inventario) {
    this.id_inventario = id_inventario;
  }

  public double getCantidad() {
    return cantidad;
  }

  public void setCantidad(double cantidad) {
    this.cantidad = cantidad;
    this.costo = this.cantidad * this.precio; // Actualizar costo automáticamente
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
    this.costo = this.cantidad * this.precio; // Actualizar costo automáticamente
  }

  public double getCosto() {
    return costo;
  }

  public void setCosto(double costo) {
    this.costo = costo;
  }

}
