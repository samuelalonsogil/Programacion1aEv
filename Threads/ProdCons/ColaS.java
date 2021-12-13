package Threads.ProdCons;

public class ColaS {
    //implementamos una cola ---> 1 entero

    private int number;
    private boolean disponible = true;

    //productores ponen
    public synchronized void put(int valor){
        while (disponible) {
        //mmientras halla nums espera
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        number = valor;
        disponible = true;
        notifyAll(); //avisa a todos los consumidores que pueden hacer un get
    }

    //consumidores consumen
    public synchronized int get(){
        //mmientras no halla nums espera
                //false
        while (!disponible) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //SE COLOCÓ UN VALOR
        disponible = false;
        notifyAll(); //todos los productores pueden colocar
        return number;
    }

    @Override
    public String toString() {
        return "Cola{" +
                "number=" + number +
                ", disponible=" + disponible +
                '}';
    }
}
