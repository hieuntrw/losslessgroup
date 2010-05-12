/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.entity;

import com.aptech.labourmanagement.component.PropertyIndex;
import java.sql.Date;

/**
 *
 * @author Noi Nho
 */
public class Family implements PropertyIndex{

    private int familyID;
    private Worker worker;
    private String ralateName;
    private String fullName;
    private String workName;
    private Date dayOfBirth;
    private String address;
    private String lastError;

    /*
     * Constructor
     */
    public Family() {
    }

    public Family(int familyID, Worker worker, String ralateName, String fullName, String workName, Date dayOfBirth, String address) {
        this.familyID = familyID;
        this.worker = worker;
        this.ralateName = ralateName;
        this.fullName = fullName;
        this.workName = workName;
        this.dayOfBirth = dayOfBirth;
        this.address = address;

    }

    /**
     * @return the familyID
     */
    public int getFamilyID() {
        return familyID;
    }

    /**
     * @param familyID the familyID to set
     */
    public void setFamilyID(int familyID) {
        this.familyID = familyID;
    }

    /**
     * @return the worker
     */
    public Worker getWorker() {
        return worker;
    }

    /**
     * @param worker the worker to set
     */
    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    /**
     * @return the ralateName
     */
    public String getRalateName() {
        return ralateName;
    }

    /**
     * @param ralateName the ralateName to set
     */
    public void setRalateName(String ralateName) {
        this.ralateName = ralateName;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the workName
     */
    public String getWorkName() {
        return workName;
    }

    /**
     * @param workName the workName to set
     */
    public void setWorkName(String workName) {
        this.workName = workName;
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
    public boolean validateFamily(){
        if(this.getRalateName().length() == 0){
            this.setLastError("Relate Name can not empty");
            return false;
        }
        if(this.getFullName().length() == 0){
            this.setLastError("Full Name can not empty");
            return false;
        }
        return true;
    }

    public Object getPropertyValue(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPropertyValue(int index, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Class getPropertyClass(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
