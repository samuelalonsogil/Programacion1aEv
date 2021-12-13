package ProcessBuilder.Ejemplo07;

import ProcessBuilder.Ejemplo06.Launcher;

import java.io.File;
import java.io.IOException;

public class Launcher07 {
    public void launch(String fileDirection, String fileName) {

        String classUsed = "G:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejemplo07\\Sumador07.java";
        ProcessBuilder pb;
        File fileDirectory = new File("G:\\Clase\\ProgramacionServiciosProcesos\\src");

        try {
            pb = new ProcessBuilder("java", classUsed, fileDirection);

            pb.directory(fileDirectory);
            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(fileName));
            pb.start();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Launcher07 launcher07 = new Launcher07();

        launcher07.launch("comercio.txt", "comercioResul.txt");
        launcher07.launch("contabilidad.txt", "contabilidadResul.txt");
        launcher07.launch("gerencia.txt", "gerenciaResul.txt");
        launcher07.launch("informatica.txt", "informaticaResul.txt");
        launcher07.launch("rrhh.txt", "rrhhResul.txt");
    }

}
