package Threads.carrera;

public class Atleta01 extends Thread{

    /*valores para los tiempos */
    private final int MAX= 11000;
    private final int MIN= 9000;

    /*nombre y recurso compartido*/
    private String nombre;
    private Testigo testigo;

    public Atleta01(String nombre, Testigo testigo) {
        this.nombre = nombre;
        System.out.println(nombre + " preparado para la carrera");
        this.testigo = testigo;
    }

    @Override
    public void run() {
        super.run();
        System.out.println( nombre + " esperando...");
        this.testigo.toma();

        long tiempo = System.currentTimeMillis();
        System.out.println(nombre + " empieza a correr");

        /* tiempo de carrera */

        try{
            sleep( (long) Math.floor( Math.random() * (MAX - MIN) + MAX ));
        }catch (Exception ex){
            System.out.println("Error sleep");
        }

        /*termina la carrera para este atleta*/
        System.out.println(nombre + " termina su relevo en " + (System.currentTimeMillis() - tiempo ) + "ms");
        this.testigo.deja();
    }
}
