package org.tzl.static_class.demo.thread2;
public class Demo1_2 {
    
    public static void main(String[] args){
        Thread t1 = new MyThread("t1");  // 新建“线程t1”
        Thread t2 = new MyThread("t2");  // 新建“线程t2”    //获取的是当前对象的锁  这是两个对象  所以可以交叉执行
        t1.start(); // 启动“线程t1”
        t2.start(); // 启动“线程t2” 
    }
}