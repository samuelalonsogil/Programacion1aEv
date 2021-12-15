import java.util.ArrayList;

public class Prueba {
    public Prueba() {
        Montacargas montacargas = new Montacargas();
        ArrayList<Barril> barriles = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            Barril barril = new Barril(i, (float) (Math.random()*51+30),montacargas);
            barril.start();
            barriles.add(barril);
        }

        for (Barril b : barriles){
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Prueba();
    }
}
