package HILOS.Contar;

public class Contador {

    private int c = 0;//atributo del contador

    public Contador(int c) {
        this.c = c;
    }

    public void incrementa() {
        c += 1;
    }

    public void decrementa() {
        c -= 1;
    }

    public int getValor() {
        return c;
    }

    @Override
    public String toString() {
        return "Contador{" +
                "c=" + c +
                '}';
    }
}
