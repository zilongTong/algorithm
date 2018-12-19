package rpc.netty.server;

import java.lang.reflect.Method;
import java.util.Map;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import rpc.dubbo.server.bean.RpcRequest;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 。这些对象接受事件，执行它们所实现的处理逻辑，并将数据传递给链中的下一个ChannelHandler。它们的执行顺序是由它们被添加的顺序锁决定的。实际上，被我们称为ChannelPipeline是这些ChannelHandler的编排顺序。
 * <p>
 * <p>
 * <p>
 * <p>
 * 从一个客户端应用程序的角度看，如果事件的运动方向是客户端到服务端，那么我们称这些时间为出站的，反之则成为入站，同理，从一个服务端的角度看，如果事件的运动方向是服务端到客户端则称为出站，反之为入站。
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * zk节点注册信息
     */
    private Map<String, Object> handlerMap;

    public EchoServerHandler(Map<String, Object> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcRequest rpc = new RpcRequest();
        Object result = new Object();
        if (handlerMap.containsKey(rpc.getClassName())) {
            Object clazz = handlerMap.get(rpc.getClassName());
            Method method = clazz.getClass().getMethod(rpc.getMethodName(), rpc.getTypes());
            result = method.invoke(clazz, rpc.getParams());
        }
        ctx.writeAndFlush(result);
        ctx.close();
        //也就是服务端执行完这一句:ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
            //服务端的这句代码才会往下执行
        // future.channel().closeFuture().sync();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
            .addListener(ChannelFutureListener.CLOSE);
        ReferenceCountUtil.release(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
