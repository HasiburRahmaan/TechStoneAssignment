package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GradeService gradeService;

    private String validatingUserInformation(Employee employee){
        String msg = "";
        if(gradeService.getGradeById(employee.getEmployeeGradeId()) == null){
            msg = "Grade is not valid";
        }
        Employee createdEmployee =
                employeeService.getEmployeeByBankAccountNumber(employee.getEmployeeBankAccountNumber());
        if(createdEmployee != null && createdEmployee.getEmployeeId()!= employee.getEmployeeId()){
            msg = "Bank Account is not valid";
        }
        return msg;
    }

    @PostMapping("/employee/post")
    public ResponseEntity<?> createEmployee( @RequestBody Employee employee){

        String msg = validatingUserInformation(employee);
        if(msg.length() == 0){
            return ResponseEntity.created(null).body(employeeService.createEmployee(employee));
        }
        else {
            return ResponseEntity.created(null).body(msg);
        }

    }

    @GetMapping("/employee/get/all")
    public ResponseEntity<?> getAllEmployee(){
        return ResponseEntity.created(null).body(employeeService.getAllEmployee());
    }

    @GetMapping("/employee/get/information")
    public ResponseEntity<?> jsonTest(){
        return ResponseEntity.created(null)
                .body(employeeService.getEmployeeFullInformation());
    }

    @PutMapping("/employee/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        String msg = validatingUserInformation(employee);
        if(msg.length() == 0){
            return ResponseEntity.created(null).body(employeeService.updateEmployee(employee));
        }
        else {
            return ResponseEntity.created(null).body(msg);
        }
    }


}
