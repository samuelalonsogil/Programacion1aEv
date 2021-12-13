package Threads.Contador;

public class HiloInc extends Thread{
    private Contador contador;

    public HiloInc(String num, Contador contador){
        setName(num);
        this.contador = contador;
    }

    public void run(){
        for (int i = 0; i < 300; i++) {
            contador.increment();

            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " contador vale: " + contador.getValor());
        }
    }

}
