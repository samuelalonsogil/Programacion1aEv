package Prodcons;

import java.util.Arrays;

public class ColaS {


    //implementamos la cola más simple de la historia--> 1 entero
    //sincronizada

    private char letra;

    private boolean disponible = false;

    public synchronized void put(int l) {
        while (disponible == true) {
            //mientras halla números =>espera
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//fin while
        disponible = true;
        notifyAll(); //avisa a todos los consumidores que pueden hacer un get
    }

    public synchronized char get() {
        while (disponible == false) {
            //mientras no halla número => consumidores espera
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//fin while
        disponible = false;
        notifyAll(); //todos los productores pueden colocar
        return letra;
    }


    @Override
    public String toString() {
        return "ColaS{" +
                "letra=" + letra +
                ", semaforo=" + disponible +
                '}';
    }
}





