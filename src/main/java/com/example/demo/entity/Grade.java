package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Table
@Entity

public class Grade {
    @Id
    @GeneratedValue
    private int gradeId;
    @Column(unique = true)
    private int gradeRank;
    private String gradeName;
    private double gradeBasicSalary;
    private double gradeHouseRent;
    private double gradeMedicalAllowance;
//    @ToString.Exclude
//    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "employeeGrade", fetch = FetchType.LAZY)
//    private Set<Employee> employees;


    public Grade(int id) {
        this.gradeId = id;
    }

}
