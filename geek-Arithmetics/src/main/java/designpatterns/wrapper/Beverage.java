package designpatterns.wrapper;

/**
 * @ClassName Beverage
 * @Author Leo
 * 抽象构件类
 * @Description //TODO
 * 比如在星巴兹咖啡馆，人们需要根据自己的爱好来订购咖啡，而具体的coffee种类假设一共用两类：
 * HouseBlend（混合咖啡）和darkRoast（深焙咖啡）。
 * 而另外客人也可根据的口味来添加一些其他的东西，例如：摩卡（mocha）、Milk（牛奶）。
 * @Date: 2019/3/1 20:57
 **/
public abstract class Beverage {

    String description = "未知的咖啡";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}