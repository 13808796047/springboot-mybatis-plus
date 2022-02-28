package com.example.weibo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibo.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountServiceTest {
    @Autowired
    private IAccountService accountService;

    @Test
    void testGetAll() {
        accountService.list();
    }

    @Test
    void testSave() {
        Account account = new Account();
        account.setMoney(22);
        account.setName("测试3");
        accountService.save(account);
    }
    @Test
    void testUpdate() {
        Account account = new Account();
        account.setId(2);
        account.setMoney(22);
        account.setName("测试3");
        accountService.updateById(account);
    }
    @Test
    void testDelete(){
        accountService.removeById(3);
    }
    @Test
    void testGetPage() {
        IPage<Account> page = new Page<Account>(1, 1);
        accountService.page(page);
    }

    @Test
    void testGetByQuery() {
        String name = null;
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<Account>();
        queryWrapper.like(name != null, Account::getName, name);
        accountService.list(queryWrapper);
    }
}
