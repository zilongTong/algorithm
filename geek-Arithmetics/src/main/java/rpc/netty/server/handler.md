ChannelHandler本身并没有提供很多方法，因为这个接口有许多的方法需要实现，方便使用期间，可以继承它的子类：

ChannelInboundHandler用于处理入站I / O事件
/read

ChannelOutboundHandler用于处理出站I / O操作
/write


或者使用以下适配器类：

ChannelInboundHandlerAdapter用于处理入站I / O事件

ChannelOutboundHandlerAdapter用于处理出站I / O操作

ChannelDuplexHandler用于处理入站和出站事件(同时继承上面两个适配器)



ChannelHandlerContext
保存Channel相关的所有上下文信息，同时关联一个ChannelHandler对象
-------------------------------------------------------------------


ChannelPipeline为ChannelHandler链提供了容器，并定义了用于在该链上传播入站和出站事件流的API。当Channel被创建时，他会自动的分配到它专属的ChannelPipeline。

ChannelHandller安装到ChannelPipeline中的过程如下所示：

一个ChannelInitializer的实现被注册到了ServerBootstrap中；
当ChannelInitializer.initChannel（）方法被调用时，ChannelInitializer将在ChannelPipeline中安装一组自定义的ChannelHandler；
ChannelInitializer将它自己从ChannelPipeline中移除
  也就是说ChannelPipeline是ChannelHandler的容器，这样使得事件流经ChannelPipeline是ChannelHandler的工作，它们是在应用程序的初始化啊或者引导阶段被安装的。这些对象接受事件，执行它们所实现的处理逻辑，并将数据传递给链中的下一个ChannelHandler。它们的执行顺序是由它们被添加的顺序锁决定的。实际上，被我们称为ChannelPipeline是这些ChannelHandler的编排顺序。
--------------------- 

那么入站处理器ChannelInboundHannelHandler和ChannelOutboundHandler有什么区别呢。举一个例子

 ChannelPipeline p = ...;
 p.addLast("1", new InboundHandlerA());
 p.addLast("2", new InboundHandlerB());
 p.addLast("3", new OutboundHandlerA());
 p.addLast("4", new OutboundHandlerB());
 p.addLast("5", new InboundOutboundHandlerX());
  从代码中我们知道ChannelHandler在ChannelPipeline中的编排顺序是从1，2，3，4，5。当入站时是从ChannelPipeline中从头部一次执行的，也就是一次执行1，2，5；
同理当出站时是从ChannelPipeline的尾部像头部的方向一次执行的，也就是一次执行5，4，3；
--------------------- 
从一个客户端应用程序的角度看，如果事件的运动方向是客户端到服务端，那么我们称这些时间为出站的，反之则成为入站，同理，从一个服务端的角度看，如果事件的运动方向是服务端到客户端则称为出站，反之为入站。


ctx.fireChannelRead(msg);
向下个节点传递，如果自定义了handler来处理就可以拦截channelRead的bytebuf数据来进行处理，
负责一直向下传递到TailContext节点处理 
io.netty.channel.DefaultChannelPipeline.TailContext#channelRead
  protected void onUnhandledInboundMessage(Object msg) {
        try {
            //日志提醒没有处理
            logger.debug(
                    "Discarded inbound message {} that reached at the tail of the pipeline. " +
                            "Please check your pipeline configuration.", msg);
        } finally {
            //释放byteBuf内存
            ReferenceCountUtil.release(msg);
        }
    }
--------------------- 


当你处理channelRead(...) 操作，并在消费消息(不是通过ChannelHandlerContext.fireChannelRead(...) 来传递它到下个ChannelInboundHandler) 时，要释放它，如下：

Listing 6.3 Handler that consume inbound data

@ChannelHandler.Sharable
public class DiscardInboundHandler extends ChannelInboundHandlerAdapter {  //1

    @Override
    public void channelRead(ChannelHandlerContext ctx,
                                     Object msg) {
        ReferenceCountUtil.release(msg); //2：使用ReferenceCountUtil.release(...) 来释放资源
    }

}

channel:

NioSocketChannel，异步的客户端 TCP Socket 连接

NioServerSocketChannel，异步的服务器端 TCP Socket 连接

NioDatagramChannel，异步的 UDP 连接

NioSctpChannel，异步的客户端 Sctp 连接

NioSctpServerChannel，异步的 Sctp 服务器端连接