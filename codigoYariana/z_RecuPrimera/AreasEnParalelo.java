package z_RecuPrimera;

public class AreasEnParalelo {
    public static void main(String[] args) throws InterruptedException {

        CalculadorArea ca = new CalculadorArea(1, 2);
        final int MAX_HILOS = 100000;
        Thread[] hilos = new Thread[MAX_HILOS];

        for (int i = 0; i < MAX_HILOS; i++) {
            hilos[i] = new Thread(ca);
            hilos[i].start();
        }

        for (int i = 0; i < MAX_HILOS; i++) {
            hilos[i].join();
        }
        System.out.printf("Total de cálculos: " + ca.contador);
    }
}
