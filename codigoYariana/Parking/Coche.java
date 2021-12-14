package Parking;

public class Coche extends Thread implements Comparable<Coche> {

    public Parking parking;
    public int numero;
    public long tiempo;

    public Coche(Parking park, int numero) {
        super();
        this.parking = park;
        this.numero = numero;
    }

    @Override
    public void run() {
        parking.entrada(numero);

        //simula la estancia
        this.tiempo = (int) (Math.random() * 2) + 2;
        try {
            Thread.sleep((long) tiempo * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("El coche " + numero + " ha estado: " + tiempo);
        parking.salida(numero);
    }

    @Override
    public int compareTo(Coche o) {
        if (this.tiempo > o.tiempo) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Coche{" +
                "numero=" + numero +
                ", tiempo=" + tiempo +
                '}';
    }
}
