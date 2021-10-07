package com.mq.mqaction.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author julyWhj
 * @Description Simple对象$
 * @Date 2021/10/7 10:55 上午
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Simple implements Serializable {
    private String name;
    private String no;
    private int age;
    private String phone;
    private Date createTime;
}
