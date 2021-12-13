package ProcessBuilder.Ejercicios;

import java.io.File;

public class Lanzador {


        public void lanzarSumador(Integer n1,Integer n2, String fichResultado){
            String clase="F:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejercicios\\Sumador.java";

            ProcessBuilder pb;

            try {

                /*le pasas el tipo de comando, la clase en la que quieres ejecutar y los parámetros que le vas a pasar*/
                pb = new ProcessBuilder("java", clase , n1.toString() , n2.toString() );

                /*escribe en un fichero los errores que tuvo*/
                pb.redirectError(new File("F:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejercicios\\errores.txt"));

                /*escribe en un fichero los resultados de las operaciones*/
                pb.redirectOutput(new File(fichResultado));

                pb.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args){
        Lanzador l=new Lanzador();
        l.lanzarSumador(1, 5, "F:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejercicios\\result1.txt");
        l.lanzarSumador(6,10, "F:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\Ejercicios\\result2.txt");
        System.out.println("Ok");
    }
}

