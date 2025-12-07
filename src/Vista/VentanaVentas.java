package Vista;

public class VentanaVentas {

  public static void main(String[] args) {
    Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
      @Override
      public void uncaughtException(Thread t, Throwable e) {
        System.err.println("Excepción no capturada en hilo: " + t.getName());
        e.printStackTrace();
      }
    });

    FrmLogin ventana = new FrmLogin();
    ventana.setSize(800, 600);
    ventana.setLocation(100, 100);
    ventana.setLocationRelativeTo(null);
    ventana.setVisible(true);

  }

}
