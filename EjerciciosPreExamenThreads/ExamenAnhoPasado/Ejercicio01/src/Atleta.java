public class Atleta extends Thread{
    int dorsal = 0;
    double tiempo = 0;

    public Atleta(int dorsal) {
        this.dorsal = dorsal;
        this.tiempo = 0;
    }

    @Override
    public void run() {
        System.out.println("Corriendo: " + dorsal);
        int tiempoCarrera = (int) (Math.random()*2)+9;
        tiempo = System.currentTimeMillis();

        try {
            Thread.sleep( (tiempoCarrera * 1000L) );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tiempo = ( System.currentTimeMillis() - tiempo );
        Carrera.terminar(dorsal, tiempo);

    }
}
