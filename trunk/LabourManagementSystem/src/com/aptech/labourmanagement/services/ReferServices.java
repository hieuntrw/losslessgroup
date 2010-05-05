/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aptech.labourmanagement.services;

import com.aptech.labourmanagement.dao.ReferDAO;
import com.aptech.labourmanagement.entity.Refer;

/**
 *
 * @author Noi Nho
 */
public class ReferServices {
    private String LastError;
    ReferDAO reDao;

    public ReferServices(){
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
     *@return true or false
     *@param fa, the re to update into Refer table
     */
     public boolean addRefer(Refer re){
         if(reDao.create(re)){
             this.setLastError(re.getLastError());
             return true;
         }else{
             this.setLastError(re.getLastError());
             return false;
         }
     }

      /**
     *@return true or false
     *@param fa, the ac to update into Family table
     */
    public boolean updateRefer(Refer re){
        if(reDao.update(re)){
             this.setLastError(re.getLastError());
             return true;
         }else{
             this.setLastError(re.getLastError());
             return false;
        }
    }


}
