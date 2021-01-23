package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class BankAccount {
    @Id
    private String bankAccountNumber;
//    @ManyToOne
//    private BankAccountType bankAccountType;
    private int bankAccountTypeId;
    private String bankAccountName;
    private double currentBalance;
    private String branchInfo;
}
