package org.tzl.rabbitMQ;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Sender {

    public static void main(String[] args) throws IOException {
        // 广播
        fanoutTest();
        // 匹配
        // directTest();
        // 主题
        // topicTest();
    }

    public static void fanoutTest() throws IOException {
        Connection connetion = Conf.FACTORY.newConnection();
        Channel channel = connetion.createChannel();
        // autoDelete自动删除队列 (消费者断掉连接 队列自动删除)
        channel.queueDeclare(Conf.QUEUE_NAME, false, false, false, null);

        channel.queueDeclare(Conf.QUEUE_NAME_2, false, false, false, null);

        // 广播：不处理路由key,转发到所有绑定的队列
        channel.exchangeDeclare(Conf.EXCHANGE_NAME, "fanout", true);

        channel.queueBind(Conf.QUEUE_NAME, Conf.EXCHANGE_NAME, "", null);
        channel.queueBind(Conf.QUEUE_NAME_2, Conf.EXCHANGE_NAME, "", null);

        byte[] body = null;
        System.out.println("send start..");
        for (int i = 0; i < 1000; i++) {
            body = ("Sender fanout message:" + i).getBytes();
            channel.basicPublish(Conf.EXCHANGE_NAME, "", null, body);
            System.out.println(i);
        }
        channel.close();
        connetion.close();
        System.out.println("send ends..");
    }

    public static void directTest() throws IOException {
        final String routingKey = "black";
        Connection connetion = Conf.FACTORY.newConnection();
        Channel channel = connetion.createChannel();
        // 队列1
        channel.queueDeclare(Conf.QUEUE_NAME, false, false, false, null);
        // 队列2
        channel.queueDeclare(Conf.QUEUE_NAME_2, false, false, false, null);
        // 声明exchange,并设置类型为direct
        // 处理路由key,必须完全匹配
        channel.exchangeDeclare(Conf.EXCHANGE_NAME_2, "direct", true);

        channel.queueBind(Conf.QUEUE_NAME, Conf.EXCHANGE_NAME_2, "", null);
        channel.queueBind(Conf.QUEUE_NAME_2, Conf.EXCHANGE_NAME_2, routingKey, null);

        byte[] body = null;
        System.out.println("send start..");
        for (int i = 0; i < 10000; i++) {
            body = ("Sender direct message:" + i).getBytes();
            channel.basicPublish(Conf.EXCHANGE_NAME_2, routingKey, null, body);
            System.out.println(i);
        }
        channel.close();
        connetion.close();
        System.out.println("send ends..");
    }

    public static void topicTest() throws IOException {
        final String routingKey = "black";
        Connection connetion = Conf.FACTORY.newConnection();
        Channel channel = connetion.createChannel();
        // 队列1
        channel.queueDeclare(Conf.QUEUE_NAME, false, false, false, null);
        // 队列2
        channel.queueDeclare(Conf.QUEUE_NAME_2, false, false, false, null);

        // topic:匹配模式
        channel.exchangeDeclare(Conf.EXCHANGE_NAME_2, "topic", true);

        /**
         * *（星号）：代表任意字符 一个单词 <br>
         * #（hash）：0个或者多个单词
         */
        channel.queueBind(Conf.QUEUE_NAME, Conf.EXCHANGE_NAME_2, "*" + routingKey + "*");
        channel.queueBind(Conf.QUEUE_NAME_2, Conf.EXCHANGE_NAME_2, "*" + routingKey + "*", null);

        // routing key = #;满足所有routing key,功能类似于fanout
        // channel.queueBind(Conf.QUEUE_NAME, Conf.EXCHANGE_NAME_2, "#");
        // channel.queueBind(Conf.QUEUE_NAME_2, Conf.EXCHANGE_NAME_2, "#");

        // 如果exchange类型为topic,且没有使用 * #，则功能就变成了direct

        byte[] body = null;
        System.out.println("send start..");
        for (int i = 0; i < 10000; i++) {
            body = ("Sender direct message:" + i).getBytes();
            //
            channel.basicPublish(Conf.EXCHANGE_NAME_2, "qq" + routingKey + "qa", null, body);
            System.out.println(i);
        }
        channel.close();
        connetion.close();
        System.out.println("send ends..");
    }
}
