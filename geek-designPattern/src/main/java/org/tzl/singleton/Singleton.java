package org.tzl.singleton;

public class Singleton {

    private static Singleton singleton = null;

    private Singleton() {
    }

    /**
     * 常用单例模式写法:饿汉式、懒汉式、注册式、序列化。
     * <p>
     * 保证从系统启动到系统终止，全过程只会产生一个实 例。
     * 当我们在应用中遇到功能性冲突的时候，需要使用单 例模式。
     *
     * @return
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
