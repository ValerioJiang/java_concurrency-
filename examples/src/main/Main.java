package main;

public class Main {

    public static class MyThread extends Thread{
        public void run(){
            System.out.println("My thread running");
            System.out.println("My thread finished");
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("My runnable running");
            System.out.println("My runnable finished");
        }
    }



    public static void main(String[] args) {

        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm running in the main");
                System.out.println("Finished in the main");
            }
        };*/
        /*
        Runnable runnable = () ->{
            System.out.println("Lambda running");
            System.out.println("Lambda finished");
        };
        */

        Runnable runnable = () ->{
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");
        };

        Runnable runnable2 = () ->{
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");
            try{
                Thread.sleep(2000);
                System.out.println(threadName+" finished.");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };


        Thread thread = new Thread(runnable, "The thread 1");
        thread.start();


        Thread thread2 = new Thread(runnable2, "The thread 2");
        thread2.start();


    }

}
