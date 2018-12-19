package org.tzl.static_class;

public class TestStaticSyn {
    public static void main(String[] args) {
      final  org.tzl.static_class.StaticClass staticClasss=new org.tzl.static_class.StaticClass();
        org.tzl.static_class.StaticClass staticClasss2=new org.tzl.static_class.StaticClass();
        new Thread(new Runnable() {
            @Override
            public void run() {
                staticClasss.setA("java");
                System.out.println(staticClasss.getA());
                System.out.println("1执行结束了");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                staticClasss.setA("javascript");
                System.out.println(staticClasss.getA());
                System.out.println("2执行结束了");
            }
        }).start();
    }
}
