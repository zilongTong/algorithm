package designpatterns.wrapper;

/**
 * @ClassName HouseBlend
 * @Author Leo
 * @Description //TODO
 * 具体构件类。HouseBlend代表咖啡中的一种：混合咖啡
 * @Date: 2019/3/1 21:00
 **/
public class HouseBlend extends Beverage {


    public HouseBlend() {
        description = "混合咖啡";
    }

    @Override
    public double cost() {
        return .89;
    }

}
