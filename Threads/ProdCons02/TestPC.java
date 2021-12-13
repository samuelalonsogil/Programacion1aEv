package Threads.ProdCons02;



public class TestPC {
    public static void main(String[] args) {

        ColaS cola = new ColaS();

        Productor productor01 = new Productor(cola, 'p');
        Consumidor consumidor = new Consumidor(cola, 'c');

        Consumidor consumidor02 = new Consumidor(cola, 'c');
        Consumidor consumidor03 = new Consumidor(cola, 'c');

        Productor productor02 = new Productor(cola , '2');
        Productor productor03 = new Productor(cola , 'C');

        productor01.start();
        productor02.start();
        productor03.start();

        consumidor.start();
        consumidor02.start();
        consumidor03.start();
    }
}
