package Vocales;

import java.io.*;

public class ContadorVocales {

    public static final File f = new File("C:\\Users\\DAM2\\Desktop\\YARI\\Programa_servicios\\AosPinos.txt");

    public static void main(String[] args) {

        ContadorVocales c = new ContadorVocales();

        char v = args[0].charAt(0);

        int cont = c.contar(v);

        System.out.println(cont);

    }

    public static int contar(char v) {

        int contTot = 0;

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                contTot += checkString(linea, v);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contTot;
    }

    public static int checkString(String linea, char v) {
        int cont = 0;
        char arrC[] = linea.toLowerCase().toCharArray();
        int arrCL = arrC.length;

        for (int i = 0; i < arrCL; i++) {
            if (arrC[i] == v) {
                cont += 1;
            }
        }

        return cont;
    }
}


