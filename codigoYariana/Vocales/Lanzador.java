package Vocales;

import java.io.File;
import java.io.IOException;

public class Lanzador {

    public void launch(String c, String fich) {

        String clase = "Vocales\\ContadorVocales.java";
        ProcessBuilder pb;
        File dir = new File("C:\\Users\\DAM2\\Desktop\\YARI\\Programa_servicios\\src");

        try {
            pb = new ProcessBuilder("java", clase, c);

            pb.directory(dir);
            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(fich));
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Lanzador l = new Lanzador();

        l.launch("a", "resultA.txt");
        l.launch("e", "resultE.txt");
        l.launch("i", "resultI.txt");
        l.launch("o", "resultO.txt");
        l.launch("u", "resultU.txt");
    }

}