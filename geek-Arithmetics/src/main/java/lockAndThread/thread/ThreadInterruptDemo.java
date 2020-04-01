package lockAndThread.thread;


//        1、java.lang.Thread#interrupt
//
//        中断目标线程，给目标线程发一个中断信号，线程被打上中断标记。
//
//        2、java.lang.Thread#isInterrupted()
//
//        判断目标线程是否被中断，不会清除中断标记。
//
//        3、java.lang.Thread#interrupted
//
//        判断目标线程是否被中断，会清除中断标记。

//        sleep() 方法被中断后抛出异常，会清除中断标记。
//wait释放锁  sleep不释放锁

//Join()方法
//        Thread的非静态方法join()让一个线程等待另外一个线程完成才继续执行。
//        如果线程A执行体中调用B线程的join()方法，则A线程将会被阻塞，直到B线程执行完为止，A才能得以继续执行。

//       Yield()方法：线程让步  不会释放锁
//        在第一节中已经介绍了，让一个线程执行了yield()方法后，就会进入Runnable(就绪状态)，【不同于sleep()和join（）方法，因为这两个方法是使线程进入阻塞状态】。除此之外，yield()方法还与线程优先级有关，当某个线程调用yield()方法时，就会从运行状态转换到就绪状态后，CPU从就绪状态线程队列中只会选择与该线程优先级相同或者更高优先级的线程去执行。

//3. Sleep() 方法：不会释放锁
//        Sleep——让当前正在执行的线程先暂停一定的时间，并进入阻塞状态。在其睡眠的时间段内，该线程由于不是处于就绪状态，因此不会得到执行的机会。即使此时系统中没有任何其他可执行的线程，处于sleep()中的线程也不会执行。因此sleep()方法常用来暂停线程的执行。当sleep()结束后，然后转入到 Runnable(就绪状态)，这样才能够得到执行的机会。
//




public class ThreadInterruptDemo {


    /**
     * 微信公众号：Java技术栈
     */
    private static void test1() {
        Thread thread = new Thread(() -> {
            while (true) {
                Thread.yield();
            }
        });
        thread.start();
        thread.interrupt();
    }

}
