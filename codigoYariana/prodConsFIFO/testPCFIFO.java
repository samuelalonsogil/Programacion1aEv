package prodConsFIFO;

public class testPCFIFO {

    public static void main(String[] args) {

        ColaS cola = new ColaS();

        productor p = new productor(cola, 'P');
        productor p2 = new productor(cola, '2');
        consumidor c = new consumidor(cola, 'C');
        consumidor c2 = new consumidor(cola, 'C');

        p.start();
        p2.start();
        c.start();
        c2.start();

    }
}
