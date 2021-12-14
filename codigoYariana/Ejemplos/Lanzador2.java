package Ejemplos;

public class Lanzador2 {
    public void lanzarSumador(Integer n1, Integer n2){
        String clase="nombre_paquete.Ejemplos.Sumador";
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder("java",clase,
                    n1.toString(), n2.toString());
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Lanzador2 l=new Lanzador2();
        l.lanzarSumador(1, 51);
        l.lanzarSumador(51, 100);
        System.out.println("Ok");
    }
}
