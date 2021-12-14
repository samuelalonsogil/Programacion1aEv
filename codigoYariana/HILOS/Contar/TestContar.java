package HILOS.Contar;

public class TestContar {
    public static void main(String[] args) {

        Contador cont = new Contador(100);

        HiloInc a = new HiloInc("hilo a", cont);
        HiloDec b = new HiloDec("hilo b", cont);
        HiloDec c = new HiloDec("hilo c", cont);
        HiloDec d = new HiloDec("hilo d", cont);

        a.start();
        b.start();
        c.start();
        d.start();

        System.out.println("fin del main");
    }
}
