package com.example.virtualbanking.service;

import com.example.virtualbanking.entity.Account;
import com.example.virtualbanking.entity.User;
import com.example.virtualbanking.repository.AccountRepository;
import com.example.virtualbanking.repository.UserRepository;

import java.util.Random;

public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository){
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public Account createAccount(Long userId, String accountType){
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        String accountNumber = generateAccountNumber();

        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(0.0);
        account.setAccountType(accountType);
        account.setUser(user);

        return accountRepository.save(account);
    }

    private String generateAccountNumber(){

        String accountNumber;
        do{
            accountNumber = "VB"
                    + (100000 + new Random().nextInt(900000));
        }while(accountRepository.existByAccountNumber(accountNumber));
        return accountNumber;
    }
}
