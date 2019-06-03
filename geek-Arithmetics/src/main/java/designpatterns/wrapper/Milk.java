package designpatterns.wrapper;

/**
 * @ClassName Milk
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/3/1 21:02
 **/
public class Milk extends CondimentDecorator{

    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,牛奶";
    }

    @Override
    public double cost() {
        return beverage.cost() + .10;
    }

}
