package HILOS.Cuenta;

public class Cuenta {
    private int saldo;

    Cuenta(int s) {
        saldo = s;
    }//inicia saldo actual

    int getSaldo() {
        return saldo;
    }//devuelve el saldo

    void restar(int cantidad) { //se resta la cantidad al saldo
        saldo = saldo - cantidad;
    }

    synchronized void RetirarDinero(int cant, String nom) {
        if (getSaldo() >= cant) {
            System.out.println("SE VA A RETIRAR SALDO (ACTUAL ES: " + getSaldo() + " )");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            restar(cant);
            System.out.println(nom + " No puede retirar dinero, NO HAY SALDO " + getSaldo() + " )");
        }
    }//retirar dinero
}//cuenta
