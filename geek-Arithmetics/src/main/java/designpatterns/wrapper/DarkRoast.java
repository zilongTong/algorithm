package designpatterns.wrapper;

/**
 * @ClassName DarkRoast
 * @Author Leo
 * 具体构件类
 * @Description //TODO
 * @Date: 2019/3/1 20:59
 **/
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "深焙咖啡";
    }

    @Override
    public double cost() {
        return 1.0;
    }

}
