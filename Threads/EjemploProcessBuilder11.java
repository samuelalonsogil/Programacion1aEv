package Threads;

public class EjemploProcessBuilder11 {

    /*thread*/

    public static void main(String[] args) throws Exception {
        EjemploHilo thread = new EjemploHilo();

        /*arrancamos hilo*/
        thread.start();

        /*obligamos a que termine antes que el hilo desde el que se lanzó*/
        thread.join();

        for (int i = 0; i < 3 ; i++){
            System.out.println(i + " Main");
            Thread.sleep((int) (Math.random() * 1000));
        }
    }

}

class EjemploHilo extends Thread{
    /*va a hacer 10 veces la suspension de un thread*/
    @Override
    public void run(){
        for (int i = 0; i < 10 ; i++) System.out.println("Hilo creado por nosotros");
        try{
            sleep((int) (Math.random() * 1000));
        }catch ( InterruptedException ioe){
            ioe.printStackTrace();
        }
    }
}
