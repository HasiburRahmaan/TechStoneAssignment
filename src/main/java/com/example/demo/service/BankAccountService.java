package com.example.demo.service;

import com.example.demo.entity.BankAccount;
import com.example.demo.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccount createBankAccount(BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount getBankAccountByAccountNumber(String accountNumber){
        return bankAccountRepository.findByBankAccountNumber(accountNumber);
    }

    public BankAccount updateAccountBalance(double amount, String accountNumber){
        BankAccount account = bankAccountRepository.findByBankAccountNumber(accountNumber);
        if(account!=null){
            account.setCurrentBalance(account.getCurrentBalance()+amount);
            bankAccountRepository.save(account);
        }
        return account;
    }
}
