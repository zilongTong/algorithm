package designpatterns.strategy.simple;

/**
 * @ClassName IStrategy
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/1/14 10:28
 **/
//策略接口
public interface IStrategy {
    //定义的抽象算法方法 来约束具体的算法实现方法
    void algorithmMethod();
}