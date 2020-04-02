package org.tzl.proxy.custom;


import org.tzl.proxy.jdk.XieMu;
import org.tzl.proxy.staticed.Person;

public class CustomProxyTest {

    public static void main(String[] args) {

        try {
            Person obj = (Person) new CustomMeipo().getInstance(new XieMu());
            System.out.println(obj.getClass());
            obj.findLove();
            System.out.println(Class.forName("org.tzl.proxy.custom.$Proxy0").getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
