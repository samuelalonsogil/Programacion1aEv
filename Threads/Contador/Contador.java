package Threads.Contador;

public class Contador {
    private int counter = 0;

    Contador(int counter){
        this.counter = counter;
    }

    public void increment(){
        counter+=1;
    }

    public void decrement(){
        counter-=1;
    }

    public int getValor(){
        return counter;
    }

    @Override
    public String toString() {
        return "Contador{" +
                "counter=" + counter +
                '}';
    }
}
