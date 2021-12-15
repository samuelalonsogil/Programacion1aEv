public class Atleta extends Thread{
    int dorsal=0;
    double time;

    public Atleta(int dorsal) {
        this.dorsal = dorsal;
        this.time = 0;
    }

    @Override
    public void run() {
        System.out.println("Corriendo!! " + dorsal);
        int tiempo = (int)(Math.random()*2)+9;
        time = System.currentTimeMillis();

        try {
            Thread.sleep(tiempo * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        time = System.currentTimeMillis() - time;
        Carrera.termina(dorsal,time);
    }
}
