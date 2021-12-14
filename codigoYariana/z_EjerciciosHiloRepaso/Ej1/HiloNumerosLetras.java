package z_EjerciciosHiloRepaso.Ej1;

/*1. Crea una clase llamada HiloNumerosLetras que implemente runnable y tenga de atributo un numero llamado tipo.
Si el tipo es 1, mostrara los numeros del 1 al 30
Si el tipo es 2, mostrara las letras de la ‘a’ a la ‘z’*/

public class HiloNumerosLetras implements Runnable {

    private int tipo;


    public HiloNumerosLetras(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {

        while (true) {

            switch (tipo) {
                case 1:
                    //numeros
                    for (int i = 1; i < 30; i++) {
                        System.out.println(i);
                    }
                    break;
                case 2:
                    //letras
                    for (char c = 'a'; c < 'z'; c++) {
                        System.out.println(c);
                    }
                    break;
            }
        }
    }
}
