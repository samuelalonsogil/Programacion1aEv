import java.util.ArrayList;

public class Simulación {
    public static void main(String[] args) throws InterruptedException {
        Hotel hotel = new Hotel();
        ArrayList<Thread> clientes = new ArrayList<Thread>();


        for (int i = 0 ; i <=30;i++){
            Persona persona = new Persona(hotel,i);
            Thread cliente = new Thread(persona);
            cliente.start();
            clientes.add(cliente);
        }

        for (Thread p : clientes){
            p.join();
        }
        System.out.println("Fin hilo 0 --- main");
    }
}
