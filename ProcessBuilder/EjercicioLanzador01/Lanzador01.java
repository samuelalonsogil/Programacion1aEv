package ProcessBuilder.EjercicioLanzador01;

import ProcessBuilder.Ejercicios.Lanzador;

import java.io.File;

public class Lanzador01 {

    public void lanzarSumador(Long n1,Long n2, String fichResultado){
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

        int num=0;
        int num2=0;

        for (int i =0; i<4 ; i++){
            if (i==0) {
                num = 0;
                num2 = 25000;
            }else if(i==1){
                num=25001;
                num2=50000;
            }else if (i==2){
                num=50001;
                num2=75000;
            }else if (i==3){
                num=75001;
                num2=100000;
            }
            l.lanzarSumador(num, num2, "F:\\Clase\\ProgramacionServiciosProcesos\\src\\ProcessBuilder\\EjercicioLanzador01\\result1.txt");
        }

        System.out.println("Ok");
    }
}
