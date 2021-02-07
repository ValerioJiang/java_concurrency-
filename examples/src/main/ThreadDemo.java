package main;

class hi extends Thread {

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}


class hello extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 5; i++){
            System.out.println("Hello");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }
}


public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new hi());
        Thread thread2 = new Thread(new hello());

        thread1.start();
        thread2.start();

    }
}
