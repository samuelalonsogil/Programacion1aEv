package ProcessBuilder.Ejercicio05Definitivo;

import java.io.File;
import java.io.IOException;

public class Launcher05 {

    public static void main(String[] args) {
        Launcher05 launcher = new Launcher05();

        launcher.launch("a", "resultA.txt");
        launcher.launch("e", "resultE.txt");
        launcher.launch("i", "resultI.txt");
        launcher.launch("o", "resultO.txt");
        launcher.launch("u", "resultU.txt");
    }

    public void launch(String c, String file){

        String classPath = "F:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejercicio05Definitivo\\VocalCounter.java";
        ProcessBuilder pb;
        File directoryFile = new File("F:\\Clase\\ProgramacionServiciosProcesos\\src");

        try{
            pb = new ProcessBuilder("java", classPath, c);

            pb.directory(directoryFile);
            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(file));
            pb.start();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
