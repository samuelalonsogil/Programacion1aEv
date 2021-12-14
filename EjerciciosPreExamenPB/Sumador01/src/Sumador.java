public class Sumador {

    public int sumar(int num01, int num02){
        int suma=0;

        for (int i = num01; i<=num02;i++) suma+=i;
        return suma;
    }

    public static void main(String[] args) {
        Sumador sumador= new Sumador();
        System.out.print("La suma total es: " + sumador.sumar(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}
