package ejer3;

public class Sumador {

    //método para resolver el problema
    public long sumar(long n1, long n2) {

        long resultado = 0;

        for (long i = n1; i <= n2; i++) {
            resultado = resultado + i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        Sumador s = new Sumador();

        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);

        long resultado = s.sumar(n1, n2);
        System.out.println(resultado);
    }
}
