package Threads.ProdCons;

public class Cola {
     //implementamos una cola ---> 1 entero

    private int number;
    private boolean disponible = true;


    public synchronized void put(int valor){
        number = valor;
        disponible = true;
    }

    public synchronized int get(){
        if (disponible) {
            disponible = false;
            return number;

        }else return -1;

    }

    @Override
    public String toString() {
        return "Cola{" +
                "number=" + number +
                ", disponible=" + disponible +
                '}';
    }
}
