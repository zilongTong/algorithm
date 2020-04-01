package org.tzl.proxy.custom;


import org.tzl.proxy.jdk.XieMu;
import org.tzl.proxy.staticed.Person;

public class CustomPorxyTest {

    public static void main(String[] args) {

        try {
            Person obj = (Person)new CustomMeipo().getInstance(new XieMu());
            System.out.println(obj.getClass());
            obj.findLove();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
