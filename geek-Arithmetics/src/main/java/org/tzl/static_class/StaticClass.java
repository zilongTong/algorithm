package org.tzl.static_class;

public class StaticClass {

    private static String a;

    public void setA(String a) {
        this.a = a;
    }

    public static synchronized String getA() {
        return a;
    }
}
