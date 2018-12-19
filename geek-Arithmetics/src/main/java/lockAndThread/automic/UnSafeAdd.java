package lockAndThread.automic;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class UnSafeAdd {
    private static int threadCount = 10;
    private static CountDownLatch countDown = new CountDownLatch(threadCount);
    private static int count = 0;
    synchronized private static void addCount(){//同步方法
        count++;
    }
    private static class Counter implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                count++;//非原子操作
                addCount();
            }
            countDown.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new Counter());
        }
        for (int i = 0; i < threadCount; i++) {
            threads[i].start();
        }
        countDown.await();
        System.out.println(count);
    }
}