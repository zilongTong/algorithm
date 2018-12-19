/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: ChannelOperationExamples.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-07-03 04 : 05:06
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-07-03 04 : 05:06> <version>   <desc>
 */

package netty.chapter4;

import java.nio.charset.Charset;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ChannelOperationExamples {


    public static void write2channel() {
        Channel channel = new NioSocketChannel();
        ByteBuf buf = Unpooled.copiedBuffer("1111111111111", Charset.forName("UTF-8"));
        ChannelFuture cf = channel.writeAndFlush(buf);
        cf.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    System.out.println("write success");
                } else {
                    System.out.println("write error");
                }
            }
        });
    }

    public static void writingToChannelFromManyThreads() {
        Channel channel = new NioSocketChannel();
        ByteBuf buf = Unpooled.copiedBuffer("11111111111111", CharsetUtil.UTF_8).retain();
        Runnable writer = new Runnable() {
            @Override
            public void run() {
                channel.writeAndFlush(buf.duplicate());
            }
        };
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(writer);
        executor.execute(writer);
    }

}
