public class Persona implements Runnable{
    public Hotel hotel;
    public int numero;

    public Persona(Hotel hotel, int numero) {
        this.hotel = hotel;
        this.numero = numero;
    }

    public Hotel getHotel() {
        return hotel;
    }

    @Override
    public void run() {
        hotel.entrada(numero);
        int tiempo = (int) (Math.random()*2) + 4;
        try {
            Thread.sleep(tiempo * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hotel.salida(numero);
    }
}
