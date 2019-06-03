package netty.hashedWheelTimer;

import io.netty.util.HashedWheelTimer;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName HashedWheelTimerDemo
 *  HashedWheelTimer 主要用来高效处理大量定时任务,
 *  且任务对时间精度要求相对不高,  比如链接超时管理等场景, 缺点是,  内存占用相对较高.
 *
 * 构造函数参数
 * HashedWheelTimer(
 *     ThreadFactory threadFactory, //类似于Clock中的updater, 负责创建Worker线程.
 *     long tickDuration,           //时间刻度之间的时长(默认100ms), 通俗的说, 就是多久tick++一次.
 *     TimeUnit unit,               //tickDuration的单位.
 *     int ticksPerWheel            //类似于Clock中的wheel的长度(默认512).
 * ):
 *
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/3/12 16:17
 **/
public class HashedWheelTimerDemo {

    public static void main(String[] args) throws Exception {
        //创建Timer, 精度为100毫秒,
        HashedWheelTimer timer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS, 16);

        System.out.println(LocalTime.now());

        timer.newTimeout((timeout) -> {
            System.out.println(LocalTime.now());
            System.out.println(timeout);
        }, 5, TimeUnit.SECONDS);

        //阻塞main线程
//        System.in.read();
    }
}
