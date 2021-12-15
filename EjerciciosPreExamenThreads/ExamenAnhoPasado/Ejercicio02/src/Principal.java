import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        new Principal();
    }

    public Principal() {
        ArrayList<Persona> personas = new ArrayList<Persona>();
        Ascensor ascensor = new Ascensor();

        for (int i = 0; i< 10; i++){
            Persona persona = new Persona( (float) (Math.random() * 50 + 50 ), i, ascensor);
            persona.start();
            personas.add(persona);
        }


        for (Persona p : personas) {
            try {
                p.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fin de la simulación");
    }
}
