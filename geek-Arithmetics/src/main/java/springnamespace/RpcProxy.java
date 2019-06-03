package springnamespace;


import com.rabbitmq.client.RpcClient;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;
import rpc.dubbo.common.RpcRequest;
import rpc.dubbo.common.RpcResponse;

import java.lang.reflect.Method;
import java.util.UUID;


public class RpcProxy {

    private String serverAddress;
    //保存不同服务信息对应的ServiceDiscovery对象
    private String registryAddress;
    private int zk_session_timeout;

    public RpcProxy(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public RpcProxy(String registryAddress,
                    int zk_session_timeout) {
        super();
        this.registryAddress = registryAddress;
        this.zk_session_timeout = zk_session_timeout;
    }

//	public RpcProxy(ServiceDiscovery serviceDiscovery) {
//        this.serviceDiscovery = serviceDiscovery;
//    }

    /**
     * @param interfaceClass   调用的服务类名称
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T create(Class<?> interfaceClass) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        RpcRequest request = new RpcRequest(); // 创建并初始化 RPC 请求
                        request.setRequestId(UUID.randomUUID().toString());
                        request.setClassName(method.getDeclaringClass().getName());
                        request.setMethodName(method.getName());
                        request.setParameterTypes(method.getParameterTypes());
                        request.setParameters(args);

//                        String[] array = serverAddress.split(":");
//                        String host = array[0];
//                        int port = Integer.parseInt(array[1]);
////                        RpcClient client = new RpcClient("111", 11); // 初始化 RPC 客户端
//                        RpcResponse response = client.send(request); // 通过 RPC 客户端发送 RPC 请求并获取 RPC 响应
//
//                        if (response.getError() != null) {
//                            throw response.getError();
//                        } else {
//                            return response.getResult();
//                        }
                        return null;
                    }
                }
        );
    }
}
