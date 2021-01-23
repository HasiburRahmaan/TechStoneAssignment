package com.example.demo.controller;

import com.example.demo.entity.Company;
import com.example.demo.service.CompanyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/company/post")
    public Company createCompanyData(@RequestBody Company company){
        Company companyData = companyService.getCompanyData();
        if(companyData != null){
            return companyData;
        }else{
            return companyService.saveCompanyData(company);
        }

    }

    @GetMapping("/company/get/companyData")
    public ResponseEntity<?> getCompanyData(){
        return ResponseEntity.created(null).body(companyService.getCompanyData());
    }

    @GetMapping("/company/get/basicsalary")
    public double getBasicSalaryOfLowestGrade(){

        return companyService.getBasicSalaryOfLowestGrade();
    }

    @GetMapping("/company/get/totalsalary")
    public double getTotalAmountOfSalary(){
        return companyService.getTotalSalaryOfAllEmployees();
    }

    @PutMapping("/company/update/basicsalary")
    public Company updateBasicSalaryOfLowestGrade(@RequestBody Amount amount){
        return companyService.updateBasicSalary(amount.getAmount());
    }

    @PutMapping("/company/update/initialBalance")
    public Company updateInitialBalance(@RequestBody Amount amount){
        return companyService.updateCompanyBalance(amount.getAmount());
    }

    @PutMapping("/company/update/sendsalary")
    public ResponseEntity<?> sendSalaryToEmployees(){
        return ResponseEntity.created(null).body(companyService.sendSalaryToAllEmployee());
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static private class Amount{
        double amount;
    }
}
