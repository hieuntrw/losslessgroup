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
     * create worker
     * @param worker
     * @return
     */
    public boolean create(Worker worker) {
        if (worker.validate()) {
            if (woDao.create(worker)) {
                this.setLastError(woDao.getLastError());
                return true;
            } else {
                this.setLastError(woDao.getLastError());
                return false;
            }
        } else {
            this.setLastError(worker.getLastError());
            return false;
        }
    }

    /**
     * update worker
     * @param worker
     * @return
     */
    public boolean store(Worker worker) {
        if (worker.validate()) {
            if (woDao.update(worker)) {
                this.setLastError(woDao.getLastError());
                return true;
            } else {
                this.setLastError(woDao.getLastError());
                return false;
            }
        } else {
            this.setLastError(worker.getLastError());
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
     * read worker list by first name
     * @param firstname
     * @return
     */
    public ArrayList<Worker> findByFirstName(String firstname) {
        ArrayList<Worker> listWorker = woDao.readByFirstName(firstname);
        return listWorker;
    }

    /**
     * read worker list by last name
     * @param firstname
     * @return
     */
    public ArrayList<Worker> findByLastName(String lastname) {
        ArrayList<Worker> listWorker = woDao.readByLastName(lastname);
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
