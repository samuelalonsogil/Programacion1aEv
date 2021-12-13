package Threads.carrera;

public class Carrera {

    public static void main(String[] args) {
        Testigo testigo = new Testigo();

        Atleta01 atleta01 = new Atleta01("Pepe" , testigo);
        Atleta01 atleta02 = new Atleta01("Bea" , testigo);
        Atleta01 atleta03 = new Atleta01("Angel" , testigo);
        Atleta01 atleta04 = new Atleta01("Isabel" , testigo);

        //tiempo acumulado total
        double tiempoTotal = System.currentTimeMillis();

        atleta01.start();
        atleta02.start();
        atleta03.start();
        atleta04.start();

        //join para que el main no acabe hasta que acaba cada atleta

        try {
            atleta01.join();
            atleta02.join();
            atleta03.join();
            atleta04.join();
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("FINAL DE CARRERA");

        System.out.println("Tiempo total de carrera : "+(System.currentTimeMillis()- tiempoTotal+" ms"));
    }


    }

