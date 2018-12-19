package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Method getMethod(String name, Class[] params)
 * 
 * 根据方法名和参数，返回一个具体的具有public属性的方法
 * 
 * Method[] getMethods()
 * 
 * 返回所有具有public属性的方法数组
 * 
 * Method getDeclaredMethod(String name, Class[] params)
 * 
 * 根据方法名和参数，返回一个具体的方法（不分public和非public属性）
 * 
 * Method[] getDeclaredMethods()
 * 
 * 返回该类中的所有的方法数组（不分public和非public属性）
 */
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();

        // 获取类的3中方式
        Class c = a.getClass();
        Class d = C.class;
        Class b = Class.forName("reflection.C");
        System.out.println("b:" + b.getName());
        System.out.println("d:" + d.getName());
        System.out.println("a:" + c.getName());
        // Oops! Reflection still allows us to call g():
        callHiddenMethod(a, "g");
        // And even methods that are less accessible!
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }
    /** Method getMethod(String name, Class[] params)

     根据方法名和参数，返回一个具体的具有public属性的方法

 　　　　Method[] getMethods()

     返回所有具有public属性的方法数组

 　　　　Method getDeclaredMethod(String name, Class[] params)

     根据方法名和参数，返回一个具体的方法（不分public和非public属性）

             　　　　Method[] getDeclaredMethods()

     返回该类中的所有的方法数组（不分public和非public属性）*/
    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Class c = a.getClass();
        Method g = c.getDeclaredMethod(methodName,String.class);
        g.setAccessible(true);
        g.invoke(a,"qqqqq");
        g.invoke(a,"111");
        g.invoke(a,"222");
        g.invoke(a,"33");
        g.invoke(a,"44");
    }


    /**　Field getField(String name)

    *根据变量名，返回一个具体的具有public属性的成员变量

　　　　Field[] getFields()

    返回具有public属性的成员变量的数组

　　　　Field getDeclaredField(String name)

    根据变量名，返回一个成员变量（不分public和非public属性）

            　　　　Field[] getDelcaredFields()

    返回所有成员变量组成的数组（不分public和非public属性）
     */
    static void callHiddenField(Object a, String methodName) throws Exception {
        Class c = a.getClass();
        Field[] g = c.getDeclaredFields();
        System.out.println(g[0].hashCode());
       // g.invoke(a);
    }


  /**  Constructor getConstructor(Class[] params)

    根据构造函数的参数，返回一个具体的具有public属性的构造函数

　　　　Constructor getConstructors()

    返回所有具有public属性的构造函数数组

　　　　Constructor getDeclaredConstructor(Class[] params)

    根据构造函数的参数，返回一个具体的构造函数（不分public和非public属性）

            　　　　Constructor getDeclaredConstructors()

    返回该类中所有的构造函数数组（不分public和非public属性）*/
    static void callHiddenConstructor(Object a, String methodName) throws Exception {
        Class c = a.getClass();
        Constructor[] g= c.getConstructors();
        System.out.println(g[0].hashCode());
    }

}