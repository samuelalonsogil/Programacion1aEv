package Ejemplos;

public class Ejemplo12 {
    public static void main(String[] args) throws Exception {

        ThreadExample thread = new ThreadExample();

        //arrancamos el hilo
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": No");
            Thread.sleep((int) (Math.random() * 1000));
        }
    }
}

class ThreadExample extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": Si");
            try {
                sleep((int) (Math.random() * 1000));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

