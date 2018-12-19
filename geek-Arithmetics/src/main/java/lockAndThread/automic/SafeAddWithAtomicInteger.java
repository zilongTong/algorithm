package lockAndThread.automic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class SafeAddWithAtomicInteger {

    /**
    CAS 指的是现代 CPU 广泛支持的一种对内存中的共享数据进行操作的一种特殊指令。
    这个指令会对内存中的共享数据做原子的读写操作。
    简单介绍一下这个指令的操作过程：首先，CPU 会将内存中将要被更改的数据与期望的值做比较。
    然后，当这两个值相等时，CPU 才会将内存中的数值替换为新的值。否则便不做操作。
    最后，CPU 会将旧的数值返回。这一系列的操作是原子的。
    它们虽然看似复杂，但却是 Java 5 并发机制优于原有锁机制的根本。
    简单来说，CAS 的含义是“我认为原有的值应该是什么，如果是，则将原有的值更新为新值，否则不做修改，并告诉我原来的值是多少”。
    （这段描述引自《Java并发编程实践》）
    简单的来说，CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。
    当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则返回V。
    这是一种乐观锁的思路，它相信在它修改之前，没有其它线程去修改它；而Synchronized是一种悲观锁，
    它认为在它修改之前，一定会有其它线程去修改它，悲观锁效率很低。
    下面来看一下AtomicInteger是如何利用CAS实现原子性操作的。

     CAS的ABA问题

     volatile//不能保证操作的一致性，与java内存模型相关
    */

    private static int threadCount=10;
    private static CountDownLatch countDown=new CountDownLatch(threadCount);
    private static AtomicInteger count=new AtomicInteger(0);//原子操作类
    private static class Counter implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<1000;i++){

                count.addAndGet(1);
            }
            countDown.countDown();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads=new Thread[threadCount];
        for(int i=0;i<threadCount;i++){
            threads[i]=new Thread(new Counter());
        }
        for(int i=0;i<threadCount;i++){
            threads[i].start();
        }
        countDown.await();
        System.out.println(count.get());
    }
}
