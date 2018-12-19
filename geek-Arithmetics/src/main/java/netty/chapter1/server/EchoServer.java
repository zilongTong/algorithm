/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: EchoServer.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-06-13 03 : 51:07
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-06-13 03 : 51:07> <version>   <desc>
 */

package netty.chapter1.server;


import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.err.println(
//                "Usage: " + EchoServer.class.getSimpleName() +
//                    " <port>");
//            return;
//        }
        final ByteBuf buf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("aaaaaaa", Charset.forName("utf-8")));
        int port = Integer.parseInt("8888");
        new EchoServer(port).start();
    }

    public void start() throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new EchoServerHandler());
                    }
                });
            ChannelFuture future = b.bind().sync();
            System.out.println(EchoServer.class.getName() + " started and listen on "
                + future.channel().localAddress());
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            group.shutdownGracefully().sync();
        }
    }
}
