package com.example.weibo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibo.mapper.AccountMapper;
import com.example.weibo.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WeiboApplicationTests {
    @Resource
    private AccountMapper accountMapper;
    @Test
    void testGetAll() {
        System.out.println(accountMapper.selectList(null));
    }
    @Test
    void testGetById(){
        System.out.println(accountMapper.selectById(1));
    }
    @Test
    void testSave(){
        Account account = new Account();
        account.setMoney(100.23);
        account.setName("测试");
        accountMapper.insert(account);
    }
    @Test
    void testGetPage(){
        IPage page = new Page(1,1);
        accountMapper.selectPage(page,null);
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
    }
    @Test
    void testGetBy(){
        QueryWrapper<Account> qw = new QueryWrapper<>();
        qw.like("name","测试");
        accountMapper.selectList(qw);
    }
    @Test
    void testGetBy2(){
        String name = null;
        LambdaQueryWrapper<Account> lqw = new LambdaQueryWrapper<Account>();
        lqw.like(name !=null,Account::getName,name);
        accountMapper.selectList(lqw);
    }
}
