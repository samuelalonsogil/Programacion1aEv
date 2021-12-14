package z_Examen_trimestral.Ejercicio2A;

import javax.swing.plaf.SeparatorUI;

public class Persona extends Thread {

    private float peso;
    private Ascensor ascensor;
    private int num;

    public Persona(float peso, Ascensor ascensor,int num) {
        this.num = num;
        this.peso = peso;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        super.run();

        ascensor.sube_persona(num, peso);

        try {
            Thread.sleep((long) Math.floor(Math.random() * 500));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ascensor.baja_persona(num, peso);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "peso=" + peso +
                ", num=" + num +
                '}';
    }
}
