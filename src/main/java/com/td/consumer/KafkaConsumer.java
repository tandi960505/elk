package com.td.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    
    @KafkaListener(topics = "logs")
    public void consumer(String content){
        System.out.println("监听到：" + content);
    }
}
