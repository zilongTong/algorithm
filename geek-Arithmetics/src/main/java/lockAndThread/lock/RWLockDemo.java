package lockAndThread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLockDemo {

    static Map<Integer, Object> cacheMap = new HashMap<>();

    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    static Lock readLock = reentrantReadWriteLock.readLock();

    static Lock writeLock = reentrantReadWriteLock.writeLock();

    static AtomicInteger i = new AtomicInteger(0);

    private static void read() {

        readLock.lock();
        cacheMap.entrySet().stream().forEach(e -> {
            System.out.println(e.getValue());
        });
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readLock.unlock();
    }


    private static void write() {
        try {
            i.incrementAndGet();
            writeLock.lockInterruptibly();
            cacheMap.put(i.get(), i.get());
            TimeUnit.SECONDS.sleep(5);
            writeLock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new Write(), "thread1");
        Thread t2 = new Thread(new Write(), "thread2");
        Thread t3 = new Thread(new Read(), "thread3");
        Thread t4 = new Thread(new Read(), "thread4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    static final class Write implements Runnable {

        @Override
        public void run() {
            write();
        }
    }

    static final class Read implements Runnable {

        @Override
        public void run() {
            read();
        }
    }

}
