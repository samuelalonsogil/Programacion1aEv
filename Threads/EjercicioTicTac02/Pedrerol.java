package Threads.EjercicioTicTac02;

class Printer{
    void clock(int numberOfCopies, String text){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i=0; i < numberOfCopies; i++) System.out.println(text);
    }
}

class MyThread01 extends Thread{

    final Printer printer;

    public MyThread01(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        super.run();

        synchronized (printer){
            printer.clock(1, "TIC ");
        }
    }
}


class MyThread02 extends Thread{

    final Printer printer;

    public MyThread02(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        super.run();

        synchronized (printer){
            printer.clock(1, "TAC ");
        }
    }
}

public class Pedrerol {

    public static void main(String[] args) {
        System.out.println("Se abre el mercado de fichajes");

        Printer printer = new Printer();

        MyThread01 myThread01 = new MyThread01(printer);
        MyThread02 myThread02 = new MyThread02(printer);

        myThread01.start();
        myThread02.start();

        System.out.println("Se cierra el mercado de fichajes");
    }
}
