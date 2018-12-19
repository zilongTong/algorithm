package lockAndThread.lock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 *ReentrantReadWriteLock： 类ReentrantReadWriteLock实现了ReadWirteLock接口。
 * 它和ReentrantLock是不同的两套实现，在类继承结构上并无关联。和ReentrantLock定义的互斥锁不同的是
 * ，ReentrantReadWriteLock定义了两把锁即读锁和写锁。读锁可以共享，即同一个资源可以让多个线程获取读锁。
 * 这个和ReentrantLock（或者sychronized）
 * 相比大大提高了读的性能。在需要对资源进行写入的时候在会加写锁达到互斥的目的。
 */
public class ReadWriteLockTest {

    /**

     * 一个可重入读写锁

     */

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**

     * 读锁

     */

    private ReadLock readLock = readWriteLock .readLock();

    /**

     * 写锁

     */

    private WriteLock writeLock = readWriteLock .writeLock();

    /**

     * 共享资源

     */

    private String shareData = " 寂寞等待中..." ;

    public void write(String str) throws InterruptedException {

        writeLock .lock();

        System. err .println( "ThreadName:" +Thread. currentThread ().getName()+ "locking..." );

        try {

            shareData = str;

            System. err .println( "ThreadName:" + Thread. currentThread ().getName()+ " 修改为" +str);

            Thread. sleep (1000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        } finally {

            System. err .println( "ThreadName:" + Thread. currentThread ().getName()+ "  unlock..." );

            writeLock .unlock();

        }

    }

    public String read() {

        readLock .lock();

        System. out .println( "ThreadName:" + Thread. currentThread ().getName()+ "lock..." );

        try {

            System. out .println( "ThreadName:" +Thread. currentThread ().getName()+ " 获取为：" + shareData );

            Thread. sleep (1000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        } finally {

            System. out .println( "ThreadName:" + Thread. currentThread ().getName()+ "unlock..." );

            readLock .unlock();

        }

        return shareData ;

    }

    public static void main(String[] args) {

        final ReadWriteLockTest shareData = new ReadWriteLockTest();

        /**

         * 起10 条读线程

         */

        for ( int i = 0; i < 10; i++) {

            new Thread( new Runnable() {

                public void run() {

                    try {

                        Thread. sleep (1);

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                    shareData.read();

                }

            }, "get Thread-read------" +i+">>>>").start();

        }

        for ( int i = 0; i < 5; i++) {

            new Thread( new Runnable() {

                public void run() {

                    try {

                        Thread. sleep (1);

                    } catch (InterruptedException e1) {

                        e1.printStackTrace();

                    }

                    try {

                        shareData.write( new Random().nextLong()+ "" );

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                }

            }, "wirte Thread-write-----" +i+">>>>").start();

        }

    }
}
