package com.example.demo.repository;

import com.example.demo.entity.BankAccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<BankAccountType, Integer> {
}
