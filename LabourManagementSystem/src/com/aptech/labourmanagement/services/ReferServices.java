/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.services;

import com.aptech.labourmanagement.dao.ReferDAO;
import com.aptech.labourmanagement.entity.Refer;
import java.util.ArrayList;

/**
 *
 * @author Noi Nho
 */
public class ReferServices {

    private String LastError;
    ReferDAO reDao;

    public ReferServices() {
        reDao = new ReferDAO();
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

    /**
     * create refer 
     * @param re
     * @return true or false
     */
    public boolean create(Refer re) {
        if (re.validateRefer()) {
            if (reDao.create(re)) {
                this.setLastError(reDao.getLastError());
                return true;
            } else {
                this.setLastError(reDao.getLastError());
                return false;
            }
        }else{
            this.setLastError(re.getLastError());
            return false;
        }
    }

   /**
    * update the refer
    * @param re
    * @return true or false
    */
    public boolean store(Refer re) {
        if (re.validateRefer()) {
            if (reDao.update(re)) {
                this.setLastError(reDao.getLastError());
                return true;
            } else {
                this.setLastError(reDao.getLastError());
                return false;
            }
        }else{
            this.setLastError(re.getLastError());
            return false;
        }
    }

    /**
     * remove refer by refer id
     * @param referID
     * @return true or false
     */
    public boolean remove(int referID) {
        if (reDao.delete(referID)) {
            this.setLastError(reDao.getLastError());
            return true;
        } else {
            this.setLastError(reDao.getLastError());
            return false;
        }
    }

    /**
     *
     * @return list Refer
     */
    public ArrayList<Refer> findByAll() {
        ArrayList<Refer> listRefer = reDao.readByAll();
        return listRefer;
    }

    /**
     *
     */
    public Refer findByID(int referID) {
        Refer listRefer = reDao.readByID(referID);
        return listRefer;
    }
}
