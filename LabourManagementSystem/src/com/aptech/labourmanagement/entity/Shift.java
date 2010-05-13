/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.entity;

import com.aptech.labourmanagement.component.PropertyIndex;

/**
 *
 * @author Noi Nho
 */
public class Shift implements PropertyIndex{

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

    /**
     * validate shift
     * @return true or false
     */
    public boolean validateShift() {
        if (this.getShiftName().length() == 0) {
            this.setLastError("Shift Name can not empty");
            return false;
        }
        if (this.getTimeIn().length() == 0) {
            this.setLastError("Time In can not empty");
            return false;
        }
        if (this.getTimeOut().length() == 0) {
            this.setLastError("Time Out can not empty");
            return false;
        }
        if (this.getHour() <= 0) {
            this.setLastError("Time out must be greate than time in!");
            return false;
        }
        return true;

    }

    /**
     * get hour of shift
     * @return intteger
     */
    public int getHour() {
        int hour = 0;
        String[] strIn = this.getTimeIn().split(":");
        String[] strOut = this.getTimeOut().split(":");
        int hourIn = Integer.parseInt(strIn[0]);
        int hourOut = Integer.parseInt(strOut[0]);
        hour = hourOut - hourIn;
        return hour;
    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = this.getShiftName();
                break;
            case 2:
                value = this.getTimeIn();
                break;
            case 3:
                value = this.getTimeOut();
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
