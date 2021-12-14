package z_Examen_trimestral.Ejercicio1A;

public class Testigo {
    private boolean testigoOcupado;

    public void toma() {
        while (testigoOcupado) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testigoOcupado = true;
            notifyAll();
        }
    }

    public void deja() {
        while (!testigoOcupado) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testigoOcupado = false;
            notifyAll();
        }
    }
}