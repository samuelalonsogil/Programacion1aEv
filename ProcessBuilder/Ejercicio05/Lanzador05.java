package ProcessBuilder.Ejercicio05;

import java.io.File;
import java.io.IOException;

public class Lanzador05 {

    /*constantes para sistematizar la tarea*/
    static final int NUM_PROCESS = 5;
    static final String PREFIX_FICHEROS= "fich";

    public static void main(String[] args) throws IOException {
        String nameFile = args[0];
        launchProgram(nameFile + ".txt");
    }


    public static void launchProgram(String nameFile) throws IOException {

        /*java a ejecutar*/
        String command = "G:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejercicio05\\CuentaVocales.java";

        /*ruta hasta los binarios*/
        File directory = new File("G:\\Clase\\ProgramacionServiciosProcesos\\src");

        /*crea el fichero de resultado parcial con el nombre pasado como parámetro*/
        File file = new File(nameFile);


        ProcessBuilder pb = new ProcessBuilder("java", command, nameFile);

        pb.directory(directory);
        pb.redirectOutput(file);

        pb.redirectError(new File("errores.txt"));
        pb.start();

    }



}
