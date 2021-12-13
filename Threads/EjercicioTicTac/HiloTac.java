package Threads.EjercicioTicTac;

public class HiloTac extends Thread{

    static final String TAC = "TAC";

    RecursoThreads linea;

    public HiloTac(RecursoThreads linea){
        this.linea = linea;
    }


    public void run(){
        System.out.println(TAC);

        do {
            synchronized (linea) {
                linea.setMostrar(TAC);
                System.out.println(linea.toString());

            try {
                //espera
                Thread.sleep((int) (Math.random() * 1500));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }while (true);
    }

}
