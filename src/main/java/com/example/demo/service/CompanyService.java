package com.example.demo.service;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Grade;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private BankAccountService bankAccountService;

    public Company saveCompanyData(Company company){
        return companyRepository.save(company);
    }

    public Company getCompanyData(){
        List<Company> companyList = companyRepository.findAll();
        if(companyList.size() == 0){
            return null;
        }
        Company company = companyList.get(0);
        return  company;
    }

    public double getBasicSalaryOfLowestGrade(){
        Company company =  getCompanyData();
        if(company == null){
            company =  new Company();
        }
        return company.getBasicSalaryOfLowestGrade();
    }

    public double getTotalSalaryOfAllEmployees(){
        double totalAmount = 0.0;
        List<Employee> employeeList = employeeService.getAllEmployee();
        List<Grade> gradeList = gradeService.getAllGrade();

        for(Employee employee : employeeList){
            for(Grade grade: gradeList){
                if(employee.getEmployeeGradeId() == grade.getGradeId()){
                    totalAmount += (
                            grade.getGradeBasicSalary() +
                            grade.getGradeHouseRent() +
                            grade.getGradeMedicalAllowance()
                    );
                }
            }
        }

        return  totalAmount;
    }

    public boolean sendSalaryToAllEmployee(){

        Company company = getCompanyData();
        double totalAmountNeedToPay = getTotalSalaryOfAllEmployees();

        if(company.getInitialBalance()>=totalAmountNeedToPay){
            List<Employee> employeeList = employeeService.getAllEmployee();
            for(Employee employee : employeeList){
                Grade employeeGrade = gradeService.getGradeById(employee.getEmployeeGradeId());
                if(employeeGrade != null){
                    double employeeSalary = employeeGrade.getGradeBasicSalary()
                            + employeeGrade.getGradeHouseRent() + employeeGrade.getGradeMedicalAllowance();

                    bankAccountService.updateAccountBalance(employeeSalary, employee.getEmployeeBankAccountNumber());
                }
            }
            reduceCompanyBalance(company.getInitialBalance()-totalAmountNeedToPay);
            return true;
        }

        return false;
    }

    public Company reduceCompanyBalance(double balance){
        Company company = getCompanyData();
        if(company!= null){
            company.setInitialBalance( balance);
            System.out.print("balance==>"+balance+" initBalance===>"+company.getInitialBalance());
            return companyRepository.save(company);
        }
        return new Company();
    }
    public Company updateCompanyBalance(double balance){
        Company company = getCompanyData();
        if(company!= null){
            company.setInitialBalance( company.getInitialBalance() + balance);
            return companyRepository.save(company);
        }
        return new Company();
    }

    public Company updateBasicSalary(double basicSalaryOfLowestGrade){
        Company company = getCompanyData();
        if(company!= null){
            company.setBasicSalaryOfLowestGrade(basicSalaryOfLowestGrade);
            company = companyRepository.save(company);
            gradeService.updateGradeSalaryIfBasicAmountOfLowestGradeIsChanged();
            return company;
        }
        return new Company();
    }

}
