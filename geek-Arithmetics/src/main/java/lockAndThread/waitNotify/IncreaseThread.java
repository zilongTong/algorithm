package lockAndThread.waitNotify;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class IncreaseThread extends Thread
{
    private NumberHolder numberHolder;

    public IncreaseThread(NumberHolder numberHolder)
    {
        this.numberHolder = numberHolder;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 20; ++i)
        {
            // 进行一定的延时
            try
            {
                Thread.sleep( 1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            // 进行增加操作
            numberHolder.increase();
        }
    }

}
