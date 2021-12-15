public class Dado implements Runnable {
    int valor = 0;
    Resultado resultado;


    public Dado(Resultado resultado) {
        this.resultado = resultado;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public void run() {
        valor = (int)(Math.random()*6+1);
        resultado.añadir(valor);
    }
}
