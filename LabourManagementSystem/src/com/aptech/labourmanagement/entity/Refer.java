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
public class Refer implements PropertyIndex{

    private int referID;
    private String fullName;
    private Date dayOfBirth;
    private String address;
    private String workName;
    private String position;
    private String contactNumber;
    private String lastError;

    
    /*
     * Constructor
     */
    public Refer() {
    }

    public Refer(int referID, String fullName, Date dayOfBirth, String address, String workName, String position, String contactNumber) {
        this.referID = referID;
        this.fullName = fullName;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.workName = workName;
        this.position = position;
        this.contactNumber = contactNumber;

    }



    /**
     * @return the referID
     */
    public int getReferID() {
        return referID;
    }

    /**
     * @param referID the referID to set
     */
    public void setReferID(int referID) {
        this.referID = referID;
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
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
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
    /**
     * valdate data
     * @return true or false
     */
    public boolean validateRefer(){
       if(this.getFullName().length() == 0){
            this.setLastError("Last Name can not empty");
            return false;
        }
        if(this.getAddress().length() == 0){
            this.setLastError("Address can not empty");
            return false;
        }
        return true;
        //if(this.getDayOfBirth().)
    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = this.getFullName();
                break;
            case 2:
                value = this.getDayOfBirth().toString();
                break;
            case 3:
                value = this.getPosition();
                break;
            case 4:
                value = this.getAddress();

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
