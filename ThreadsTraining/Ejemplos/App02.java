package ThreadsTraining.Ejemplos;
//different way

class CA {}

class MyThread01 extends CA implements Runnable{
    @Override
    public void run() {

        for (int i = 0 ; i < 3; i++) System.out.println("My thread 01 number : " + i);
    }
}

class MyThread02 extends CA implements Runnable{
    @Override
    public void run() {

        for (int i = 0 ; i < 3; i++) System.out.println("My thread 02 thread number : " + i);
    }
}

class MyThread03 extends CA implements Runnable{
    @Override
    public void run() {

        for (int i = 0 ; i < 3; i++) System.out.println("My thread 03 thread number : " + i);
    }
}

public class App02 {

    //main methods represents main thread
    public static void main(String[] args) {
        
        //this will be the first to execute bc the execution at this point is lineal
        System.out.println("Step 1: main starts");

        for(int i= 0; i < 3; i++) System.out.println("Main thread number: " + i);

        Runnable runnable = new MyThread01();
        Thread task01 = new Thread(runnable);

        Runnable runnable02 = new MyThread02();
        Thread task02 = new Thread(runnable02);

        Runnable runnable03 = new MyThread03();
        Thread task03 = new Thread(runnable03);

        task01.start();
        task02.start();
        task03.start();

    }

}
