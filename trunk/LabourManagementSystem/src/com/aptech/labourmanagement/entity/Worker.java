/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.entity;

import com.aptech.labourmanagement.component.PropertyIndex;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Noi Nho
 */
public class Worker implements PropertyIndex {

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
    private String lastError;

    /*
     * Constructor
     */
    public Worker() {
    }

    public Worker(int workerID, Refer refer, String firstName, String lastName, String address, Date dayOfBirth, SalaryGrade salaryGrade, String contactNumber, int experience, boolean isTemporaryWorker, float weight, float height, boolean status) {
        this.workerID = workerID;
        this.refer = refer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dayOfBirth = dayOfBirth;
        this.salaryGrade = salaryGrade;
        this.contactNumber = contactNumber;
        this.experience = experience;
        this.isTemporaryWorker = isTemporaryWorker;
        this.weight = weight;
        this.height = height;
        this.status = status;
    }

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

    /***
     * validate data
     * @return true or false
     */
    public boolean validate() {
        if (this.getAddress().length() == 0) {
            this.setLastError("Address can not empty");
            return false;
        }
        if (this.getContactNumber().length() == 0) {
            this.setLastError("Contact Number can not empty");
            return false;
        }
        if (this.getFirstName().length() == 0) {
            this.setLastError("First Name can not empty");
            return false;
        }
        if (this.getLastName().length() == 0) {
            this.setLastError("Last Name can not empty");
            return false;
        }
        //DayOfBirth
        //GradeSalary
        //Experience

        return true;

    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = this.getFirstName();
                break;
            case 2:
                value = this.getLastName();
                break;
            case 3:
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                value = dateFormat.format(this.getDayOfBirth());
                break;
            case 4:
                value = this.getContactNumber();
                break;
            case 5:
                value = String.valueOf(this.getSalaryGrade().getGradeNum());
                break;
            case 6:
                value = this.getRefer().getFullName();
                break;
            case 7:
                if (this.isIsTemporaryWorker()) {
                    value = "Yes";
                } else {
                    value = "No";
                }
                break;
            case 8:
                if (this.isStatus()) {
                    value = "Yes";
                } else {
                    value = "No";
                }
                break;
            case 9:
                value = this.getAddress();
                break;
            case 10:
                value = String.valueOf(this.getHeight());
                break;
            case 11:
                value = String.valueOf(this.getWeight());
                break;
            case 12:
                value = String.valueOf(this.getExperience());
                break;

        }
        return value;
    }

    public void setPropertyValue(int index, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Class getPropertyClass(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
