package Modelo;

public class Ventas {

  private int id_venta;
  private int id_cliente;
  private int id_empleado;
  private boolean tipo_cliente;
  private double sub_total;
  private double total_neto;
  private double descuento;
  private double iva;

  public Ventas(int id_venta, int id_cliente, int id_empleado, boolean tipo_cliente,
          double sub_total, double total_neto, double descuento, double iva) {
    this.id_venta = id_venta;
    this.id_cliente = id_cliente;
    this.id_empleado = id_empleado;
    this.tipo_cliente = tipo_cliente;
    this.sub_total = sub_total;
    this.total_neto = total_neto;
    this.descuento = descuento;
    this.iva = iva;
  }

  public Ventas() {
    this.id_venta = 0;
    this.id_cliente = 0;
    this.id_empleado = 0;
    this.tipo_cliente = true;
    this.sub_total = 0;
    this.total_neto = 0;
    this.descuento = 0;
    this.iva = 0;
  }

  public int getId_venta() {
    return id_venta;
  }

  public void setId_venta(int id_venta) {
    this.id_venta = id_venta;
  }

  public int getId_cliente() {
    return id_cliente;
  }

  public void setId_cliente(int id_cliente) {
    this.id_cliente = id_cliente;
  }

  public int getId_empleado() {
    return id_empleado;
  }

  public void setId_empleado(int id_empleado) {
    this.id_empleado = id_empleado;
  }

  public boolean isTipo_cliente() {
    return tipo_cliente;
  }

  public void setTipo_cliente(boolean tipo_cliente) {
    this.tipo_cliente = tipo_cliente;
  }

  public double getSub_total() {
    return sub_total;
  }

  public void setSub_total(double sub_total) {
    this.sub_total = sub_total;
  }

  public double getTotal_neto() {
    return total_neto;
  }

  public void setTotal_neto(double total_neto) {
    this.total_neto = total_neto;
  }

  public double getDescuento() {
    return descuento;
  }

  public void setDescuento(double descuento) {
    this.descuento = descuento;
  }

  public double getIva() {
    return iva;
  }

  public void setIva(double iva) {
    this.iva = iva;
  }

}
