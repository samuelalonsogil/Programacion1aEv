package HILOS;

public class Hola extends Thread{

    private String nombre;
    private int retardo;

    public Hola(String s, int d) {
        nombre = s;
        retardo = d;
    }

    //el método run() es similar al main(), pero para
    //threads. cuando run() termina el thread muere
    public void run() {
        //retrasamos la ejecucuón el tiempo especificado, está parado
        try {
            Thread.sleep(retardo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
