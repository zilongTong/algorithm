package org.tzl.static_class.demo3;
public class Count {

    // 含有synchronized同步块的方法
    public void synMethod(){
        synchronized(this){
            try {  
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);  
                }
            } catch (InterruptedException ie) {  
            }
        }
    }
    
    // 也包含synchronized同步块的方法
    public void nonSynMethod(){
        synchronized(this){
            try {  
                 for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);  
                 }
             } catch (InterruptedException ie) {  
             }
        }
    }
}