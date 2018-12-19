package designpatterns.adapter.e2;

import designpatterns.adapter.e1.Adaptee;
import designpatterns.adapter.e1.Target;

/**
 *
 * @author Smile.Wu
 * @version 2015-10-16
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        super();
        this.adaptee = adaptee;
    }

    public void methodOne() {
        adaptee.methodOne();
    }

    @Override
    public void methodTwo() {
        adaptee.methodOne();
    }
}
