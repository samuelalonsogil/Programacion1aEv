package Threads.SincroCuenta;

public class TestCuenta {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Cuenta c= new Cuenta(40);

        SacaPasta uno = new SacaPasta("Ana", c);
        SacaPasta dos = new SacaPasta("Juan",c);

        uno.start();
        dos.start();
    }
}
