package com.mq.mqaction;

import com.mq.mqaction.bean.Simple;
import com.mq.mqaction.producer.SimpleProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Author julyWhj
 * @Description $
 * @Date 2021/10/7 10:58 上午
 **/
@SpringBootTest
@Slf4j
public class SimpleMqTest {
    @Autowired
    private SimpleProducer simpleProducer;

    @Test
    public void testSimple() throws Exception {
        for (int i = 0; i < 10; i++) {
            simpleProducer.sendOrderMessage(Simple.builder()
                    .createTime(new Date())
                    .name("JulyWhj")
                    .age(i)
                    .no("ID-0001")
                    .phone("138XXXXXXXX")
                    .build());
        }
    }
}
