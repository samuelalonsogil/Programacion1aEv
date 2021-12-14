package HILOS.Contar;

public class HiloInc extends Thread {

    private Contador contador;

    public HiloInc(String n, Contador c) {
        setName(n);
        this.contador = c;
    }

    @Override
    public void run() {
        for (int j = 0; j < 300; j++){
            contador.incrementa();
            try {
                sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName()+" contador vale "+ contador.getValor());
    }
}
