package ThreadsTraining.MultiThreading;

class Printer{
    //synchronized void printDocuments(int numberOfCopies, String docName)
     void printDocuments(int numberOfCopies, String docName){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i=0; i < numberOfCopies; i++) System.out.println(">>Printing : " + docName + i);
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
            printer.printDocuments(2, "Otra cosa: ");
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
            printer.printDocuments(2, "Una cosa: ");
        }
    }
}

public class SyncApp {

    public static void main(String[] args) {
        System.out.println("Application started");

        Printer printer = new Printer();
        //printer.printDocuments(2, "Cualquier cosa ");


        //multiple threads working on the same Printer Object we must synchronize them
        MyThread01 myThread01 = new MyThread01(printer);
        myThread01.start();


        /*try {
            myThread01.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        MyThread02 myThread02 = new MyThread02(printer);
        myThread02.start();

        System.out.println("Application stopped");
    }
}
