/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.entity;

import java.sql.Date;

/**
 *
 * @author Noi Nho
 */
public class Worker {

    private int workerID;
    private Refer refer;
    private String firstName;
    private String lastName;
    private String address;
    private Date dayOfBirth;
    private SalaryGrade salaryGrade;
    private String contactNumber;
    private int experience;
    private boolean isTemporaryWorker;
    private float weight;
    private float height;
    private boolean status;
    private String lassError;

    /**
     * @return the workerID
     */
    public int getWorkerID() {
        return workerID;
    }

    /**
     * @param workerID the workerID to set
     */
    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    /**
     * @return the refer
     */
    public Refer getRefer() {
        return refer;
    }

    /**
     * @param refer the refer to set
     */
    public void setRefer(Refer refer) {
        this.refer = refer;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the dayOfBirth
     */
    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    /**
     * @param dayOfBirth the dayOfBirth to set
     */
    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    /**
     * @return the salaryGrade
     */
    public SalaryGrade getSalaryGrade() {
        return salaryGrade;
    }

    /**
     * @param salaryGrade the salaryGrade to set
     */
    public void setSalaryGrade(SalaryGrade salaryGrade) {
        this.salaryGrade = salaryGrade;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * @return the experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     * @param experience the experience to set
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * @return the isTemporaryWorker
     */
    public boolean isIsTemporaryWorker() {
        return isTemporaryWorker;
    }

    /**
     * @param isTemporaryWorker the isTemporaryWorker to set
     */
    public void setIsTemporaryWorker(boolean isTemporaryWorker) {
        this.isTemporaryWorker = isTemporaryWorker;
    }

    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the lassError
     */
    public String getLassError() {
        return lassError;
    }

    /**
     * @param lassError the lassError to set
     */
    public void setLassError(String lassError) {
        this.lassError = lassError;
    }
}
