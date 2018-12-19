package org.tzl.static_class.demo2;
public class Demo2 {
    
    public static void main(String[] args){
        
        final Count count = new Count();
         // 新建t1, t1会调用“count对象”的synMethod()方法
        Thread t1 = new Thread(
            new Runnable(){
                @Override
                public void run(){
                    count.synMethod();
                }
            },"t1");
        // 新建t2, t2会调用“count对象”的nonSynMethod()方法
        Thread t2 = new Thread(
            new Runnable(){
                @Override
                public void run(){
                    count.nonSynMethod();
                }
            },"t2");
        
        t1.start(); // 启动t1
        t2.start(); // 启动t2
    }
}