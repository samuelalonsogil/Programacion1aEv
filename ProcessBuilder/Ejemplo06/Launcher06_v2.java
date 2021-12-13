package ProcessBuilder.Ejemplo06;

import java.io.*;

public class Launcher06_v2 {

    public static String fileNames [] = {"comercio.txt", "contabilidad.txt", "gerencia.txt", "informatica.txt", "rrhh.txt"};

    public static void main(String[] args) {

        int numMax = introduceMinNum();
        int numMin= introduceMaxNum();

        Launcher06_v2 launcher06_v2 = new Launcher06_v2();
        int longArray = fileNames.length;

        for (int i = 0; i < longArray; i++){
            launcher06_v2.launch(fileNames[i], "Respuesta" + fileNames[i], numMin, numMax);
        }

        sumaTotal();

    }


    public static void sumaTotal(){
        int suma = 0;
        int longArray = fileNames.length;
        String line = "";

        for(int i=0; i < longArray; i++){
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Respuesta" + fileNames[i]));

                line = reader.readLine();

                suma+= Integer.parseInt(line);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Total:" + suma);
        }
    }



    public void launch(String fileDirection, String fileName, int num01, int num02) {

        String classUsed = "G:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejemplo06\\Sumador06_v2.java";
        ProcessBuilder pb;
        File fileDirectory = new File("G:\\Clase\\ProgramacionServiciosProcesos\\src");

        try {
            pb = new ProcessBuilder("java", classUsed, fileDirection, String.valueOf(num01), String.valueOf(num02));

            pb.directory(fileDirectory);
            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(fileName));
            pb.start();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }



    public static int introduceMaxNum(){
        int num=0;
        return num = Integer.parseInt(introduceData("Introduce el número máximo"));
    }

    public static int introduceMinNum(){
        int num = 0;
        return Integer.parseInt(introduceData("Introduce el número mínimo"));
    }


    public static String introduceData(String s){
        try{
            System.out.println(s);
            return (new BufferedReader(new InputStreamReader(System.in))).readLine();
        }catch (IOException ioe){
            System.out.println("\nError interno en sistema de entrada/salida\n");
        }
        return "";
    }

}
