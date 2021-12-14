import java.io.File;
import java.io.IOException;

public class Launcher {

    ProcessBuilder processBuilder;

    public void launch(String departamento, String ficheroResultado, String ficheroErrores){
        String clase = "../src/Sumador.java";

        processBuilder = new ProcessBuilder("java", clase, departamento);
        processBuilder.directory(new File("departamentos"));
        processBuilder.redirectError(new File(ficheroErrores));
        processBuilder.redirectOutput(new File(ficheroResultado));

        try {
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        String[] departamentos = {"informatica.txt", "gerencia.txt", "contabilidad.txt", "comercio.txt", "rrhh.txt"};

        for (int i = 0; i< departamentos.length; i++){
            launcher.launch(departamentos[i], "resultados/resultado" +departamentos[i]+".res","errors/error.txt");
        }
    }
}
