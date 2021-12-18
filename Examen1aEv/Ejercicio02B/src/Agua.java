public class Agua extends Thread{
    int litros;
    Deposito deposito;

    public Agua(int litros, Deposito deposito) {
        this.litros = litros;
        this.deposito = deposito;
    }

    @Override
    public void run() {
        super.run();
        deposito.meteAgua(litros);

        try {
            Thread.sleep( (long) Math.floor(Math.random()*500) );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        deposito.sacaAgua(litros);
    }
}
