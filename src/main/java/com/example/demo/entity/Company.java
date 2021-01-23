package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Company {
    @Id
    @GeneratedValue
    private int id;
    private double initialBalance;
    private double basicSalaryOfLowestGrade;
}
