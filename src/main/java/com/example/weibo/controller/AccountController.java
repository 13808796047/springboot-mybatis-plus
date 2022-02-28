package com.example.weibo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibo.controller.utils.R;
import com.example.weibo.pojo.Account;
import com.example.weibo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public List<Account> getAll() {
        return accountService.list();
    }
    @PostMapping
    public R save(@RequestBody Account account){
      return new R(accountService.save(account),null);
    }
    @PutMapping
    public Boolean update(@RequestBody Account account){
        return accountService.updateById(account);
    }
    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return accountService.removeById(id);
    }
    @GetMapping("{id}")
    public Account getById(@PathVariable Integer id){
        return accountService.getById(id);
    }
    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Account> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        String name = null;
        IPage<Account> page = new Page<Account>(currentPage, pageSize);
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<Account>();
        queryWrapper.like(name != null, Account::getName, name);
        return accountService.page(page,queryWrapper);
    }
}
