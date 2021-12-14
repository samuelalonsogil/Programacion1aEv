package Ejemplos;

public class Ejercicio1 {

    public void ejecutar(String ruta) {

        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(ruta);
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String ruta = "C:\\Program Files (x86)\\Adobe\\Reader 11.0\\Reader\\AcroRd32.exe";

        Ejercicio1 lanzadorProcess = new Ejercicio1();
        lanzadorProcess.ejecutar(ruta);
        System.out.println("Finalizado");
    }
}
