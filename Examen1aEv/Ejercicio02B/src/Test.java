import java.util.ArrayList;

public class Test {
    public Test() {
        Deposito deposito = new Deposito();
        ArrayList<Agua> aguas = new ArrayList<>();

        for (int i = 0; i < 30 ; i++){
            Agua agua = new Agua((int) (Math.random()*1000+1000),deposito);
            agua.start();
            aguas.add(agua);
        }

        for (Agua a: aguas){
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new Test();
    }
}
