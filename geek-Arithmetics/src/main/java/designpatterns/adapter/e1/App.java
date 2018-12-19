package designpatterns.adapter.e1;

/**
 *
 * @author Smile.Wu
 * @version 2015-10-16
 */
public class App {

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.methodOne();
        adapter.methodTwo();
    }
}
