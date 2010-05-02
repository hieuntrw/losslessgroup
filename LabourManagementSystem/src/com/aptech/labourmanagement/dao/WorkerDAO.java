/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

/**
 *
 * @author JONNY
 */
public class WorkerDAO {

    private String lassError;
    //khai bao cac bien

    //add new worker
    //edit worker: personal information
    //edit worker: family information
    //edit worker: salary grade information
    //edit worker: refer information
    //delete worker
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
