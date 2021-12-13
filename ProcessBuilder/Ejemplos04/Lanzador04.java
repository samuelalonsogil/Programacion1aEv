package ProcessBuilder.Ejemplos04;

import java.io.*;

public class Lanzador04 {

    /*constantes para sistematizar la tarea*/
    static final int NUM_PROCESOS = 6;
    static final String PREFIJO_FICHEROS= "fich";


    public static void lanzarSumador(int n1, int n2, String fichResultados) throws IOException {

        /*java a ejecutar*/
        String comando = "F:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejemplos04\\Sumador04.java";

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

            sumaTotal += getResultadoFichero(PREFIJO_FICHEROS + i + "txt");
        }
        return sumaTotal;

    }


    public static void escribirEnFichero(int valor) throws IOException {
        FileWriter fw = new FileWriter("Resultdo.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.print(valor);
        fw.close();

    }

    /*Recibe dos parámetros y hará la suma de los valores comprendidos entre ambos parametros */
    public static void main(String[] args) throws IOException, InterruptedException{

        /*atención los params de este programa están en args*/

        int n1=Integer.parseInt(args[0]); //primer param en args
        int n2=Integer.parseInt(args[1]); //segundo param en args

        int salto = (n2 - n1) / NUM_PROCESOS;

        System.out.println("Salto: " + salto);

        int resultadoSumaConSalto;
        for(int i = 1; i <= NUM_PROCESOS ; i++){

            System.out.println("Suma: " + i);

            System.out.println("número 1: " + n1);

            resultadoSumaConSalto = n1 + salto;

            System.out.println("número 2: " + resultadoSumaConSalto);

            lanzarSumador(n1, resultadoSumaConSalto,PREFIJO_FICHEROS+ i + "txt");

            n1 = resultadoSumaConSalto + 1;


        }

        System.out.println("Suma " + NUM_PROCESOS);

        System.out.println("número 1: " + n1);
        resultadoSumaConSalto = n2;
        System.out.println("número 2: " + resultadoSumaConSalto);

        lanzarSumador(n1,resultadoSumaConSalto, PREFIJO_FICHEROS + NUM_PROCESOS + "txt");

        System.out.println("Suma lanzada...");

        Thread.sleep(5000);


        /*resultado de leer cada fichero parcial*/
        int sumaTotal = getSumaTotal(NUM_PROCESOS);

        System.out.println("La suma total es:"+ sumaTotal);

        /*guardar resultado en el fichero*/
        escribirEnFichero(sumaTotal);
        System.out.println("Resultado guardado en \"Resultado.txt\" ");

    }
}

