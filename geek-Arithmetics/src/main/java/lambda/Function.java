package lambda;

/**
 * Created by zilong on 2017/9/14.
 */
@FunctionalInterface
public interface Function<T,R> {
    R apply(T t);
}



