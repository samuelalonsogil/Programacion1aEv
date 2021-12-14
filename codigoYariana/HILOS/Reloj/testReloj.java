package HILOS.Reloj;


public class testReloj {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //creo un objeto de la clase a compartir
        //por diferentes hilos
        Recurso linea = new Recurso();
        HiloTIC uno = new HiloTIC(linea);
        HiloTAC dos = new HiloTAC(linea);

        //como implemento una sincronizacion entre hilos???
        uno.start();
        try {
            uno.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dos.start();

        try {
            dos.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Las dos han terminado");
    }
}
