package z_Examen_trimestral.Ejercicio2A;

import javax.swing.plaf.SplitPaneUI;

public class Ascensor {

    //caracteristicas límite
    private final int MAX_PESO = 450;
    private final int MAX_PERSONAS = 6;

    //Atributos del ascensor
    private static int numeroPersonas; //contador personas
    private static float pesoAcumulado; //peso total

    public synchronized void baja_persona(int n, float peso) {
        numeroPersonas--;
        pesoAcumulado -= peso;
        System.out.println("Persona " + n + " BAJA, peso: " + pesoAcumulado + ", personas: " + numeroPersonas);
        notifyAll();
    }

    public synchronized void sube_persona(int n, float peso) {


        while ((numeroPersonas + n) >= MAX_PERSONAS || (pesoAcumulado + peso) > MAX_PESO) {
            try {
                wait();
                //System.out.println("Persona " + n + " ESPERA, peso: " + pesoAcumulado + ", personas: " + numeroPersonas);

            } catch (Exception e) {
                System.out.println("Error en wait");
            }
        }
        numeroPersonas++;
        pesoAcumulado += peso;

        System.out.println("Persona " + n + " SUBE, peso: " + pesoAcumulado + ", personas: " + numeroPersonas);
        notifyAll(); //sobra?
    }


}
