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
public class Attendance {

    private int ID;
    private Shift shift;
    private Date workDay;
    private Worker worker;
    private boolean status;
    private boolean isExtraShift;
    private String lastError;

    /*
     * Constructor full
     */
    public Attendance(int ID, Shift shift, Date workDay, Worker worker, boolean status, boolean isExtraShift) {
        this.ID = ID;
        this.shift = shift;
        this.workDay = workDay;
        this.worker = worker;
        this.status = status;
        this.isExtraShift = isExtraShift;
      
    }

    /*
     * Constructor 
     */

    public Attendance() {
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the shift
     */
    public Shift getShift() {
        return shift;
    }

    /**
     * @param shift the shift to set
     */
    public void setShift(Shift shift) {
        this.shift = shift;
    }

    /**
     * @return the workDay
     */
    public Date getWorkDay() {
        return workDay;
    }

    /**
     * @param workDay the workDay to set
     */
    public void setWorkDay(Date workDay) {
        this.workDay = workDay;
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
     * @return the isExtraShift
     */
    public boolean isIsExtraShift() {
        return isExtraShift;
    }

    /**
     * @param isExtraShift the isExtraShift to set
     */
    public void setIsExtraShift(boolean isExtraShift) {
        this.isExtraShift = isExtraShift;
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