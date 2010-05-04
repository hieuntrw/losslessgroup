/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Worker;

/**
 *
 * @author JONNY
 */
public class WorkerDAO {

    private String lastError;
    //khai bao cac bien

    //add new worker
    //edit worker: personal information
    //edit worker: family information
    //edit worker: salary grade information
    //edit worker: refer information
    //delete worker
    /**
     * @return the lastError
     */
    public String getLastError() {
        return lastError;
    }

    public Worker readByID(int workerID){
        Worker worker = new Worker();
        //code
        return worker;
    }
    /**
     * @param lastError the lastError to set
     */
    public void setLastError(String lastError) {
        this.lastError = lastError;
    }
}
