package designpatterns.adapter.e2;

import designpatterns.adapter.e1.Adaptee;

/**
 *
 * @author Smile.Wu
 * @version 2015-10-16
 */
public class App {

    public static void main(String[] args) {
        Adapter wrapper = new Adapter(new Adaptee());
        wrapper.methodTwo();
        wrapper.methodOne();
    }
}
