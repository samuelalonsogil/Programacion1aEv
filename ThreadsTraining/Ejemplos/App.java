package ThreadsTraining.Ejemplos;


class MyThread extends Thread{
    @Override
    public void run() {
        super.run();

        for (int i = 0 ; i < 3; i++) System.out.println("My thread number : " + i);
    }
}

class YourThread extends Thread{
    @Override
    public void run() {
        super.run();

        for (int i = 0 ; i < 3; i++) System.out.println("Your thread number : " + i);
    }
}

class TheThread extends Thread{
    @Override
    public void run() {
        super.run();

        for (int i = 0 ; i < 3; i++) System.out.println("The thread number : " + i);
    }
}


public class App {

    //main methods represents main thread
    public static void main(String[] args) {
        MyThread myThread = new MyThread(); //worker thread
        YourThread yourThread = new YourThread();
        TheThread theThread = new TheThread();

        //this will be the first to execute bc the execution at this point is lineal
        System.out.println("Step 1: main starts");

        //run method
        myThread.start();
        yourThread.start();
        theThread.start();

        //this executes at the same time as run method paralelly
        for (int i = 0 ; i < 3; i++) System.out.println("main method thread number : " + i);

    }
}
