import java.io.File;
import java.io.IOException;

public class Launcher {

    ProcessBuilder processBuilder;
    static Launcher launcher = new Launcher();

    public void launcherSumador(Integer num01,Integer num02, String ficheroResultado){
        //clase que se va a usar
        String clase = "src/Sumador.java";

        //clase y parametros necesarios que necesita la clase
        processBuilder = new ProcessBuilder("java", clase, num01.toString(), num02.toString());

        processBuilder.redirectError(new File("errors/errors.txt"));
        processBuilder.redirectOutput(new File(ficheroResultado));

        try {
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launcher.launcherSumador(3, 10, "results/resultado01.txt");
        launcher.launcherSumador(5, 12, "results/resultado02.txt");
        System.out.print("Ok");
    }
}
