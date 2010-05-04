/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aptech.labourmanagement.services;

import com.aptech.labourmanagement.dao.ShiftDAO;
import com.aptech.labourmanagement.entity.Shift;
import java.util.ArrayList;

/**
 *
 * @author Noi Nho
 */
public class ShiftServices {
    private String LastError;
    ShiftDAO siDao;

    public ShiftServices(){
        siDao = new ShiftDAO();
    }

    /**
     * @return true or false
     * @param si the ac to insert into table Shift
     */
    public boolean create(Shift si){
        if(siDao.create(si)){
            this.setLastError(siDao.getLastError());
            return true;
        } else {
            this.setLastError(siDao.getLastError());
            return false;
        }
    }


    /**
     * @return true or false
     * @param si the ac to insert into table Shift
     */

    public boolean update(Shift si){
        if(siDao.update(si)){
            this.setLastError(siDao.getLastError());
            return true;
        } else {
            this.setLastError(siDao.getLastError());
            return false;
        }
    }


    /**
     * @return true or false
     * @param si the ac to insert into table Shift
     */

    public boolean delete(int shiftID ){
         if(siDao.delete(shiftID)){
            this.setLastError(siDao.getLastError());
            return true;
        } else {
            this.setLastError(siDao.getLastError());
            return false;
        }
    }

     /**
     *@return a list Shift
     */
    public ArrayList<Shift> findByAll() {
        ArrayList<Shift> listShift = siDao.readByAll();
        return listShift;
    }


      /**
     * @return Shift
     * @param ShiftName,the ShiftName to get Shift
     */
//    public Shift findByName(String ShiftName) {
//        Shift si = siDao.readByName(ShiftName);
//        return si;
//    }




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
