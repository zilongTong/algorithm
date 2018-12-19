package lockAndThread.waitNotify;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class NumberTest
{
    public static void main(String[] args)
    {
        NumberHolder numberHolder = new NumberHolder();

        Thread t1 = new IncreaseThread(numberHolder);
        Thread t2 = new DecreaseThread(numberHolder);

        t1.start();
        t2.start();
    }

}