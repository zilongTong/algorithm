package lambda;

/**
 * Created by zilong on 2017/9/14.
 */
public interface Predicate<T> {
    // 抽象方法
    public void sub();
    // java.lang.Object中的方法不是抽象方法
    @Override
    public boolean equals(Object var1);

    // default不是抽象方法
    public default void defaultMethod() {
        System.out.println("");
    }

    // static不是抽象方法
    public static void staticMethod() {

    }
}
