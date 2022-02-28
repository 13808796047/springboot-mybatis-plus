package com.example.weibo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Account {
    @TableId
    private Integer id ;
    private String name ;
    private double money;
}
