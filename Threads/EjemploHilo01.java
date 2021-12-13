package Threads;

public class EjemploHilo01 extends Thread{

    private final String n;
    private int x;

    EjemploHilo01(int x, String n) {
        this.x = x;
        this.n = n;
        System.out.println("se ha creado un nuevo hilo llamado " + n);
    }

    public void run() {
        for (int i = 0; i < x; i++) {
            System.out.println("En el HIlo...");
        }
    }
}
