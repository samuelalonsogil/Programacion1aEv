package z_RecuPrimera;

import java.util.Random;

public class CalculadorArea implements Runnable {
    float base;
    float altura;
    float area;
    public int contador = 0;

    public CalculadorArea(float b, float a) {
        this.base = b;
        this.altura= a;
    }

    public synchronized void incrementarContador() {
        contador = contador + 1;
    }

    @Override
    public void run() {
        Random generador = new Random();
        area = base * altura / 2;
        try {
            Thread.sleep(generador.nextInt(650));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.incrementarContador();
    }
}
