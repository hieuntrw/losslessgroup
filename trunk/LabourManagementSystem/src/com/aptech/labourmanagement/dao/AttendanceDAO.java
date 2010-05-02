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

    private String lassError;
    //khai bao cac bien

    //add new attendance
    //edit attendance
    //delete attendance (validate edit date)
    //get all attendance by WorkerID
    //get all attendance by Work date
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
