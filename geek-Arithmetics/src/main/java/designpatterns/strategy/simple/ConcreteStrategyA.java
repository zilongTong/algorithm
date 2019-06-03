package designpatterns.strategy.simple;

/**
 * @ClassName ConcreteStrategyA
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/1/14 10:29
 **/
public class ConcreteStrategyA implements IStrategy{
    @Override
    public void algorithmMethod() {
        System.out.println("this is ConcreteStrategyA method...");
    }
}
