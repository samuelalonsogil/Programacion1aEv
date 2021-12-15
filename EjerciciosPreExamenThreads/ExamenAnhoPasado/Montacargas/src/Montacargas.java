public class Montacargas {
    public static final int NUM_BARRILES_MAX = 4;
    public static final float PESO_MAX = 160;

    public int numBarriles;
    public float pesoAcumulado;

    public synchronized void cargarBarril(int barril, double peso){
        while ( (numBarriles + barril) >= NUM_BARRILES_MAX || (pesoAcumulado + peso) >= PESO_MAX ){

            try {
                wait();
                System.out.println("Barril " + barril + " esperando " + " número de barriles: " + numBarriles + " peso acumulado: " + pesoAcumulado);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        numBarriles++;
        pesoAcumulado+=peso;

        System.out.println("Barril " + barril + " entra " + " número de barriles: " + numBarriles + " peso acumulado: " + pesoAcumulado);
        notifyAll();
    }

    public synchronized void descargarBarril(int barril, double peso){
        numBarriles--;
        pesoAcumulado-=peso;

        System.out.println("Barril " + barril + " descargado " + " número de barriles: " + numBarriles + " peso acumulado: " + pesoAcumulado);
        notifyAll();
    }
}
