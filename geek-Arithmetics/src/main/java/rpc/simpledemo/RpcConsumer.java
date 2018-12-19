package rpc.simpledemo;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RpcConsumer {
    public static void main(String[] args) {
        try {
            ILeoService leoService = RpcFrameWork.refer(ILeoService.class, "127.0.0.1", 8888);
            for (int i = 0; i < 10000; i++) {
                String hello = leoService.leo("leo" + i);
                System.out.println(hello);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
