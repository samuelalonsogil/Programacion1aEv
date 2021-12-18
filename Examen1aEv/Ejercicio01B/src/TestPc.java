
public class TestPc {
    public static void main(String[] args) {
        Cola cola = new Cola();

        for (int i = 0; i<3; i++){
            Productor productor = new Productor(cola);
            productor.start();
        }

        for (int i = 0; i<3; i++){
            Consumidor consumidor = new Consumidor(cola);
            consumidor.start();
        }
    }
}
