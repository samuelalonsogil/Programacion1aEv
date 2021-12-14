package HILOS;

public class testPrimerHilo {
    public static void main(String[] args) {
        primerHilo uno = new primerHilo(5, "uno");
        primerHilo dos = new primerHilo(10, "dos");

        uno.start();
        dos.start();


        try {
            uno.join();
            dos.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("FIn del main (hilo 0)");
    }
}
