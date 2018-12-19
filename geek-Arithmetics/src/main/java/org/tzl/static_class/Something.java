package org.tzl.static_class;

public class Something {
    /**
     * 
     *  a. x.isSyncA()与x.isSyncB()   
        b. x.isSyncA()与y.isSyncA()  
        c. x.cSyncA()与y.cSyncB()  
        d. x.isSyncA()与Something.cSyncA()  
     * 
     * 
     */
    public synchronized void isSyncA() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("========isSyncA========");
        }

    }

    public synchronized void isSyncB() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("========isSyncB========");
        }

    }

    public static synchronized void cSyncA() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("========cSyncA========");
        }

    }

    public static synchronized void cSyncB() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("========cSyncB========");
        }
    }
}