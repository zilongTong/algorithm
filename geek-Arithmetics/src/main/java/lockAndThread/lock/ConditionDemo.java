package lockAndThread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class ConditionDemo {


   /** 这就是多个Condition的强大之处，假设缓存队列中已经存满，那么阻塞的肯定是写线程，
   唤醒的肯定是读线程，相反，阻塞的肯定是读线程，唤醒的肯定是写线程，
   那么假设只有一个Condition会有什么效果呢，缓存队列中已经存满，这个Lock不知道唤醒的是读线程还是写线程了，
   如果唤醒的是读线程，皆大欢喜，如果唤醒的是写线程，那么线程刚被唤醒，又被阻塞了，这时又去唤醒，
   这样就浪费了很多时间。
    */

   public static void main(String[] args) {

       final BusinessLogic business = new BusinessLogic();

       new Thread(new Runnable() {// 子线程2
           @Override
           public void run() {
               for (int j = 1; j <= 50; j++) {
                   business.sub2(j);
               }
           }
       }).start();

       new Thread(new Runnable() {// 子线程2
           @Override
           public void run() {
               for (int j = 1; j <= 50; j++) {
                   business.sub3(j);
               }
           }
       }).start();

       for (int j = 1; j <= 50; j++) {// 主线程
           business.main(j);
       }
   }

    static class BusinessLogic {
        private Lock lock = new ReentrantLock();
        private Condition condition1 = lock.newCondition();
        private Condition condition2 = lock.newCondition();
        private Condition condition3 = lock.newCondition();


        //private boolean shouldBeSub = true;
        private int shouldWhich = 1;

        public void sub2(int j) {// 同步
            lock.lock();
            try {
                while (shouldWhich!=2) {
                    try {
                        // this.wait();
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 1; i <= 10; i++) {
                    System.out.println("sub2 thread sequence of " + i
                              + ",loop of " + j);
                }
                shouldWhich = 3;
                // this.notify();
                condition3.signal();
            } finally {
                lock.unlock();
            }
        }

        public void sub3(int j) {// 同步
            lock.lock();
            try {
                while (shouldWhich!=3) {
                    try {
                        // this.wait();
                        condition3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 1; i <= 20; i++) {
                    System.out.println("sub3 thread sequence of " + i
                              + ",loop of " + j);
                }
                shouldWhich = 1;
                // this.notify();
                condition1.signal();
            } finally {
                lock.unlock();
            }
        }

        public void main(int j) {// 同步
            lock.lock();
            try {
                while (shouldWhich!=1) {
                    try {
                        // this.wait();
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 1; i <= 100; i++) {
                    System.out.println("main thread sequence of " + i
                              + ",loop of " + j);
                }

                shouldWhich = 2;
                // this.notify();
                condition2.signal();
            } finally {
                lock.unlock();
            }
        }

    }
}
