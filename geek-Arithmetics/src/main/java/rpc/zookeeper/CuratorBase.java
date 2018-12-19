package rpc.zookeeper;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;

public class CuratorBase {

    static final String CONNECT_ADDR = "59.110.238.22:2181";
    static final int SESSION_TIMEOUT = 35000;//会话超时时间，默认为60000，单位：ms
    static final int CONNECTION_TIMEOUT=60000;//连接超时时间，默认为15000，单位：ms

    public static void main(String[] args) throws Exception {

        //重试策略：初试时间为10s，最大重试次数为20
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(10000, 20);
        //创建连接
        CuratorFramework cf = CuratorFrameworkFactory.builder()
            .connectString(CONNECT_ADDR)
            .sessionTimeoutMs(SESSION_TIMEOUT)
            .retryPolicy(retryPolicy)
            .build();
        //开启连接
        cf.start();

        // 绑定回调函数
        ExecutorService pool = Executors.newCachedThreadPool();
        cf.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
            .inBackground(new BackgroundCallback() {
                @Override
                public void processResult(CuratorFramework cf, CuratorEvent ce) throws Exception {
                    System.out.println("code:" + ce.getResultCode());
                    System.out.println("type:" + ce.getType());
                    System.out.println("线程为:" + Thread.currentThread().getName());
                }
            }, pool)
            .forPath("/persistent/p2","p2 value".getBytes());

        System.out.println("主线程："+Thread.currentThread().getName());

        Thread.sleep(Integer.MAX_VALUE);

        cf.close();
    }
}
