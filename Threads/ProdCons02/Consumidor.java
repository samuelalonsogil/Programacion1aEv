package Threads.ProdCons02;


public class Consumidor extends Thread{
    private ColaS cola;
    private char c;

    public Consumidor(ColaS cola, char c) {
        this.cola = cola;
        this.c = c;
    }

    public void run() {
        char escupe = 55;
        for (int i = 0; i < 7; i++) {
            escupe = cola.get(); //pilla dato
            System.out.println(i + " => consumidor: " + escupe);
            //System.out.println(cola.toString());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
