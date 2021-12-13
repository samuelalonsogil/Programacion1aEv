package Threads.parking;

import Threads.ascensor.Ascensor;
import Threads.ascensor.Persona;

import java.util.ArrayList;
import java.util.Collections;

public class Principal {

    public static void main(String[] args) {

        Parking parking = new Parking();

        System.out.println("Bienvenido al parking de Graan Via");

        ArrayList<Coche> coches = new ArrayList<>();

        for (int i =0; i<= 75 ; i++){
            Coche coche = new Coche(parking , i  );
            coche.start();
            coches.add(coche);
        }

    for (Coche c : coches){
        try {
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

        /*join aparte, para sacar info de la simulación para cada coche*/
        for (Coche c: coches ) {
            System.out.println(c.toString());
        }

        System.out.println("fin de la simulación");
        Collections.sort(coches);


    }



}
