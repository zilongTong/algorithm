package lockAndThread.lock;


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {


    private static Semaphore semaphore = new Semaphore(5, true);


    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test();
                }
            }, "thread" + i).start();

        }
    }

    private static void test() {
        try {
            semaphore.acquire();
            System.out.println("允许的线程" + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
