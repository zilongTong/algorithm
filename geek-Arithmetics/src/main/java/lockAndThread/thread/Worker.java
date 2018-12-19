package lockAndThread.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * Created by Ton on 2017/5/4.
 */
public class Worker implements Runnable {

    private Work work;
    private int speed;

    public Worker(Work work,int speed){
        this.work=work;
        this.speed=speed;
    }

    public void run() {
        work.worked(speed);
    }

    class Work {

        private CyclicBarrier barrier;

        public Work(CyclicBarrier barrier) {

            this.barrier = barrier;
        }

        public void worked(int speed) {
            firstWork(speed);
            secondWork();
        }

        private void firstWork(int speed) {

            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(speed);
            } catch (Exception e) {
            }
        }
        private void secondWork() {

            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }



}