package ejer6;

import java.io.*;
import java.util.Scanner;

public class sumaParcial {

    //fichero a manipular --> nombreFichero
    //fichero de suma parcial --> nombreFichero




    public long sumaSimple(String nombreFichero, int limMax, int limMin) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
        String line;
        long total = 0;
        while ((line = br.readLine()) != null) {
            int k = Integer.parseInt(line);
            //clave del ejercicio(justo lo contrario)
            if (k < limMax || k > limMin) {
                total += k;
            }
        }
        br.close();
        return total;
    }

    public static void main(String[] args) throws IOException {
        //como recibo los argumentos

        //args 0 --> nombre FIchero contabilidad
        //args 1 --> nombre del fihcero para guardar la suma parcial


        sumaParcial sp = new sumaParcial();

        long resultado = sp.sumaSimple(args[0], 1, 2);

        System.out.println(resultado);
        System.out.flush();
    }
}
