/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.entity;

/**
 *
 * @author Noi Nho
 */
public class SalaryGrade {

    private int salaryGradeID;
    private String gradeName;
    private float gradeNum;
    private String lastError;

    /*
     * Constructor    
     */
    public SalaryGrade(int salaryGradeID, String gradeName, float gradeNum) {
        this.salaryGradeID = salaryGradeID;
        this.gradeName = gradeName;
        this.gradeNum = gradeNum;
        
    }

    public SalaryGrade() {
    }

    /**
     * @return the salaryGradeID
     */
    public int getSalaryGradeID() {
        return salaryGradeID;
    }

    /**
     * @param salaryGradeID the salaryGradeID to set
     */
    public void setSalaryGradeID(int salaryGradeID) {
        this.salaryGradeID = salaryGradeID;
    }

    /**
     * @return the gradeName
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * @param gradeName the gradeName to set
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    /**
     * @return the gradeNum
     */
    public float getGradeNum() {
        return gradeNum;
    }

    /**
     * @param gradeNum the gradeNum to set
     */
    public void setGradeNum(float gradeNum) {
        this.gradeNum = gradeNum;
    }

    /**
     * @return the lastError
     */
    public String getLastError() {
        return lastError;
    }

    /**
     * @param lastError the lastError to set
     */
    public void setLastError(String lastError) {
        this.lastError = lastError;
    }
    public boolean validateSalaryGrade(){
        if(this.getGradeName().length() == 0){
            this.setLastError("Grade Name can not empty");
            return false;
        }
       // if(this.getGradeNum())
        return true;
    }
}
