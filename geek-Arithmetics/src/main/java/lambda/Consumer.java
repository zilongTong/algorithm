package lambda;

/**
 * Created by zilong on 2017/9/14.
 */
@FunctionalInterface
public  interface  Consumer<T>{
    void accept(T t);
}