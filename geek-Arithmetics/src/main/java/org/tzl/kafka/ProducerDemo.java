/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: ProducerDemo.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-11-02 08 : 13:53
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-11-02 08 : 13:53> <version>   <desc>
 *//*


package org.tzl.kafka;


import java.util.Properties;

*/
/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 *//*

public class ProducerDemo {

    Properties props = new Properties();
 props.put("bootstrap.servers","localhost:9092");
 props.put("acks","all");
 props.put("retries",0);
 props.put("batch.size",16384);
 props.put("linger.ms",1);
 props.put("buffer.memory",33554432);
 props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
 props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

    Producer<String, String> producer = new KafkaProducer<>(props);
 for(
    int i = 0;
    i< 100;i++)
        producer.send(new ProducerRecord<String, String>("my-topic",Integer.toString(i),Integer.toString(i)));

 producer.close();
}
*/
