package rpc.dubbo.server.rpc;


import java.util.HashMap;
import java.util.Map;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.apache.commons.lang3.math.NumberUtils;
import rpc.dubbo.common.RpcDecoder;
import rpc.dubbo.server.annotation.RpcAnnotation;
import rpc.dubbo.server.bean.RpcRequest;
import rpc.dubbo.server.register.IRegisterCenter;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RpcServer {

    private Map<String, Object> handlerMap = new HashMap<>();

    private IRegisterCenter registerCenter;
    private String serviceAddress;

    public RpcServer(IRegisterCenter registerCenter, String serviceAddress) {
        this.registerCenter = registerCenter;
        this.serviceAddress = serviceAddress;
    }

    public void publisher() {
        for (String serviceName : handlerMap.keySet()) {
            registerCenter.register(serviceName, serviceAddress);
        }
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {

            bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new RpcDecoder(RpcRequest.class));
                        socketChannel.pipeline().addLast(new RpcServerHandler(handlerMap));
                    }
                });
            String[] addrs = serviceAddress.split(":");
            String ip = addrs[0];
            int port = NumberUtils.createInteger(addrs[1]);
            ChannelFuture future = bootstrap.bind(ip, port).sync();
            System.out.println("服务启动成功，等待客户端链接");
            //ctx.close()后执行，然后关闭服务，理论上只有异常才会执行下面
            System.out.println("服务端阻塞等待返回--------------");
            future.channel().closeFuture().sync();
            System.out.println("服务端关闭--------------");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public void bind(Object... services) {
        for (Object service : services) {
            RpcAnnotation server = (RpcAnnotation) service.getClass().getAnnotation(RpcAnnotation.class);
            String serviceName = server.value();
            handlerMap.put(serviceName, service);
        }
    }
}
