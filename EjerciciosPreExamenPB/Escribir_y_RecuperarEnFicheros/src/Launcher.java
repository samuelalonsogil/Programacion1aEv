import java.io.*;

public class Launcher {
    public static final int NUM_PROCESOS = 4;
    public static final String PREFIJO_PROCESOS = "results/fichero";

    File directorioSumador;
    File ficheroResultados;
    File ficheroErrores;
    ProcessBuilder processBuilder;

    public void launch(int num01, int num02, String ficheroResults,String ficheroErrors) throws IOException {

        //clase que le pasas
        String clase = "../src/Sumador.java";

        //directorio donde se van a generar y recuperar los archivos de texto
        directorioSumador = new File("results");

        ficheroResultados = new File(ficheroResults);
        ficheroErrores = new File(ficheroErrors);

        processBuilder = new ProcessBuilder("java", clase, String.valueOf(num01), String.valueOf(num02) );
        processBuilder.directory(directorioSumador);

        processBuilder.redirectOutput(ficheroResultados);
        processBuilder.start();

    }

    //metodo para pillar la suma de cada fichero
    public int getResultadoFicheros(String ficheroResults){
        int suma = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroResults)));
            String linea = bufferedReader.readLine();

            suma +=Integer.parseInt(linea);
            return suma;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return suma;
    }

    //pillas cada fichero y vas sumando los resultados
    public int getTotalSuma(int numFicheros){
        int sumaTotal=0;
        for (int i = 0; i < numFicheros; i++){
            sumaTotal+=getResultadoFicheros(PREFIJO_PROCESOS + i);
        }

        return sumaTotal;
    }


    public static void main(String[] args) {
        int num01 = Integer.parseInt(args[0]);
        int num02 = Integer.parseInt(args[1]);

        int salto = (num02 / NUM_PROCESOS) - 1;
        Launcher launcher = new Launcher();

        for (int i= 0; i < NUM_PROCESOS; i++) {
            System.out.print("Numero 01: " + num01);
            int resultadoSumaConSalto = num01 + salto;
            System.out.println(" Numero 02: " + resultadoSumaConSalto);

            try {
                launcher.launch(num01, num01+salto,PREFIJO_PROCESOS+ i, "errors/errors.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

            num01+=salto+1;
            System.out.println("Suma lanzada");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sumaTotal = launcher.getTotalSuma(NUM_PROCESOS);
        System.out.println("Suma total: " + sumaTotal);
    }
}
