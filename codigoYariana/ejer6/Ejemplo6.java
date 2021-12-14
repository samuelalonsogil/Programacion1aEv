package ejer6;

import Vocales.UtilidadesFicheros;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejemplo6 {

    public static String[] fichi = {"comercioResul.txt", "contabilidadResul.txt", "gerenciaResul.txt",
            "informaticaResul.txt", "rrhhResul.txt"};

    public void launch(String fich, String fichResul, int limMax, int limMin) {

        String clase = "ejer6\\sumaParcial.java";
        ProcessBuilder pb;
        File dir = new File("C:\\Users\\DAM2\\Desktop\\YARI\\Programa_servicios\\src");

        try {
            pb = new ProcessBuilder("java", clase, fich, String.valueOf(limMax), String.valueOf(limMin));

            pb.directory(dir);
            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(fichResul));
            pb.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        long suma = 0;

        Ejemplo6 ej = new Ejemplo6();
        Scanner sc = new Scanner(System.in);

        System.out.println("Límite máximo: ");
        int limMax = sc.nextInt();

        System.out.println("Límite mínimo: ");
        int limMin = sc.nextInt();

        ej.launch("..\\comercio.txt", "comercioResul.txt", limMax, limMin);
        ej.launch("..\\contabilidad.txt", "contabilidadResul.txt", limMax, limMin);
        ej.launch("..\\gerencia.txt", "gerenciaResul.txt", limMax, limMin);
        ej.launch("..\\informatica.txt", "informaticaResul.txt", limMax, limMin);
        ej.launch("..\\rrhh.txt", "rrhhResul.txt", limMax, limMin);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //proceso posterior

        suma = UtilidadesFicheros.getSuma(fichi);

        System.out.println("Resultado de suma de todos los ficheros: " + suma);

        //almacenammos el resultado total
        PrintWriter pw = null;
        try {
            pw = UtilidadesFicheros.getPrintWriter("Suma gastos totales: ");
            pw.write(Long.toString(suma));
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n FIn programa");

    }
}
