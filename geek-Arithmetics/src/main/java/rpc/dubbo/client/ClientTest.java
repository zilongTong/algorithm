package rpc.dubbo.client;

import com.rabbitmq.client.RpcClient;
import rpc.dubbo.client.api.ILeoService;
import rpc.dubbo.client.proxy.RpcClientProxy;
import rpc.dubbo.client.registry.IServiceDiscovery;
import rpc.dubbo.client.registry.ServiceDiscoveryImpl;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ClientTest {
    public static void main(String[] args) {
        IServiceDiscovery serviceDiscovery = new ServiceDiscoveryImpl();
        RpcClientProxy proxy = new RpcClientProxy(serviceDiscovery);
        ILeoService leoService = proxy.create(ILeoService.class);
        System.out.println("ClientTest-----" + leoService.say("leo 111111"));
        System.out.println("----------------------------------------------");
        System.out.println("ClientTest-----" + leoService.say("leo 222222"));
        System.out.println("----------------------------------------------");
        System.out.println("ClientTest-----" + leoService.say("leo 333333"));
        System.out.println("----------------------------------------------");
        System.out.println("ClientTest-----" + leoService.say("leo 444444"));
        System.out.println("----------------------------------------------");
        System.out.println("ClientTest-----" + leoService.say("leo 555555"));
    }
}
