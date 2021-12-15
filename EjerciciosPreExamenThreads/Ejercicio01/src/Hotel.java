public class Hotel {
    int camasTotales = 10;
    int camasOcupadas = 0;

    public synchronized void entrada(int numero){
        while(camasOcupadas >= camasTotales){
            try {
                wait();
                System.out.print("la persona " + numero + "esperando");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("++Entra el cliente: " + numero);
        camasOcupadas++;
        System.out.println("Camas ocupadas: " + camasOcupadas);

        //no haría falta porque para salir nadie está a la espera
        notifyAll();
    }

    public synchronized void salida(int numero){
        System.out.println("--Sale el cliente: " + numero);
        camasOcupadas--;
        System.out.println("Camas ocupadas: " + camasOcupadas);
        notifyAll();
    }
}
