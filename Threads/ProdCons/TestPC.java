package Threads.ProdCons;

public class TestPC {
    public static void main(String[] args) {

        ColaS cola = new ColaS();



        Productor productor01 = new Productor(cola, 1);
        Consumidor consumidor = new Consumidor(cola, 1);


        productor01.start();
        consumidor.start();
    }
}
