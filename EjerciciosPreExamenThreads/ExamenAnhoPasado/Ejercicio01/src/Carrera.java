public class Carrera {

    public static void main(String[] args) {

        Atleta atleta01 = new Atleta(1);
        Atleta atleta02 = new Atleta(2);
        Atleta atleta03 = new Atleta(3);
        Atleta atleta04 = new Atleta(4);

        System.out.println("Preparados...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("YA!");

        new Thread(atleta01).start();
        new Thread(atleta02).start();
        new Thread(atleta03).start();
        new Thread(atleta04).start();
    }

    public static void terminar(int dorsal, double tiempo){
        System.out.println("Atleta " + dorsal + " tarda: " + tiempo);
    }
}
