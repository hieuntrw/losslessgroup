/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.services;

import com.aptech.labourmanagement.dao.FamilyDAO;
import com.aptech.labourmanagement.entity.Family;
import java.util.ArrayList;

/**
 *
 * @author Noi Nho
 */
public class FamilyServices {

    private String LastError;
    FamilyDAO faDao;

    public FamilyServices() {
        faDao = new FamilyDAO();
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
     * @return true or false
     * @param fa the ac to insert into table Family
     */
    public boolean create(Family fa) {
        if (faDao.create(fa)) {
            this.setLastError(fa.getLastError());
            return true;
        } else {
            this.setLastError(fa.getLastError());
            return false;
        }
    }

    /**
     * @return true or false
     * @param fa the ac to insert into table Family
     */
    public boolean update(Family fa) {
        if (faDao.update(fa)) {
            this.setLastError(fa.getLastError());
            return true;
        } else {
            this.setLastError(fa.getLastError());
            return false;
        }
    }

    /**
     * @return true or false
     * @param fa the ac to insert into table Family
     */
    public boolean remove(int familyID) {
        if (faDao.delete(familyID)) {
            this.setLastError(faDao.getLastError());
            return true;
        } else {
            this.setLastError(faDao.getLastError());
            return false;
        }
    }
    
    /**
     * @return list Family by workerID
     */

    public ArrayList<Family> findFamilyByWorkerID(int workerID){
        ArrayList<Family> listFamily = faDao.readFamilyByWorkerID(workerID);
        return listFamily;
    }

   


}
