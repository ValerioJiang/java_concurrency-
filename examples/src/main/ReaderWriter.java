package main;

class SharedResource{
    int count;

    public synchronized void increment(){
        count++;
    }

    public synchronized void decrease(){
        count--;
    }

    public synchronized int read(){
        return count;
    }
}

public class ReaderWriter {

    public static void main(String[] args) throws Exception {
        SharedResource sh1 = new SharedResource();

        Runnable writer_increment = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 4000; i++) {
                    sh1.increment();
                    System.out.println("Shared resource incremented by 1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };



        Runnable reader = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 4000; i++) {
                    System.out.println("The current value of the shared resource is " + sh1.read());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread reader_thread = new Thread(reader,"The thread read");
        Thread writer_increment_thread = new Thread(writer_increment,"The thread write increment");

        reader_thread.start();
        writer_increment_thread.start();

        reader_thread.join();
        writer_increment_thread.join();


    }

}
