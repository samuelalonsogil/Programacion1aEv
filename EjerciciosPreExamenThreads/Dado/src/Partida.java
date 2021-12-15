import javax.xml.transform.Result;
import java.util.ArrayList;

public class Partida {
    public static void main(String[] args) {
        int maxResultado = 0;
        String ganador = "";

        Resultado mar1 = new Resultado("David");
        Resultado mar2 = new Resultado("Jose");
        Resultado mar3 = new Resultado("Roberto");

        ArrayList<Tirada> jugadores = new ArrayList<>();

        Tirada jug1 = new Tirada(mar1);
        Tirada jug2 = new Tirada(mar2);
        Tirada jug3 = new Tirada(mar3);


        jugadores.add(jug1);
        jugadores.add(jug2);
        jugadores.add(jug3);

        System.out.println("---> Los jugadores tiran los dados");
        for(Tirada jugador:jugadores){
            jugador.tirarDados();
        }
    }


}
