package org.tzl.static_class.demo;

import org.tzl.static_class.Something;

public class LockTest4 {

    Something x = new Something();
    Something y = new Something();
    
    // 比较x.isSyncA()与Something.cSyncA()
    private void test4(){
         // 新建t41, t41会调用 x.isSyncA()
        Thread t41 = new Thread(
            new Runnable(){
                @Override
                public void run(){
                    y.isSyncA();;
                    System.out.println("t41:isSyncA");
                }
            },"t41");
        
        // 新建t42, t42会调用Something.cSyncA()
        Thread t42 = new Thread(
            new Runnable(){
                @Override
                public void run(){
                    x.isSyncB();
                    System.out.println("t42:Something.cSyncA");
                }
            },"t42");
        
        t42.start(); // 启动t42
        t41.start(); // 启动t41
    }
    
    public static void main(String[] args){
        LockTest4 demo = new LockTest4();
        demo.test4();
    }
}