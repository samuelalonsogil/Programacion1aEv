package HILOS.Reloj;

public class HiloTAC extends Thread {

    static final String TAC = "TAC...";
    Recurso linea;

    public HiloTAC(Recurso l) {
        // TODO Auto-generated constructor stub
        this.linea = l;
    }

    public void run() {

        synchronized (linea) {
            for (int j = 1; j <= 2; j++) {
                linea.setMostrar(TAC);
                System.out.println(linea.toString());
                try {
                    Thread.sleep((int) (Math.random() * 1500));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } // fin sincro

    }

}