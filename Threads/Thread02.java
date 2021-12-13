package Threads;

public class Thread02 {

    public static void main(String[] args) throws Exception {
        RunnableExample runn = new RunnableExample();
        Thread thread = new Thread();

        thread.start();
        thread.join();

        for (int i = 0; i < 3; i++){
            System.out.println(i + " :Soy el main");
            Thread.sleep( (int) (Math.random() * 1000) );
        }
    }
}

class RunnableExample implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++ ){
            System.out.println(i + " :Soy un hilo corriente");

            try{
                Thread.currentThread().sleep( (int) (Math.random() * 1000) );

            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
