package Prodcons;

public class testPC {

    public static void main(String[] args) {

        ColaS cola = new ColaS();
        productor p = new productor(cola, 1);

        consumidor c = new consumidor(cola, 1);

        p.start();
        c.start();
    }
}
