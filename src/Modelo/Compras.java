package Modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Compras {

  private int id_compra;
  private int id_proveedor;
  private String fecha;
  private String descripcion;
  private double sub_total;
  private double iva;
  private double total;
  private List<DetalleCompra> detalles;

  public Compras() {
    this.id_compra = 0;
    this.id_proveedor = 0;
    this.fecha = "";
    this.descripcion = "";
    this.sub_total = 0;
    this.iva = 0;
    this.total = 0;
    this.detalles = new ArrayList<>();

  }

  public void agregarDetalle(DetalleCompra detalle) {
    detalles.add(detalle);
    calcularTotales();
  }

  public void eliminarDetalle(int index) {
    if (index >= 0 && index < detalles.size()) {
      detalles.remove(index);
      calcularTotales();
    }
  }

  public void calcularTotales() {
    this.sub_total = 0;
    for (DetalleCompra detalle : detalles) {
      this.sub_total += detalle.getCosto();
    }
    this.iva = this.sub_total * 0.16;
    this.total = this.sub_total + this.iva;
  }

  public List<DetalleCompra> getDetalles() {
    return detalles;
  }

  public void setDetalles(List<DetalleCompra> detalles) {
    this.detalles = detalles;
    calcularTotales();
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
