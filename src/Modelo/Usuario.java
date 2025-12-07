package Modelo;


public class Usuario {
  //atributos
  private int id_Empleado;
  private int id_Cargo; 
  private String nombre;
  private String apellidos;
  private String password; 
  private String telefono;
  private String fecha_contratacion;
  private double sueldo;
  private int horas;
  
  //constructor

  public Usuario() {
  }
    
  public Usuario(int id_Empleado, int id_Cargo, String nombre, String apellidos, String password, String telefono, 
          String fecha_contratacion, double sueldo, int horas) {
    this.id_Empleado = 0;
    this.id_Cargo = 0;
    this.nombre = "";
    this.apellidos = "";
    this.password = "";
    this.telefono = "";
    this.fecha_contratacion = "";
    this.sueldo = 0;
    this.horas = 0;
    
  }

  
  //get and set
  public int getId_Empleado() {
    return id_Empleado;
  }

  public void setId_Empleado(int id_Empleado) {
    this.id_Empleado = id_Empleado;
  }

  public int getId_Cargo() {
    return id_Cargo;
  }

  public void setId_Cargo(int id_Cargo) {
    this.id_Cargo = id_Cargo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getFecha_contratacion() {
    return fecha_contratacion;
  }

  public void setFecha_contratacion(String fecha_contratacion) {
    this.fecha_contratacion = fecha_contratacion;
  }

  public double getSueldo() {
    return sueldo;
  }

  public void setSueldo(double sueldo) {
    this.sueldo = sueldo;
  }

  public int getHoras() {
    return horas;
  }

  public void setHoras(int horas) {
    this.horas = horas;
  }
  
  
  
  
  
}
