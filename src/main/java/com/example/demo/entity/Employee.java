package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue
    private int employeeId;
    private String employeeName;
    private String employeeAddress;
    private String employeeMobile;
    private int employeeGradeId;
    private String employeeBankAccountNumber;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name  = "grade_id")
//    @NotBlank(message = "Grade is Mandatory")
//    private Grade employeeGrade;
//    @OneToOne
//    @JoinColumn(name="employee_bank_account_id")
//    private BankAccount employeeBankAccountNumber;
}
