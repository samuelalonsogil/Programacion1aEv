package z_Examen_trimestral.Ejercicio2A;

import java.util.ArrayList;

public class testAscensor {
    public static void main(String[] args) {

        ArrayList<Persona> listaPersonas = new ArrayList<>();

        Ascensor ascensor = new Ascensor();

        for (int i = 0; i < 10; i++) {
            Persona persona = new Persona((float) (Math.random() * 50 + 50), ascensor, i);
            persona.start();
            listaPersonas.add(persona);
        }

        //join para todas las personas, mientras no acaben no acaba el main
        for (Persona p : listaPersonas) {
            try {
                p.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fin de la simulación");
    }
}
