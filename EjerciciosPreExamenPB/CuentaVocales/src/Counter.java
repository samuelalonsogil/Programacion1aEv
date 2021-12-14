import java.io.*;

public class Counter {

    File file = new File("../Datos.txt");

                    //se le va a pasar un texto y una vocal concreta
    public int cuentaVocales(String texto, char vocal){
        char [] letras = texto.toLowerCase().toCharArray();
        int contador = 0;

        for (int i = 0; i < letras.length;i++) {
            if (letras[i] == vocal) contador++;
        }

        return contador;
    }

    public int lectorFiles(char vocal){
        int counter=0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String linea = "";

            while ((linea = bufferedReader.readLine()) != null) {
               counter = cuentaVocales(linea, vocal);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();


        System.out.println(counter.lectorFiles(args[0].charAt(0)));
    }
}
