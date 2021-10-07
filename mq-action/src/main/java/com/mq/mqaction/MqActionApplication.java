package com.mq.mqaction;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JulyWhj
 */
@EnableRabbit
@SpringBootApplication
public class MqActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqActionApplication.class, args);
    }

}
