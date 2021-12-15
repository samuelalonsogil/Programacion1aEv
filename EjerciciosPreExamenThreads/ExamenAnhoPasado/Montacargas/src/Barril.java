public class Barril extends Thread{

    int numero;
    float peso;
    Montacargas montacargas;

    public Barril(int numero, float peso, Montacargas montacargas) {
        this.numero = numero;
        this.peso = peso;
        this.montacargas = montacargas;
    }

    @Override
    public void run() {
        super.run();

        montacargas.cargarBarril(numero, peso);

        try {
            Thread.sleep ( (long) Math.floor(Math.random()*500) ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        montacargas.descargarBarril(numero, peso);

    }
}
