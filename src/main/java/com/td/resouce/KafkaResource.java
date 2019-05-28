package com.td.resouce;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaResource {

    // 无法自动注入，使用唯一构造器自动注入
    private KafkaTemplate<String, String> kafkaTemplate;
    public KafkaResource(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/")
    public String login(){
        return "ok";
    }

    @GetMapping("/send/{topic}/{content}")
    public String send(@PathVariable("topic") String topic,
                       @PathVariable("content") String content){
        try {
            System.out.println("准备发送消息..." + content);
            kafkaTemplate.send(topic, content);
            System.out.println("准备发送完成...");
        }catch (Exception e){
            e.printStackTrace();
            return "send fail";
        }
        return "send success";
    }

}
