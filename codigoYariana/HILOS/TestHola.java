package HILOS;

public class TestHola {
    public static void main(String[] args) {
        Hola t1, t2, t3;

        //OBJETO COMPARTIDO POR
        //creamos threads
        t1 = new Hola("Thread 1", (int) (Math.random() * 2000));
        t2 = new Hola("Thread 2", (int) (Math.random() * 2000));
        t3 = new Hola("Thread 3", (int) (Math.random() * 2000));

        System.out.println("Arrancamos los hilos");

        //Arrancamos los threads
        t1.start();
        t2.start();
        t3.start();


        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fin de ejecucuíon de main");
    }
}
