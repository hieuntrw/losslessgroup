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

    public boolean remove(int shiftID ){
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
     *
     *
     * @return a list string
     */

     public ArrayList<String> findByName(){
          ArrayList<String> listString = siDao.readByName();
        return listString;
     }
/**
 * 
 * @param shiftID
 * @return
 */


     public Shift readByID(int shiftID){
         Shift si = siDao.readByID(shiftID);
         return si;
     }




/**
 *
 * @param shiftID
 * @return 
 */
public int findHourByID(int shiftID){
    int sum = siDao.readHourByID(shiftID);
    return sum;

}
/**
 * @param shiftName
 * @return
 */
    public boolean checkShift(String shiftName) {
        if (siDao.isExist(shiftName)) {
            this.setLastError(siDao.getLastError());
            return true;
        } else {
            this.setLastError(siDao.getLastError());
            return false;
        }
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
