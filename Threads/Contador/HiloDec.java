package Threads.Contador;

public class HiloDec extends Thread{
    private Contador contador;

    public HiloDec(String num, Contador contador){
        setName(num);
        this.contador = contador;
    }

    public void run(){
        for (int i = 0; i < 300; i++) {
            contador.decrement();

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " contador vale: " + contador.getValor());
        }
    }

}
