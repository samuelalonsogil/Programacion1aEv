package ejer3;

import java.io.File;

public class Lanzador1 {


    public void lanzarSumador(Long n1, Long n2, String fichResultado) {

        String clase = "ejer3\\Sumador.java";
        ProcessBuilder pb;

        //ENRUTAMOS EL DIRECTORIO ACTIVO
        File directorio;
        directorio = new File("C:\\Users\\DAM2\\Desktop\\YARI\\Programa_servicios\\src");
        try {
            pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());

            //hemos fijado el directorio activo para el pb
            pb.directory(directorio);
            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(fichResultado));
            pb.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            /*se pretende repartir la suma de los 100000 primeros
    numeros enteros repartiendo en cuatro subtareas.
    la primera desde 1 a 250000
    la segunda desde 250001 a 500000
    la tercera desde 500001 a 750000
    la cuarta desde 750001 a 100000
    guardamos en tarea1.txt,...., .... tarea4.txt */
        Lanzador1 l = new Lanzador1();

        long alto = 100000;

        for (int i = 0; i < 4; i++) {
            l.lanzarSumador((i * alto / 4) + 1, (i + 1) * alto / 4, "tar" + (i + 1) + ".txt");
        }
        System.out.println("Ok Tarea completada");
    }
}

