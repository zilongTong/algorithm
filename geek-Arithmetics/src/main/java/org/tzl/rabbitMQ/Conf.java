package org.tzl.rabbitMQ;

import com.rabbitmq.client.ConnectionFactory;

public class Conf {

    public static final String QUEUE_NAME = "receriver-Test";

    public static final String EXCHANGE_NAME = "exchange_tmp";

    public static final String QUEUE_NAME_2 = "receriver-Test-2";

    public static final String EXCHANGE_NAME_2 = "exchange_tmp_2";

    public static final ConnectionFactory FACTORY = new ConnectionFactory();

    static {
        FACTORY.setHost("192.168.50.32");
        FACTORY.setPort(5672);
        FACTORY.setVirtualHost("test");
        FACTORY.setUsername("admin");
        FACTORY.setPassword("admin");
    }

}
