package org.tzl.proxy.cglib;


public class CglibTest {

    public static void main(String[] args) {

        try {
            ZhangSan obj = (ZhangSan)new CglibMeipo().getInstance(ZhangSan.class);
            obj.findLove();
            System.out.println("--------------------------------");
           // System.out.println(obj.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
