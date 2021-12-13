package Threads.ProdCons;


public class Consumidor extends Thread{
    private ColaS cola;
    private int number;

    public Consumidor(ColaS cola, int number) {
        this.cola = cola;
        this.number = number;
    }

    @Override
    public void run() {
        super.run();
        int valor = 0;

        for (int i = 0; i < 5; i++){
            //pone el número

            valor = cola.get();

            System.out.println( i + "=> Consumidor: " + number + ", consume: " + valor );
        }


    }
}
