package z_ExamenTrimestral;

import z_Examen_trimestral.Ejercicio1A.Testigo;

public class Atleta extends Thread{

    public final int MAX = 11000;
    public final int MIN = 9000;

    private String nombre;
    private Testigo testigo;

    public Atleta(String nombre, Testigo testigo) {
        this.nombre = nombre;
        this.testigo = testigo;
    }
}
