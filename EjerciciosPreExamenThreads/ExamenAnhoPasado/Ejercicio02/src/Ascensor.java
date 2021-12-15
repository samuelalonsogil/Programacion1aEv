public class Ascensor {
    public final float CAPACIDAD_MAX = 6;
    public final float PESO_MAX = 450;

    private static int numeroDePersonas;
    private static int pesoAcumulado;

    public synchronized void bajaPersona(int n, float p){
        numeroDePersonas--;
        pesoAcumulado-=p;

        System.out.println("Persona " + n + " baja, peso " + pesoAcumulado + " número de personas " + numeroDePersonas);
        notifyAll();
    }


    public synchronized void subePersona(int n, double p){

        while ( (pesoAcumulado + p) > PESO_MAX || (numeroDePersonas + n) > CAPACIDAD_MAX ){

            try {
                wait();
                System.out.println("Persona " + n + " espera, peso acumulado: " + pesoAcumulado + " número de personas: " + numeroDePersonas);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            numeroDePersonas++;
            pesoAcumulado+=p;

            System.out.println("Persona " + n + " sube, peso " + pesoAcumulado + " número de personas " + numeroDePersonas);
            notifyAll();
        }
    }



}
