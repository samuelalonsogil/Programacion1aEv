import java.io.*;

//argumentos = "s" "i" "R"
public class Launcher {

    public static final int NUM_PROCESOS = 3;
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

    public int getResultadoFicheros(String ficheroResults){
        int suma = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroResults)));
            String line = bufferedReader.readLine();
            suma+=Integer.parseInt(line);

            return suma;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return suma;
    }

    public int getTotalSuma(int numFicheros, String[] letras){
        int sumaTotal=0;
        for (int i = 0; i < numFicheros; i++){
            sumaTotal+=getResultadoFicheros(PREFIJO + letras[i] + ".txt");
        }

        return sumaTotal;
    }

    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        String[] letras = {args[0],args[1],args[2]};
        for (int i = 0; i<NUM_PROCESOS; i++){
            launcher.launch(letras[i],PREFIJO+letras[i]+".txt", "errors/error.txt");

        }

        int sumaTotal = launcher.getTotalSuma(NUM_PROCESOS,letras);
        System.out.println("Suma total: " + sumaTotal);
    }

}
