package Threads.SincroCuenta;

public class SacaPasta extends Thread {

    //objeto compartido por todos los hilos
    private Cuenta c;

    //nombre del hilo para id
    String nom;

    public SacaPasta(String n,Cuenta c) {
        this.c=c;
        this.nom=n;
    }

    public void run() {
        for(int i=0;i<4;i++) {
            c.retirarDinero(10, nom);
        }
    }
}
