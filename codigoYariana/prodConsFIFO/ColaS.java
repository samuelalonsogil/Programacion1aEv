package prodConsFIFO;

import java.util.Arrays;

public class ColaS {
    //implementamos la cola más simple de la historia--> 1 entero
    //sincronizada

    final int TOTAL_POSICIONES = 5;
    private int posicionesOcupadas = 0; //juega el papel de semáforo
    private char[] cola = new char[TOTAL_POSICIONES];

    public synchronized void put(char l) {
        while (posicionesOcupadas >= TOTAL_POSICIONES) {
            //mientras halla números =>espera
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//fin while
        //se quito un valor por un consumidor
        cola[posicionesOcupadas] = l;
        posicionesOcupadas++;
        System.out.println(this.toString());
        notifyAll(); //avisa a todos los consumidores que pueden hacer un get
    }

    public synchronized char get() {
        char aux;
        while (posicionesOcupadas <= 0) {
            //mientras no halla número => consumidores espera
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//fin while
        posicionesOcupadas--;
        notifyAll(); //todos los productores pueden colocar
        aux = cola[0];
        //cola[posicionesOcupadas] = ' ';
        System.out.println(this.toString());
        return aux;
    }

    @Override
    public String toString() {
        return "ColaS{" + Arrays.toString(cola);
    }
}



