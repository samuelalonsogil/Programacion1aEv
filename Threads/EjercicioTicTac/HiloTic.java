package Threads.EjercicioTicTac;

public class HiloTic extends Thread{
    static final String TIC = "TIC";
    RecursoThreads linea;

    public HiloTic(RecursoThreads linea){
        this.linea = linea;
    }

    public void run(){

        do{
            synchronized (linea){
                linea.setMostrar(TIC);
                System.out.println(linea.toString());

            try {
                //espera
                Thread.sleep( (int)(Math.random() * 1000) );

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }while (true);
    }



}
