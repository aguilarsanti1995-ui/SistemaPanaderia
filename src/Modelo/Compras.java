package Modelo;

public class Compras {

  private int id_compra;
  private int id_proveedor;
  private String fecha;
  private String descripcion;
  private double sub_total;
  private double iva;
  private double total;

  public Compras() {
    this.id_compra = 0;
    this.id_proveedor = 0;
    this.fecha = "";
    this.descripcion = "";
    this.sub_total = 0;
    this.iva = 0;
    this.total = 0;
    
  }

  public int getId_compra() {
    return id_compra;
  }

  public void setId_compra(int id_compra) {
    this.id_compra = id_compra;
  }

  public int getId_proveedor() {
    return id_proveedor;
  }

  public void setId_proveedor(int id_proveedor) {
    this.id_proveedor = id_proveedor;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public double getSub_total() {
    return sub_total;
  }

  public void setSub_total(double sub_total) {
    this.sub_total = sub_total;
  }

  public double getIva() {
    return iva;
  }

  public void setIva(double iva) {
    this.iva = iva;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

}
