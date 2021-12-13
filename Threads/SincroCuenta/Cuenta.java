package Threads.SincroCuenta;

public class Cuenta {

    //atributo que necesita integridad referencial
    private int saldo;

    public Cuenta(int n) {
        // TODO Auto-generated constructor stub
        saldo=n;
    }

    int getSaldo() {
        return saldo;
    }

    void restar(int cant) {
        saldo -= cant;
    }

    //METODO SINCRONIZADO EN EL OBJETO que se comparte
    synchronized void retirarDinero(int cant, String nom) {

        if (getSaldo() >= cant) {
            System.out.println(nom+" VA A RETIRAR: " + cant + " (SALDO: " + getSaldo() + ")");

            try {//simular la espera de dos segundos hasta el siguiente hilo
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            restar(cant);
            System.out.println(nom+" HA RETIRADO: " + cant + " (SALDO: " + getSaldo() + ")");
        } else {
            System.out.println(nom+" NO PUEDE RETIRAR: (SALDO: " + getSaldo() + ")");
        }

        if (getSaldo() < 0) {
            System.out.println(nom+" SALDO NEGATIVO: " + getSaldo());
        }
    }

}
