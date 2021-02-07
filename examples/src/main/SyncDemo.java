package main;

class Counter{
    int count;
    public synchronized void increment(){ //the synchronized make this method workable for only a thread per time
        count++;
    }
}

public class SyncDemo {
    public static void main(String[] args) throws Exception {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++){
                    c1.increment();
                }
            }
        });



        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++){
                    c1.increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count "+c1.count);
    }
}
