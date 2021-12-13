package Threads.ascensor;

public class Ascensor {

    private final float MAX_PESO = 450;
    private final float MAX_PERSONAS = 6;

    private static int numeroDePersonas;
    private static int pesoAcumulado;

    public synchronized void bajaPersona(int n, float peso){
        numeroDePersonas--;
        pesoAcumulado -= peso;
        System.out.println("Persona " + n + " baja, peso: " + pesoAcumulado + " personas: " + numeroDePersonas);
        notifyAll();
    }

    public synchronized void subePersona(int n, float peso){

        while( ( pesoAcumulado + peso ) > MAX_PESO || (numeroDePersonas + n) > MAX_PERSONAS ){
            try {
                wait();
                System.out.println("Persona " + n + " espera, peso: " + pesoAcumulado + " personas: " + numeroDePersonas);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        numeroDePersonas++;
        pesoAcumulado += peso;

        System.out.println("Persona " + n + " sube, peso: " + pesoAcumulado + " personas: " + numeroDePersonas);
        notifyAll();
    }
}
