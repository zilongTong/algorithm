package org.tzl.rabbitMQ;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.rabbitmq.client.ShutdownSignalException;

public class Receriver {

    public static void main(String[] args) throws IOException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {
        Connection connetion =  org.tzl.rabbitMQ.Conf.FACTORY.newConnection();
        Channel channel = connetion.createChannel();
        // 控制分发获取数量/控制一次从服务器拿20条
        channel.basicQos(0, 20, true);

        QueueingConsumer consumer = new QueueingConsumer(channel);

        // basicConsume autoAck:是否自动确认
        channel.basicConsume(org.tzl.rabbitMQ.Conf.QUEUE_NAME, false, consumer);

        // 控制消费者从服务器获取的消息数量
        // tmp:服务器队列有1W消息，启动消费者1时导致全部获取了服务器的未确认消息，当启动消费者2时状态为限制状态，导致消费者2不能进行消费
        // tmp:手里的消费完再向服务器拿
        // tmp:不设置或设置为0，则为获取所有
        // channel.basicQos(0, 1, true);

        Delivery delivery = null;
        while (true) {
            try {
                delivery = consumer.nextDelivery();
                String body = new String(delivery.getBody());
                add(body);
                Thread.sleep(80000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 如果不是设置的自动ack消息，且没有手动设置ack，则消息依然存在mq服务器，下一个消费者能继续读取到该消息
                // channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        }
    }

    public static void add(String body) {
        System.out.println("receriver tack add:" + body);
    }

}
