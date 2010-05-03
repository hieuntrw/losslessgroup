/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

/**
 *
 * @author JONNY
 */
public class AttendanceDAO {

    private String lastError;
    //khai bao cac bien

    //add new attendance
    //edit attendance
    //delete attendance (validate edit date)
    //get all attendance by WorkerID
    //get all attendance by Work date
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
