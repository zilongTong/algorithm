package org.tzl.rabbitMQ;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.rabbitmq.client.ShutdownSignalException;

public class Receriver2 {

    public static void main(String[] args) throws IOException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {

        Connection connetion = Conf.FACTORY.newConnection();

        Channel channel = connetion.createChannel();

        channel.basicQos(1);

        QueueingConsumer consumer = new QueueingConsumer(channel);

        channel.basicConsume(Conf.QUEUE_NAME, false, consumer);

        // channel.basicQos(0, 1, true);
        // channel.basicQos(0, 10, true);

        Delivery delivery = null;
        while (true) {
            try {
                delivery = consumer.nextDelivery();
                String body = new String(delivery.getBody());
                print(body);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        }
    }

    public static void print(String body) {
        System.out.println("receriver2 task print:" + body);
    }

}
