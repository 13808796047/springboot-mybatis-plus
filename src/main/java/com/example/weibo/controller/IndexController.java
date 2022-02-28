package com.example.weibo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibo.mapper.AccountMapper;

import com.example.weibo.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class IndexController {
    @Resource
    private AccountMapper accountMapper;
    @RequestMapping("/")
    public List<Account> index() {
        Page<Account> page = new Page<>(1,1);
        Page<Account> accounts = accountMapper.selectPage(page,null);
        return page.getRecords();
    }
}
