package rpc.zookeeper;

import org.apache.zookeeper.CreateMode;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Test {
    static final String CONNECT_ADDR = "59.110.238.22:2181";


    public static void main(String[] args) {
        CuratorClient zkClient = CuratorClient.getInstance(CONNECT_ADDR);
        try {
            String path = zkClient.writeNode("/server/zk", "leoooooooo", CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(path);
            while (true) {
                System.out.println(zkClient.readRandom("/server"));
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

}
