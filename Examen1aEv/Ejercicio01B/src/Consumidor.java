public class Consumidor extends Thread{
    private Cola cola;

    public Consumidor(Cola cola) {
        this.cola = cola;
    }

    public void run() {
        int number = 0;
        for (int i = 0; i < 9; i++) {

            number = cola.get();
            System.out.println(i + " => consumidor: " + number);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
