package Parking;

public class Parking {

    int plazasTotales = 40;
    int plazasOcupadas = 0;

    public synchronized void entrada(int numero) {

        while (plazasOcupadas >= plazasTotales) {

            try {
                wait();
                System.out.println("Vehículo esperando: " + numero);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Entra el coche: " + numero);
        System.out.println("");
        plazasOcupadas++;
        System.out.println("Plazas ocupadas: " + plazasOcupadas);
        notifyAll(); //podría sobrar
    }

    public synchronized void salida(int numero) {
        System.out.println("Sale el coche: " + numero);
        System.out.println("");
        plazasOcupadas--;
        System.out.println("Plazas ocupadas: " + plazasOcupadas);
        notifyAll(); //por narices para sacar del wait a los que entran

    }
}
