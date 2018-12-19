package lockAndThread.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/18 0018.
 */
public class ArrayBlockingQueueDemo<E> {

    private static final long serialVersionUID = -817911632652898426L;

    /** The queued items */

    final Object[] items;

    /** items index for next take, poll, peek or remove */
    int takeIndex;

    /** items index for next put, offer, or add */
    int putIndex;

    /** Number of elements in the queue */
    int count;
   // transient ArrayBlockingQueue.Itrs itrs = null;
    private   ReentrantLock lock=new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    public ArrayBlockingQueueDemo(int capacity, boolean fair) {
        if (capacity <= 0)
              throw new IllegalArgumentException();
    //创建数组
        this.items = new Object[capacity];
    //创建锁和阻塞条件
    lock = new ReentrantLock(fair);
    notEmpty = lock.newCondition();
    notFull =  lock.newCondition();
}
    //添加元素的方法
    public void put(E e) throws InterruptedException {
        //checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == items.length)
                notFull.await();
            //如果队列不满就入队
            enqueue(e);
        } finally {
            lock.unlock();
        }
    }
    //入队的方法
    private void enqueue(E x) {
        final Object[] items = this.items;
        items[putIndex] = x;
        if (++putIndex == items.length)
            putIndex = 0;
        count++;
        notEmpty.signal();
    }
    //移除元素的方法
    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 0)
                notEmpty.await();
            return dequeue();
        } finally {
            lock.unlock();
        }
    }
    //出队的方法
    private E dequeue() {
        final Object[] items = this.items;
        @SuppressWarnings("unchecked")
        E x = (E) items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length)
            takeIndex = 0;
        count--;
      //  if (itrs != null)
          //  itrs.elementDequeued();
        notFull.signal();
        return x;

}

}