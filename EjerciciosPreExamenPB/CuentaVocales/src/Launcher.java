import java.io.File;
import java.io.IOException;

public class Launcher {
    public static final int NUM_PROCESOS = 5;
    public static final String PREFIJO = "results/fichero";

    ProcessBuilder processBuilder;

    public void launch(String letra, String ficheroResultado,String ficheroErrores){
        String clase = "../src/Counter.java";

        try {
            processBuilder = new ProcessBuilder("java", clase, letra );
            processBuilder.directory(new File("results"));

            processBuilder.redirectError(new File(ficheroErrores));
            processBuilder.redirectOutput(new File(ficheroResultado));
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        String[] vocales = {"a","e","i","o","u"};
        for (int i = 0; i<NUM_PROCESOS; i++){
            launcher.launch(vocales[i],PREFIJO+vocales[i]+".txt", "errors/error.txt");

        }
    }
}
