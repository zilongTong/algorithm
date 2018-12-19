package org.tzl.effectiveJava;

/**
 * Created by Ton on 2017/6/12.
 */
public class hashCodeEquals {

    private String s;

    public static void main(String[] args) {
        int i = 0;
        i++;
        int j = 0;
        ++j;
        int a = j++;
        int b = ++i;
        String aa="111";
        String bb=new String (aa);
        System.out.println(bb.equals(aa));
        System.out.println(bb==aa);
        System.out.println((short)10/10.2*2);
        System.out.println(Math.random());
    }
}
