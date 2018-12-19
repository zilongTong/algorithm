package org.tzl.static_class.demo;
public class MyRunable implements Runnable{
    
    @Override
    public void run(){
        
        synchronized(this){
            try{
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " loop " + i);  
                }
            }catch(InterruptedException e){
                
            }
        }
    }
}