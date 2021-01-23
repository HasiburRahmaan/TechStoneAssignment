package com.example.demo.service;

import com.example.demo.entity.Grade;
import com.example.demo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private CompanyService companyService;


    private Grade setSalaryOfGrade(double basicSalaryOfLowestGrade, Grade grade){
        double gradeBasicSalary = basicSalaryOfLowestGrade + ( (grade.getGradeRank()-1)*5000 );
        double gradeHouseRent = gradeBasicSalary * .2;
        double gradeMedicalAllowance = gradeBasicSalary * .15;

        grade.setGradeBasicSalary( gradeBasicSalary );
        grade.setGradeHouseRent( gradeHouseRent );
        grade.setGradeMedicalAllowance( gradeMedicalAllowance );
        return grade;
    }

    public Grade createGrade(Grade grade){
        try {
            double basicSalaryOfLowestGrade = companyService.getBasicSalaryOfLowestGrade();
            grade = setSalaryOfGrade(basicSalaryOfLowestGrade, grade);
            return gradeRepository.save(grade);
        }catch (Exception e){
            System.out.print("Exception==>");
            System.out.print(e);
        }
        return grade;
    }

    public List<Grade> getAllGrade(){
        return gradeRepository.findAll();
    }

    public Grade getGradeById(int id){
        return gradeRepository.findById(id).orElse(null);
    }

    public void updateGradeSalaryIfBasicAmountOfLowestGradeIsChanged(){
        List<Grade> allGrade = gradeRepository.findAll();
        double basicSalaryOfLowestGrade = companyService.getBasicSalaryOfLowestGrade();
        for (Grade grade: allGrade) {
            grade = setSalaryOfGrade(basicSalaryOfLowestGrade, grade);
            gradeRepository.save(grade);
        }
    }



}
