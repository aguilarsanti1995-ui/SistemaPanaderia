package Modelo;


public class Inventario {
  private int id_inventario;
  private int id_compra;
  private String nombre;
  private String unidad_medida;
  private double cantidad_disponible;
  private double precio;

  public Inventario() {
    this.id_inventario = 0;
    this.id_compra = 0;
    this.nombre = "";
    this.unidad_medida = "";
    this.cantidad_disponible = 0;
    this.precio = 0;
    
  }
 
  public Inventario(int id_inventario, int id_compra, String nombre, String unidad_medida, double cantidad_disponible, double precio) {
    this.id_inventario = id_inventario;
    this.id_compra = id_compra;
    this.nombre = nombre;
    this.unidad_medida = unidad_medida;
    this.cantidad_disponible = cantidad_disponible;
    this.precio = precio;
  }

  public int getId_inventario() {
    return id_inventario;
  }

  public void setId_inventario(int id_inventario) {
    this.id_inventario = id_inventario;
  }

  public int getId_compra() {
    return id_compra;
  }

  public void setId_compra(int id_compra) {
    this.id_compra = id_compra;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getUnidad_medida() {
    return unidad_medida;
  }

  public void setUnidad_medida(String unidad_medida) {
    this.unidad_medida = unidad_medida;
  }

  public double getCantidad_disponible() {
    return cantidad_disponible;
  }

  public void setCantidad_disponible(double cantidad_disponible) {
    this.cantidad_disponible = cantidad_disponible;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }
  
  
}
