package ProcessBuilder.Ejemplo07;

import ProcessBuilder.Utilities.Utilidades;

import java.io.*;
import java.util.ArrayList;

public class Sumador07 {

    public static long sumaSimple(String fileName, String fileNamePartial) throws IOException {
        int number = 0;
        ArrayList<String> cant = Utilidades.getLineasFichero(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        for(String s : cant){
            number += Integer.parseInt(s);
        }

        System.out.println("Resultado" + number);
        File file = new File(fileNamePartial);
        PrintWriter printWritter = Utilidades.getPrintWriter(fileNamePartial);
        printWritter.write(number);

        printWritter.close();
        return number;

    }

    public static void main(String[] args) throws IOException {
        //como recibo los argumentos
        // args 0 --> los ficheros que se le pasen en los launchers

        String fileName = args[0];
        String fileNamePartial = args[1];

        long resultado =  sumaSimple( fileName, fileNamePartial );

        System.out.println("Partial: " + resultado);

    }
}
