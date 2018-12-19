package designpatterns.adapter.e1;

/**
 *
 */
public class Adapter extends Adaptee implements Target {

    /**
     * 源类没有的方法，适配器来实现
     */
    @Override
    public void methodTwo() {
        methodOne();
        System.out.println("适配器实现源类没有的方法2");
    }

}
