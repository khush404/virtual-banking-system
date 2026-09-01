package com.example.virtualbanking.controller;

import com.example.virtualbanking.entity.Account;
import com.example.virtualbanking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestParam Long userId, @RequestParam String accountType){
        Account account = accountService.createAccount(userId, accountType);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
}
