package Threads.ProdCons02;

import java.util.Random;

public class Productor extends Thread{

    //añadir en el constructor un atributo que identifique al hilo

    private ColaS cola;
    private char l;

    public Productor(ColaS cola, char l) {
        this.cola = cola;
        this.l = l;
    }

    public char generaCar() {
        char a;

        Random rnd = new Random();
        a = (char) (97 + rnd.nextInt(25));

        return a;
    }

    public void run() {

        char aux;

        for (int i = 0; i < 7; i++) {
            aux = generaCar();
            cola.put(aux);
            System.out.println(i + " => productor: " + aux);
            //System.out.println(cola.toString());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
