package ProcessBuilder.Ejercicios;

import java.io.File;

public class Lanzador02 {
    public void lanzarSumador(Integer n1,Integer n2, String fichResultado){
        ProcessBuilder pb;

        String clase ="Ejercicios\\Sumador.java";

        /*enrutamos el directorio activo*/
        File directory = new File("F:\\Clase\\ProgramacionServiciosProcesos\\src");

        try {

            /*le pasas el tipo de comando, la clase en la que quieres ejecutar y los parámetros que le vas a pasar*/
            pb = new ProcessBuilder("java", clase , n1.toString() , n2.toString() );

            pb.directory(directory);
            pb.redirectError(new File("errores02.txt"));
            pb.redirectOutput(new File(fichResultado));
            pb.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Lanzador l=new Lanzador();
        l.lanzarSumador(1, 5, "F:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejercicios\\ArchivosDeTexto\\result1.txt");
        l.lanzarSumador(6,10, "F:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejercicios\\ArchivosDeTexto\\result2.txt");
        System.out.println("Ok");
    }
}
