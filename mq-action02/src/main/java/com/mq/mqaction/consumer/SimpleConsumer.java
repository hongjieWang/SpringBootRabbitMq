package com.mq.mqaction.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mq.mqaction.bean.Simple;
import com.mq.mqaction.config.SimpleMqConstant;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author julyWhj
 * @Description 消费者$
 * @Date 2021/10/7 10:57 上午
 **/
@Component
@Slf4j
public class SimpleConsumer {


    @RabbitListener(queuesToDeclare = @Queue(SimpleMqConstant.HANDLER_OBJECT_QUEUE_NAME))
    @RabbitHandler
    public void receiveObject(Message message, Simple simple, Channel channel) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String data = objectMapper.writeValueAsString(simple);
        log.info("simple consumer receive the object:{}", data);
        //消息标识
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        channel.basicAck(deliveryTag, false);
    }
}
