package Threads.ascensor;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        new Principal();
    }

    public Principal(){
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        Ascensor ascensor = new Ascensor();

        for (int i = 0; i < 10; i++){
            Persona persona = new Persona(( float ) (Math.random() * 50 + 50), ascensor, i);
            persona.start();
            listaPersonas.add(persona);
        }

        /*join para que todas las personas, mientras no acaben no acaba el main*/
        for (Persona p : listaPersonas){
            try {
                p.join();
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }

        System.out.println("Fin de la simulación");
    }
}
