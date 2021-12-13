package Threads.parking;

public class Parking {
    int plazasTotales = 40;
    int plazasOcupadas = 0;

    public synchronized  void entrada(int numero){
        while(plazasOcupadas >= plazasTotales) {
            try{
                wait();
                System.out.println("Vehículo número: " + numero + " esperando");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Entra el coche: " + numero);
        plazasOcupadas++;
        System.out.println("Plazas ocupadas: " + plazasOcupadas);
        notifyAll(); //no tendría por qué estar
    }

    public synchronized  void salida(int numero){
        System.out.println("Sale el coche: " + numero);
        plazasOcupadas--;
        System.out.println("Plazas ocupadas: " + plazasOcupadas);
        notifyAll(); //sacar del wait a los que entran
    }
}
