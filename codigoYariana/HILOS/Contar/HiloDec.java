package HILOS.Contar;

public class HiloDec extends Thread{

    private Contador contador;

    public HiloDec(String n, Contador c) {
        setName(n);
        this.contador = c;
    }

    @Override
    public void run() {
        for (int j = 0; j < 300; j++){
            contador.decrementa();
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName()+" contador vale "+ contador.getValor());
    }
}
