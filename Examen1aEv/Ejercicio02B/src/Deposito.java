public class Deposito {

    public static final int CAPACIDAD_MAX = 10000;
    int capacidad;

    public synchronized void meteAgua(int agua){
        while ( (agua + capacidad) >= CAPACIDAD_MAX ){

            try {
                wait();
                System.out.println("Demasiada agua : " + capacidad + "litros actualmente" + " recarga de agua esperando: " + agua);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        capacidad+=agua;

        System.out.println("Litros: " + agua + " entra " + " capacidad llena: " + capacidad);
        notifyAll();
    }

    public synchronized void sacaAgua(int agua){
        capacidad=-agua;
        if (capacidad<0) capacidad=0;
        System.out.println("Litros: " + agua + " salen" + " capacidad llena:" + capacidad);
        notifyAll();
    }
}
