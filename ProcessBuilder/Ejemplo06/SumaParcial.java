package ProcessBuilder.Ejemplo06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumaParcial {

    /*public long sumaSimple(String fileName, String fileNamePartial) throws IOException {
        int number = 0;
        ArrayList<String s> cant = UtilidadesFicheros.getLineasFichero(fileName)
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        for(String s : cant){
        number += Integer.parseInt(s);
        }

        System.out.println("Resultado" + number);
        File file = new FIle(nombreFicheroParcial);
        PrintWritter printWritter = UtilidadesFicheros.getPrintWritter(fileNamePartial);
        printWritter.writeInt(number);

        pw.close();
        return number;
    }*/




    public long sumaSimple(String fileName) throws IOException {
        String line;
        long total = 0;

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        //se lee el file
        while ((line = br.readLine()) != null) {

            //se pasa el string leido a un int
            int lineToInt = Integer.parseInt(line);
            total += lineToInt;

            System.out.println(total);
        }
        br.close();
        return total;
    }

    /*public static void main(String[] args) throws IOException {
        //como recibo los argumentos

        //args 0 --> los ficheros que se le pasen en los launchers

        String fileName = args[0];
        String fileNamePartial = args[1];

        SumaParcial sumaParcial = new SumaParcial();

        int resultado = sumaParcial.sumaSimple(fileName, fileNamePartial);

        System.out.println("Partial: " + resultado);

    }*/

    public static void main(String[] args) throws IOException {
        //como recibo los argumentos

        //args 0 --> los ficheros que se le pasen en los launchers
        SumaParcial sumaParcial = new SumaParcial();
        long resultado = sumaParcial.sumaSimple(args[0]);


        System.out.println(resultado);
        System.out.flush();
    }
}
