package lockAndThread.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Ton on 2017/6/14.
 */
public class MutliThreadDemo3 {
    public static void main(String [] args){

        MutliThread1 m1=new MutliThread1("Window 1");
        MutliThread1 m2=new MutliThread1("Window 2");
        MutliThread1 m3=new MutliThread1("Window 3");
        m1.start();
        m2.start();
        m3.start();


        MutliThread2 ml1=new MutliThread2("Window 1");
        MutliThread2 ml2=new MutliThread2("Window 2");
        MutliThread2 ml3=new MutliThread2("Window 3");
        Thread tl1=new Thread(m1);
        Thread tl2=new Thread(m2);
        Thread tl3=new Thread(m3);
        tl1.start();
        tl2.start();
        tl3.start();

        MutliThread3 m=new MutliThread3();
        Thread t1=new Thread(m,"Window 1");
        Thread t2=new Thread(m,"Window 2");
        t1.setPriority(1);//线程优先级1-10
        t1.setDaemon(true);//守护线程
        Thread t3=new Thread(m,"Window 3");
        t1.start();
        t2.start();
        t3.start();


        FutureTask<Integer>  task=new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });
        new Thread(task).start();

        CallableThread ctt = new CallableThread();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for(int i = 0;i < 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
            if(i==20)
            {
                new Thread(ft,"有返回值的线程").start();
            }
        }
        try
        {
            System.out.println("子线程的返回值："+ft.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }


    }
}

class MutliThread1 extends Thread {
    private int ticket=100;//每个线程都拥有100张票
    MutliThread1(String name){
        super(name);//调用父类带参数的构造方法
    }
    public void run(){
        while(ticket>0){
            System.out.println(ticket--+" is saled by "+Thread.currentThread().getName());
        }
    }
}

class MutliThread2 implements Runnable {
    private int ticket=100;//每个线程都拥有100张票
    private String name;
    MutliThread2(String name){
        this.name=name;
    }
    public void run(){
        while(ticket>0){
            System.out.println(ticket--+" is saled by "+name);
        }
    }
}

class MutliThread3 implements Runnable {
    private int ticket = 100;//每个线程都拥有100张票

    public void run() {
        while (ticket > 0) {
            System.out.println(ticket-- + " is saled by " + Thread.currentThread().getName());
        }
    }
}
    class CallableThread  implements Callable<Integer>{

        @Override
        public Integer call() throws Exception
        {
            int i = 0;
            for(;i<100;i++)
            {
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
            return i;
        }
}
