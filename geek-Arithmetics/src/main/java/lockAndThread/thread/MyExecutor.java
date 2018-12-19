package lockAndThread.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyExecutor extends Thread {
    private int index;

    public MyExecutor(int i) {
        this.index = i;
    }

    public void run() {
        try {
            System.out.println("[" + this.index + "] start....");
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println("[" + this.index + "] end.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
         ThreadPoolExecutor executor;
        ExecutorService service = Executors.newFixedThreadPool(4);

        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(new MyExecutor(i));

            service.execute(new Runnable() {
                public void run() {
                    // your code
                }
            });
            service.submit(new Callable() {
                public Object call() throws Exception {
                    Object o = null;
                    // your code;
                    return o;
                }
            });
        }
        System.out.println("submit finish");
        service.shutdown();
    }
}