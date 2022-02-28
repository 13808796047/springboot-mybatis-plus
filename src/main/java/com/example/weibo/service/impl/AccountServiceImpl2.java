package com.example.weibo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibo.mapper.AccountMapper;
import com.example.weibo.pojo.Account;
import com.example.weibo.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl2 implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public Boolean save(Account account) {
        return accountMapper.insert(account) > 0;
    }

    @Override
    public Boolean update(Account account) {
        return accountMapper.updateById(account) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return accountMapper.deleteById(id)>0;
    }

    @Override
    public Account getById(Integer id) {
        return accountMapper.selectById(id);
    }

    @Override
    public List<Account> getAll() {
        return accountMapper.selectList(null);
    }

    @Override
    public IPage<Account> getPage(int currentPage,int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        return accountMapper.selectPage(page,null);
    }
}
