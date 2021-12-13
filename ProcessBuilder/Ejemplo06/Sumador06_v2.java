package ProcessBuilder.Ejemplo06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sumador06_v2 {

    public long sumaSimple(String fileName, int numMin, int numMax) throws IOException {
        String line;
        long total = 0;

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        //se lee el file
        while ((line = br.readLine()) != null) {

            //se pasa el string leido a un int
            int lineToInt = Integer.parseInt(line);

            if (lineToInt > numMin && lineToInt < numMax) total += lineToInt;

            System.out.println(total);
        }
        br.close();
        return total;
    }




    public static void main(String[] args) throws IOException {
        //como recibo los argumentos

        //args--> los params que se le pasen en los launchers
        Sumador06_v2 sumador06_v2 = new Sumador06_v2();

        long resultado = sumador06_v2.sumaSimple(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));


        System.out.println(resultado);
        System.out.flush();
    }

}
