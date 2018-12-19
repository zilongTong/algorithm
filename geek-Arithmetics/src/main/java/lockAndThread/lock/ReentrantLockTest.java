package lockAndThread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock ： 类ReentrantLock实现了Lock，它拥有与Sychronized相同的并发性和内存语义， 但是添加了类似锁投票、定时锁等候和可中断等候的一些特性。此外，它还提供了在与激烈争用情况下更佳的性能（
 * 说白了就是ReentrantLock和Sychronized差不多，线程间都是完全互斥的，一个时刻只能有一个线程获取到锁，执行被锁住的代码，
 * 但ReentrantLock相对于Sychronized提供了更加丰富的功能并且在线程调度上做了优化，JVM调度使用ReentrantLock的线程会更快
 */
public class ReentrantLockTest {
    // 首先要操作ReentrantLock的加锁（lock）和解锁（unlock）必须是针对同一个ReentrantLock对象，
    /**
     * 一个可重入锁成员变量
     */

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public static void main(String[] args) {
        ReentrantLockTest dalt = new ReentrantLockTest();

        dalt.testLock();

    }

    public void testLock() {

        for (int i = 0; i < 5; i++) {

            Thread thread = new Thread(new Runnable() {

                @Override

                public void run() {

                    sayHello();

                }

            }, "thread---" + i);

            thread.start();

        }

    }

    public void sayHello() {

        /**
         *
         * 当一条线程不释放锁的时候，第二个线程走到这里的时候就阻塞掉了
         *
         */

        try {

            lock.lock();

            System.out.println(Thread.currentThread().getName() + " locking ...");

             System. out .println( "Hello world!" );
            Thread.sleep(1000);

            System.out.println(Thread.currentThread().getName() + " unlocking ...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
