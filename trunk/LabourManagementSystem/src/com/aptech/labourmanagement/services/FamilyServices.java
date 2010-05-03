/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aptech.labourmanagement.services;

import com.aptech.labourmanagement.dao.FamilyDAO;
import com.aptech.labourmanagement.entity.Family;

/**
 *
 * @author Noi Nho
 */
public class FamilyServices {
    private String LastError;
    FamilyDAO faDao;

    public FamilyServices(){
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
    public boolean addFamily(Family fa){
        if(faDao.addFamily(fa)){
            this.setLastError(fa.getLassError());
            return true;
        }else{
            this.setLastError(fa.getLassError());
            return false;
        }
    }
    
    
     /**
     * @return true or false
     * @param fa the ac to insert into table Family
     */
    public boolean updateFamily(Family fa){
        if(faDao.updateFamily(fa)){
            this.setLastError(fa.getLassError());
            return true;
        }else{
            this.setLastError(fa.getLassError());
            return false;
        }
    }
    
     /**
     * @return true or false
     * @param fa the ac to insert into table Family
     */

//    public boolean deleteFamily(Family fa ,int WorkerID){
//        if(faDao.deleteFamily(fa)){
//            this.setLastError(fa.getLassError());
//            return true;
//        }
//    }
//


}
