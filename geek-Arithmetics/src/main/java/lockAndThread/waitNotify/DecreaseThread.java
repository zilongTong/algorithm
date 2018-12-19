package lockAndThread.waitNotify;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
public class DecreaseThread extends Thread
{
    private NumberHolder numberHolder;

    public DecreaseThread(NumberHolder numberHolder)
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
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            // 进行减少操作
            numberHolder.decrease();
        }
    }

}