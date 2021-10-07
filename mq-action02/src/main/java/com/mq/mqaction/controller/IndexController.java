package com.mq.mqaction.controller;

import com.mq.mqaction.bean.Simple;
import com.mq.mqaction.producer.SimpleProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author julyWhj
 * @Description IndexController$
 * @Date 2021/10/7 10:18 上午
 **/
@RestController
public class IndexController {

    @Autowired
    private SimpleProducer simpleProducer;

    @GetMapping("/index")
    public String index() {
        return "Hello RabbitMQ";
    }

    @GetMapping("/producer")
    public String simpleProducer() {
        for (int i = 0; i < 10; i++) {
            simpleProducer.sendOrderMessage(Simple.builder()
                    .createTime(new Date())
                    .name("JulyWhj")
                    .age(i)
                    .no("ID-000" + i)
                    .phone("138XXXXXXXX")
                    .build());
        }
        return "消息发送成功";
    }
}
