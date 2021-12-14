package Prodcons;

public class cola {

    //implementamos la cola más simple de la historia--> 1 entero

    private int numero;
    private boolean disponible = false;

    public synchronized void put(int valor) {
        numero = valor;
        disponible = true;
    }

    public synchronized int get() {
        if (disponible) {
            disponible = false;
            return numero;
        }

        return -1; //es indicativo de ausencia de dato en la cola
    }

    @Override
    public String toString() {
        return "cola{" +
                "numero=" + numero +
                ", disponible=" + disponible +
                '}';
    }
}
