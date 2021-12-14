import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sumador {

    public int lectorDepartamentos(String nombreDepartamento) throws IOException {
        int suma=0;
        int cantidadLeida = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreDepartamento));

        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            cantidadLeida = Integer.parseInt(line);
            suma+=cantidadLeida;
        }

        bufferedReader.close();
        return suma;
    }

    public static void main(String[] args) throws IOException {
        Sumador sumador = new Sumador();
        System.out.println(sumador.lectorDepartamentos(args[0]));
    }

}
