package com.example.demo.service;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Grade;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private BankAccountService bankAccountService;


    public Employee createEmployee(Employee employee){
        try{
            return employeeRepository.save(employee);
        }catch (Exception e){
            System.out.print("Exception\n");
            System.out.print(e);
        }

        return  employee;
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByBankAccountNumber(String bankAccountNumber){
        List<Employee> employeeList = employeeRepository.findByEmployeeBankAccountNumber(bankAccountNumber);
        if(employeeList.size() == 0){
            return null;
        }
        return employeeList.get(0);
    }

    public ArrayList getEmployeeFullInformation(){

        ArrayList hashMapList = new ArrayList();

        List<Employee> employeeList = getAllEmployee();
        for(Employee employee : employeeList){
            Grade grade = gradeService.getGradeById(employee.getEmployeeGradeId());
            BankAccount bankAccount =
                    bankAccountService.getBankAccountByAccountNumber(employee.getEmployeeBankAccountNumber());
            HashMap<String, String > map = new HashMap<>();
            map.put("employeeId", employee.getEmployeeId()+"");
            map.put("employeeName", employee.getEmployeeName());
            if(grade!=null){
                map.put("gradeId", grade.getGradeId()+"");
                map.put("gradeName", grade.getGradeName());
                map.put("gradeBasicSalary", grade.getGradeBasicSalary()+"");
                map.put("gradeHouseRent", grade.getGradeHouseRent()+"");
                map.put("gradeMedicalAllowance", grade.getGradeMedicalAllowance()+"");
            }
            if(bankAccount!=null){
                map.put("bankAccountNumber", bankAccount.getBankAccountNumber()+"");
                map.put("currentBalance", bankAccount.getCurrentBalance()+"");
            }



            hashMapList.add(map);
        }


        return hashMapList;
    }


    public Employee updateEmployee(Employee employeeWithUpdatedInformation){
        Employee employee = employeeRepository.findById(employeeWithUpdatedInformation.getEmployeeId()).orElse(null);
        if(employee == null){
            return null;
        }
        employee = employeeWithUpdatedInformation;
        return employeeRepository.save(employee);
    }
}
