package Threads.Contador;

public class TesteoContar {

    public static void main(String[] args) {
        Contador contador = new Contador(100);
        HiloInc hiloInc = new HiloInc("hilo a", contador);
        HiloDec hiloDec = new HiloDec("hilo b", contador);

        hiloInc.start();
        hiloDec.start();
        System.out.println("Fin main");
    }
}
