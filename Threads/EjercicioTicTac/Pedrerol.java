package Threads.EjercicioTicTac;

public class Pedrerol {

    public static void main(String[] args) {
        /*creo un objeto de la clase a compartir por diferentes hilos*/
        RecursoThreads linea = new RecursoThreads();

        HiloTic hiloTic = new HiloTic(linea);
        HiloTac hiloTac = new HiloTac(linea);

        hiloTic.start();
        hiloTac.start();

        System.out.println("Fin main");
    }
}
