import java.io.*;
import java.util.ArrayList;

public class Utilities {
    //devolver un lector
    public static BufferedReader getBufferedReader(String nombreFichero) throws FileNotFoundException {
        return new BufferedReader(new FileReader(nombreFichero));
    }

    //devolver escritor
    public static PrintWriter getPrintWriter(String nombreFichero) throws IOException {
        return new PrintWriter(new FileWriter(nombreFichero));
    }

    //devuelve lineas de un fichero
    public static ArrayList<String> getLineasFichero(String nombreFichero) throws IOException {
        ArrayList<String> lineas = new ArrayList<String>();
        BufferedReader bfr = getBufferedReader(nombreFichero);

        //Leemos líneas del fichero...
        String linea = bfr.readLine();
        while (linea != null) {

        //Y las añadimos al array
            lineas.add(linea);
            linea = bfr.readLine();
        }
        //Fin del bucle que lee líneas
        return lineas;
    }

    public static long getSuma(String[] listaNombresFichero) {
        long suma = 0;
        ArrayList<String> lineas;
        String lineaCantidad;
        long cantidad;

        for (String nombreFichero: listaNombresFichero) {
            try {
                //Recuperamos todas las lineas
                lineas = getLineasFichero(nombreFichero);

                //Pero solo nos interesa la primera
                lineaCantidad = lineas.get(0);

                //Convertimos la linea a número
                cantidad = Long.parseLong(lineaCantidad);

                //Y se incrementa la suma total
                suma += cantidad;

            } catch (IOException e) {
                System.err.println("Fallo al procesar el fichero " + nombreFichero);
            }
        }
        return suma;
    }
}
