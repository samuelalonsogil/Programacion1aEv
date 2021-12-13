package ProcessBuilder.Ejemplo06;

import java.io.File;
import java.io.IOException;

public class Launcher {

    public void launch(String fileDirection, String fileName) {

        String classUsed = "G:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejemplo06\\SumaParcial.java";
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

        Launcher launcher06 = new Launcher();

        launcher06.launch("comercio.txt", "comercioResul.txt");
        launcher06.launch("contabilidad.txt", "comercioResul.txt");
        launcher06.launch("gerencia.txt", "gerenciaResul.txt");
        launcher06.launch("informatica.txt", "informaticaResul.txt");
        launcher06.launch("rrhh.txt", "rrhhResul.txt");
    }


}
