package Parking;

import java.util.ArrayList;
import java.util.Collections;

public class testParking {

    public static void main(String[] args) {

        ArrayList<Coche> listaCoches = new ArrayList<Coche>();

        Parking parking = new Parking();

        double tiempoTotal = System.currentTimeMillis();

        for (int i = 1; i < 80; i++) {

            Coche coche = new Coche(parking, i);
            coche.start();
            listaCoches.add(coche);
        }

        for (Coche c : listaCoches) {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Collections.sort(listaCoches);

        for (Coche c : listaCoches) {
            System.out.println(c.toString());
        }
        System.out.println("Fin de la simulación");
    }
}
