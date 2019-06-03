package designpatterns.wrapper;

/**
 * @ClassName CondimentDecorator
 * @Author Leo
 * 抽象装饰者类，所有的具体装饰者都必须继承这个类
 * @Description //TODO
 * @Date: 2019/3/1 21:01
 **/
public abstract class CondimentDecorator extends Beverage {

    public abstract String getDescription();

}
