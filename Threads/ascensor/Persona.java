package Threads.ascensor;

public class Persona extends Thread {

    private float peso;
    private Ascensor ascensor;
    private int num;

    public Persona(float peso, Ascensor ascensor, int num) {
        this.peso = peso;
        this.ascensor = ascensor;
        this.num = num;
    }

    @Override
    public void run() {
        super.run();

        ascensor.subePersona(num, peso);
        try{
            Thread.sleep( (long)Math.floor( Math.random() * 500 ) );
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        ascensor.bajaPersona(num , peso);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "peso=" + peso +
                ", ascensor=" + ascensor +
                ", num=" + num +
                '}';
    }
}
