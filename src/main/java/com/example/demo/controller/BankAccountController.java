package com.example.demo.controller;

import com.example.demo.entity.BankAccount;
import com.example.demo.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/post")
    public BankAccount createBankAccount(@RequestBody BankAccount bankAccount){
        return bankAccountService.createBankAccount(bankAccount);
    }

    @GetMapping("/get/id/{accountNumber}")
    public BankAccount getBankAccountByAccountNumber(@PathVariable String accountNumber){
        return bankAccountService.getBankAccountByAccountNumber(accountNumber);
    }



}
