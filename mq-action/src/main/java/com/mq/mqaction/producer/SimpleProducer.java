package com.mq.mqaction.producer;

import com.mq.mqaction.bean.Simple;
import com.mq.mqaction.config.SimpleMqConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author julyWhj
 * @Description 生产者$
 * @Date 2021/10/7 10:54 上午
 **/
@Component
public class SimpleProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 消息体为对象。配置MessageConverter为Jackson2JsonMessageConverter即可
     *
     * @param simple
     */
    public void sendOrderMessage(Simple simple) {
        rabbitTemplate.convertAndSend(SimpleMqConstant.HANDLER_OBJECT_QUEUE_NAME, simple);
    }
}
