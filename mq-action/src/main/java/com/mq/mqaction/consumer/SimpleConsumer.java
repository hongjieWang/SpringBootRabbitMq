package com.mq.mqaction.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mq.mqaction.bean.Simple;
import com.mq.mqaction.config.SimpleMqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

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
    public void receiveObject(Simple simple) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String message = objectMapper.writeValueAsString(simple);
        log.info("simple consumer receive the object:{}", message);
    }
}
