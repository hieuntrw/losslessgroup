/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.entity;

/**
 *
 * @author Noi Nho
 */
public class Shift {

    private int shiftID;
    private String shiftName;
    private String timeIn; // hh:mm
    private String timeOut; // hh:mm
    private String lastError;

    /*
     * Constructor
     */
    public Shift() {
    }

    public Shift(int shiftID, String shiftName, String timeIn, String timeOut) {
        this.shiftID = shiftID;
        this.shiftName = shiftName;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
       
    }

    
    /**
     * @return the shiftID
     */
    public int getShiftID() {
        return shiftID;
    }

    /**
     * @param shiftID the shiftID to set
     */
    public void setShiftID(int shiftID) {
        this.shiftID = shiftID;
    }

    /**
     * @return the shiftName
     */
    public String getShiftName() {
        return shiftName;
    }

    /**
     * @param shiftName the shiftName to set
     */
    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    /**
     * @return the timeIn
     */
    public String getTimeIn() {
        return timeIn;
    }

    /**
     * @param timeIn the timeIn to set
     */
    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    /**
     * @return the timeOut
     */
    public String getTimeOut() {
        return timeOut;
    }

    /**
     * @param timeOut the timeOut to set
     */
    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
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
}
