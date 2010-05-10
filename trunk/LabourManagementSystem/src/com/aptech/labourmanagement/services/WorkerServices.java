/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.services;

import com.aptech.labourmanagement.dao.WorkerDAO;
import com.aptech.labourmanagement.entity.Worker;
import java.util.ArrayList;

/**
 *
 * @author Noi Nho
 */
public class WorkerServices {

    private String LastError;
    WorkerDAO woDao;

    public WorkerServices() {
        woDao = new WorkerDAO();
    }

    /**
     *
     * @param worker
     * @return
     */
    public boolean create(Worker worker) {
        if (woDao.create(worker)) {
            this.setLastError(woDao.getLastError());
            return true;
        } else {
            this.setLastError(woDao.getLastError());
            return false;
        }
    }

    /**
     * 
     * @param worker
     * @return
     */
    public boolean update(Worker worker) {
        if (woDao.update(worker)) {
            this.setLastError(woDao.getLastError());
            return true;
        } else {
            this.setLastError(woDao.getLastError());
            return false;
        }
    }

    /**
     *
     * @param workerID
     * @return
     */
    public boolean remove(int workerID) {
        if (woDao.delete(workerID)) {
            this.setLastError(woDao.getLastError());
            return true;
        } else {
            this.setLastError(woDao.getLastError());
            return false;
        }
    }

    /**
     *
     * @return list of worker
     */
    public ArrayList<Worker> findByAll() {
        ArrayList<Worker> listWorker = woDao.readByAll();
        return listWorker;
    }

    /**
     * 
     * @param workerID
     * @return
     */
    public Worker readByID(int workerID) {
        Worker wo = woDao.readByID(workerID);
        return wo;
    }

    /**
     * @return the LastError
     */
    public String getLastError() {
        return LastError;
    }

    /**
     * @param LastError the LastError to set
     */
    public void setLastError(String LastError) {
        this.LastError = LastError;
    }
}
