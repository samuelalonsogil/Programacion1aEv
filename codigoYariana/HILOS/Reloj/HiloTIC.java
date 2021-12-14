package HILOS.Reloj;

public class HiloTIC extends Thread {
    static final String TIC = "TIC";
    Recurso linea;

    public HiloTIC(Recurso l) {
        // TODO Auto-generated constructor stub
        this.linea = l;
    }

    public void run() {

        synchronized (linea) {
            for (int i = 1; i <= 2; i++) {
                linea.setMostrar(TIC);
                System.out.println(linea.toString());
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } // fin sincro

    }
}