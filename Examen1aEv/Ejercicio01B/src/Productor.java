import java.util.Random;

public class Productor extends Thread{
    //añadir en el constructor un atributo que identifique al hilo

    private Cola cola;

    public Productor(Cola cola) {
        this.cola = cola;
    }

    public int generaNumero() {
        int randomoNumber=0;

        randomoNumber = (int) (Math.random()*10);

        return randomoNumber;
    }

    public void run() {
        int aux;

        for (int i = 0; i < 12; i++) {
            aux = generaNumero();
            cola.put(aux);
            System.out.println(i + " => productor: " + aux);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
