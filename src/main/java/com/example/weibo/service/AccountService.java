package com.example.weibo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weibo.pojo.Account;

import java.util.List;

public interface AccountService {
    Boolean save(Account account);
    Boolean update(Account account);
    Boolean delete(Integer id);
    Account getById(Integer id);
    List<Account> getAll();
    IPage<Account> getPage(int currentPage,int pageSize);
}
