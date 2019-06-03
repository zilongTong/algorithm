package designpatterns.wrapper;

/**
 * @ClassName StarBuzzCoffee
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/3/1 21:02
 **/
public class StarBuzzCoffee {
    public static void main(String[] args){

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Milk(beverage1);
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription() + "$" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Milk(beverage2);
        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2.getDescription() + "$" + beverage2.cost());
    }
}