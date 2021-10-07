package com.mq.mqaction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author julyWhj
 * @Description IndexController$
 * @Date 2021/10/7 10:18 上午
 **/
@RestController
public class IndexController {
    @GetMapping("/index")
    public String index() {
        return "Hello RabbitMQ";
    }
}
