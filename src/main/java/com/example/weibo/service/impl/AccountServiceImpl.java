package com.example.weibo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.weibo.mapper.AccountMapper;
import com.example.weibo.pojo.Account;
import com.example.weibo.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
}
