/*Ejercicio 1B Siguiendo el modelo productor consumidor implementa una
cola SINCRONIZADA de tres posiciones para intercambiar valores
enteros aleatorios entre 0 y 9.
Emplearemos tres hilos productores para generar hasta 12 dígitos que
serán más lentos que cuatro hilos consumidores de hasta 9 dígitos.
Visualice apropiadamente mediante mensajes todoo el proceso.*/

import java.util.Arrays;

public class Cola {
    private int posicionesOcupadas = 0;
    private final int[] cola = new int[3];

    public synchronized void put(int num) {
        while (posicionesOcupadas >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cola[posicionesOcupadas] = num;
        posicionesOcupadas++;

        System.out.println(this);
        notifyAll();
    }

    public synchronized int get() {
        int aux;
        while (posicionesOcupadas <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        posicionesOcupadas--;
        notifyAll();
        aux = cola[posicionesOcupadas];
        cola[posicionesOcupadas] = ' ';
        System.out.println(this);
        return aux;
    }

    @Override
    public String toString() {
        return "ColaS{" +
                "posicionesOcupadas=" + posicionesOcupadas +
                ",\n cola=" + Arrays.toString(cola) +
                '}';
    }
}
