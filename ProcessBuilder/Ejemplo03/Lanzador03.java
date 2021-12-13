package ProcessBuilder.Ejemplo03;

import java.io.*;

public class Lanzador03 {

    /*constantes para sistematizar la tarea*/
    static final int NUM_PROCESOS = 4;
    static final String PREFIJO_FICHEROS= "fich";


    public static void lanzarSumador(int n1, int n2, String fichResultados) throws IOException {

        /*java a ejecutar*/
        String comando = "F:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejemplo03\\Sumador.java";

        /*ruta hasta los binarios*/
        File directorioSumador = new File("F:\\Clase\\ProgramacionServiciosProcesos\\src");

        /*crea el fichero de resultado parcial con el nombre pasado como parámetro*/
        File fichResultado = new File(fichResultados);


        ProcessBuilder pb = new ProcessBuilder("java", comando, String.valueOf(n1), String.valueOf(n2));

        pb.directory(directorioSumador);
        pb.redirectOutput(fichResultado);

        pb.redirectError(new File("errores.txt"));
        pb.start();

    }

    public static int getResultadoFichero(String nombreFichero){

        int suma = 0;

        try {
            FileInputStream fichero = new FileInputStream(nombreFichero);
            InputStreamReader fir = new InputStreamReader(fichero);

            BufferedReader br = new BufferedReader(fir);

            /*solo lee una línea*/
            String linea=br.readLine();

            suma = Integer.valueOf(linea);

            return suma;

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir " + nombreFichero);
        } catch (IOException e) {
            System.out.println("No hay nada en " + nombreFichero);
        }
        return suma;
    }

    public static int getSumaTotal(int numFicheros){
        int sumaTotal=0;

        for (int i=1; i <= NUM_PROCESOS; i++){

            sumaTotal += getResultadoFichero(PREFIJO_FICHEROS + i);
        }
        return sumaTotal;

    }

    /*Recibe dos parámetros y hará la suma de los valores comprendidos entre ambos parametros */
    public static void main(String[] args) throws IOException, InterruptedException{

        /*atención los params de este programa están en args*/

        int n1=Integer.parseInt(args[0]); //1
        int n2=Integer.parseInt(args[1]); //100

        int salto = (n2/NUM_PROCESOS) - 1;

        for(int i = 1; i <= NUM_PROCESOS ; i++){

            System.out.println("número 1: " + n1);

            int resultadoSumaConSalto = n1 + salto;

            System.out.println("número 2: " + resultadoSumaConSalto);

            lanzarSumador(n1, n1+salto,PREFIJO_FICHEROS+ i);

            n1 = n1 + salto + 1;

            System.out.println("Suma lanzada...");
        }

        Thread.sleep(5000);

        /*resultado de leer cada fichero parcial*/
        int sumaTotal = getSumaTotal(NUM_PROCESOS);

        System.out.println("La suma total es:"+ sumaTotal);
    }
}
