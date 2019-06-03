package rpc.dubbo.server;

import rpc.dubbo.server.api.ILeoService;
import rpc.dubbo.server.api.LeoServiceImpl;
import rpc.dubbo.server.register.IRegisterCenter;
import rpc.dubbo.server.register.RegisterCenterImpl;
import rpc.dubbo.server.rpc.RpcServer;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ServerTest {
    public static void main(String[] args) {
        ILeoService iLeoService = new LeoServiceImpl();
        IRegisterCenter registerCenter = new RegisterCenterImpl();
        RpcServer server = new RpcServer(registerCenter, "127.0.0.1:8089");
        server.bind(iLeoService);
        server.publisher();
    }
}
