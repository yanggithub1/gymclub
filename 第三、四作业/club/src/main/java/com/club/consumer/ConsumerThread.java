package com.club.consumer;

import com.club.consumer.KafkaConsumerDemo;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerThread implements Runnable {

    // 每个线程维护私有的KafkaConsumer实例
    @Resource(name = "kafkaConsumerDemo")
    private KafkaConsumer<String, String> consumer;

    public ConsumerThread() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("group.id", "group1");
        props.put("enable.auto.commit", "true");        //本例使用自动提交位移
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        this.consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("my-replicated-topic"));   // 本例使用分区副本自动分配策略
    }


    @Override
    public void run() {
        boolean isOpened = true;
        while (isOpened) {
            ConsumerRecords<String, String> records = consumer.poll(100);   // 本例使用200ms作为获取超时时间
            for (ConsumerRecord<String, String> record : records) {
                // 这里面写处理消息的逻辑，本例中只是简单地打印消息
                System.out.println(Thread.currentThread().getName() + " consumed " + record.partition() +
                        "th message with offset: " + record.offset());
                System.out.println("Get Messages: " + record.value());
            }
            consumer.close();
            isOpened = false;
        }
    }
}
