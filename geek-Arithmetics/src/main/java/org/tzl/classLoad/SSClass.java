package org.tzl.classLoad;

/**
 * Created by Ton on 2017/6/9.
 */
public class SSClass {
    static {
        System.out.println("SSClass");
    }
}

class SuperClass extends SSClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

    public SuperClass() {
        System.out.println("init SuperClass");
    }
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }

    static int a;

    public SubClass() {
        System.out.println("init SubClass");
    }
}
//对象的初始化顺序:首先执行父类静态的内容，父类静态的内容执行完毕后，接着去执行子类的静态的内容，
// 当子类的静态内容执行完毕之后，再去看父类有没有非静态代码块，如果有就执行父类的非静态代码块，
// 父类的非静态代码块执行完毕，接着执行父类的构造方法；父类的构造方法执行完毕之后，它接着去看子类有没有非静态代码块，
// 如果有就执行子类的非静态代码块。子类的非静态代码块执行完毕再去执行子类的构造方法。
// 总之一句话，静态代码块内容先执行，接着执行父类非静态代码块和构造方法，然后执行子类非静态代码块和构造方法。
class NotInitialization {
    public static void main(String[] args) {
new SubClass();
        System.out.println(SubClass.value);
    }
}