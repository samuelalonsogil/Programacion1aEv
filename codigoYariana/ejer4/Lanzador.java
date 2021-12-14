package ejer4;

import java.io.*;

public class Lanzador {

    static final int NUM_PROCESADORES = 6;
    static final String PREFIJO_FICHEROS = "Resultado";

    public static void main(String[] args) throws IOException, InterruptedException {
        // Recibimos los valores por l entrada de argumentos
        int n1 = Integer.parseInt(args[0]); // Primer parametro en arguments (Run/Run Configurations)
        int n2 = Integer.parseInt(args[1]); // Segundo parametro en arguments (Run/Run Configurations)

        int parte = (n2 - n1) / NUM_PROCESADORES;
        // System.out.println(parte);

        int intermedio;
        for (int i = 1; i < NUM_PROCESADORES; i++) {
            System.out.println("SUMA " + i);
            System.out.println("n1: " + n1);
            intermedio = n1 + parte;
            System.out.println("n2: " + intermedio);
            lanzarSumador(n1, intermedio, PREFIJO_FICHEROS + String.valueOf(i) + ".txt");
            n1 = intermedio + 1;

        }

        // ultimo calculo con el resto
        System.out.println("SUMA " + NUM_PROCESADORES);
        System.out.println("n1: " + n1);
        intermedio = n2;
        System.out.println("n2: " + intermedio);
        lanzarSumador(n1, intermedio, PREFIJO_FICHEROS + String.valueOf(NUM_PROCESADORES) + ".txt");

        System.out.println("SUMA LANZADA...");

        // IMPORTANTE PARA OPERAR EL SLEEP
        Thread.sleep(5000);
        // Resultado de leer cada fichero parcial
        long sumaTotal = getSumaTotal(NUM_PROCESADORES);
        System.out.println("La suma total es:" + sumaTotal);

        //Guardar resutado en fichero
        escribirEnFichero(Long.toString(sumaTotal));
        System.out.println("Resultado guardado en \"Resultado.txt\" ");
    }

    public static void lanzarSumador(int n1, int n2, String fichResultados) throws IOException {
        // Java a ejecutar
        String comando = "ejer4\\Sumador";
        // Ruta hasta los binarios
        File directorioSumador = new File("C:\\Users\\DAM2\\Desktop\\YARI\\Programa_servicios\\src\\ejer4");
        File fichResultado = new File(fichResultados);
        File fichError = new File("errores.txt");
        ProcessBuilder pb = new ProcessBuilder("java", comando, String.valueOf(n1), String.valueOf(n2));
        pb.directory(directorioSumador);
        pb.redirectOutput(fichResultado);
        pb.redirectError(fichError);
        pb.start();
    }

    public static long getResultadoFichero(String nombreFichero) {
        long suma = 0;
        try {
            FileInputStream fichero = new FileInputStream(nombreFichero);
            InputStreamReader fir = new InputStreamReader(fichero);
            BufferedReader br = new BufferedReader(fir);
            // Solo lee una linea
            String linea = br.readLine();
            suma = Long.parseLong(linea);
            return suma;

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir " + nombreFichero);
        } catch (IOException e) {
            System.out.println("No hay nada en " + nombreFichero);
        }
        return suma;
    }

    public static long getSumaTotal(int numFicheros) {
        // ojo con los nombre de los ficheros parciales
        long sumaTotal = 0;
        for (int i = 1; i <= NUM_PROCESADORES; i++) {
            sumaTotal += getResultadoFichero(PREFIJO_FICHEROS + String.valueOf(i) + ".txt");
        }
        return sumaTotal;
    }

    public static void escribirEnFichero(String valor) throws IOException {
        FileWriter fw = new FileWriter("Resultado.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.print(valor);
        fw.close();
    }
}
