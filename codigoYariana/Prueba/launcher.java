package Prueba;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.StandardOpenOption;

public class launcher {

    private static final int splits = 6;
    private static final int n1 = 101;
    private static final int n2 = 800;

    private static File f = null;

    private void launch(Integer n1, Integer n2, String fich) {

        String clase = "Prueba\\sumador.java";
        ProcessBuilder pb;
        File dir = new File("C:\\Users\\DAM2\\Desktop\\YARI\\Programa_servicios\\src\\Prueba");

        try {
            pb = new ProcessBuilder("java",clase,
                    n1.toString(),
                    n2.toString());
            pb.directory(dir);
            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(fich));
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static FileReader fr;
    private static BufferedReader br;

    public static void main(String[] args) throws InterruptedException {

        if (splits > 1){
            split(n1, n2, splits);
        } else {
            System.out.println("La cantidad de splits tiene que ser mayor que uno");
        }

        Thread.sleep(2000);

        getResult();

    }

    private static void split(int n1, int n2, int splits) {
        //int divs = splits -1;
        int[] positions = new int[splits];

        int range = Math.round((n2-n1)/(splits));
        int aux = n1;

        for (int i = 0; i < splits; i++) {
            aux += range;
            positions[i] = aux;
        }

        launchSplitted(n1, n2, positions);
    }

    private static void launchSplitted(int n1, int n2, int[] arr) {
        launcher l = new launcher();

        int splits = arr.length;

        f = new File(("sol.txt"));
        l.launch(n1, arr[0] , "sol1-" + splits + ".txt");
        System.out.println("launching: " + n1 + ", " + arr[0]);
        for (int i = 1; i < arr.length-1; i++) {
            l.launch((arr[i-1] + 1), arr[i], "sol" + (i+1) + "-" + splits + ".txt");
            System.out.println("Launching: " + (arr[i-1] + 1) + ", " + arr[i]);
        }
        System.out.println("Launching: " + (arr[(arr.length)-2] + 1) + ", " + n2);
        l.launch((arr[(arr.length)-2] + 1), n2 , "sol" + splits + "-" + splits + ".txt");
    }

    public static void getResult() throws InterruptedException {
        long result = 0;

        for (int i = 1; i <= splits; i++) {

            result += getDatos(i);

        }

        try {
            System.out.println(result);
            f = new File("solucion.txt");
            FileWriter fw = new FileWriter(f);
            fw.write((int) result);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static long getDatos(int i) {
        long result = 0;

        try {

            f = new File("sol" + i + "-" + splits + ".txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String line = br.readLine();

            System.out.println(line);

            result += Long.parseLong(line);

            fr.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
