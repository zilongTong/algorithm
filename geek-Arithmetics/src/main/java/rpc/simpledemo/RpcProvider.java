package rpc.simpledemo;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RpcProvider {
    public static void main(String[] args) {
        ILeoService leoService = new LeoServiceImpl();
        try {
            RpcFrameWork.export(leoService, 8888);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
