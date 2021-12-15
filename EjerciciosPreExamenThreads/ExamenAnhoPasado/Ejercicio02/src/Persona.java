public class Persona extends Thread {
    float peso;
    int numero;
    Ascensor ascensor;

    public Persona(float peso, int numero, Ascensor ascensor) {
        this.peso = peso;
        this.numero = numero;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        super.run();
        ascensor.subePersona(numero, peso);

        try {
            Thread.sleep( (long) Math.floor(Math.random() * 500) );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ascensor.bajaPersona(numero, peso);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "peso=" + peso +
                ", numero=" + numero +
                ", ascensor=" + ascensor +
                '}';
    }
}
