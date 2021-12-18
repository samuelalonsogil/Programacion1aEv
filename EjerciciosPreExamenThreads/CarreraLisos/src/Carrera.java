import java.util.ArrayList;

public class Carrera {
    public static void main(String[] args) {
        ArrayList<Atleta> atletas = new ArrayList<>();

        for(int i = 0; i < 6;i++){
            Atleta atleta = new Atleta(i);
            atleta.start();
            atletas.add(atleta);
        }
        System.out.println("Preparados...");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("YA!!");

        for (Atleta a: atletas){
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void termina(int dorsal, double tiempo){
        System.out.println(dorsal + " tarda: " + tiempo);
    }
}
