package netty.study.c1.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import netty.study.c1.server.handler.ServerHandler;


public class NettyServer {


    private static EventLoopGroup bossEventGroup;
    private static EventLoopGroup workerEventGroup;


    public static void start() {
        bossEventGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors());
        workerEventGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossEventGroup, workerEventGroup)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new ServerHandler());
                    }
                });
        try {
            ChannelFuture future = bootstrap.bind(8080).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossEventGroup.shutdownGracefully();
            workerEventGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        start();
    }
}
