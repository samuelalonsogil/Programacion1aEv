package Prodcons;

public class consumidor extends Thread {

    private ColaS cola;
    private int n;

    public consumidor(ColaS cola, int n) {
        this.cola = cola;
        this.n = n;
    }

    public void run() {
        int valor = 0;
        for (int i = 0; i < 5; i++) {
            valor = cola.get(); //pilla dato
            System.out.println(i + " => consumidor: " + n + " "
                    + ", consume: " + valor);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
