package Threads.ProdCons;

public class Productor extends Thread{

    private ColaS cola;
    private int number; //valor de intercambio

    public Productor(ColaS cola, int number) {
        this.cola = cola;
        this.number = number;
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 5; i++){


            cola.put(i);

            System.out.println( i + "=> productor: " + number + ", produce: " + i );
        }
    }


}
