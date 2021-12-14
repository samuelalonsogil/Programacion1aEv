package z_Examen_trimestral.Ejercicio1A;

public class Atleta extends Thread {

    //tiempo máximo y mínimo del relevo
    private final int MAX = 11000;
    private final int MIN = 9000;

    //un nombre y un recurso compartido
    private String nombre;
    private Testigo testigo;

    //constructor para el atleta
    public Atleta(String nombre, Testigo testigo) {
        this.nombre = nombre;
        System.out.println(nombre + " preparado para la carrera");
        this.testigo = testigo;
    }


    @Override
    public synchronized void run() {
        super.run();
        System.out.println(nombre + " esperando..");
        //esperamos que notifiquen el paso de testigo
        this.testigo.toma();
        long tiempo = System.currentTimeMillis();
        System.out.println(nombre + " empieza a correr");

        //Tiempo de carrera
        try {
            sleep((long) Math.floor(Math.random() * (MAX - MIN)) + MIN);

        } catch (Exception ex) {
            System.out.println("Error sleep!!");
            //Se termina la carrerar para este atleta
            System.out.println(nombre + " termina su relevo en " + (System.currentTimeMillis() - tiempo) + "ms");
            this.testigo.deja();
        }
    }
}
