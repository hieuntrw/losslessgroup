/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Shift;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConfigureDB;

/**
 *
 * @author JONNY
 */
public class ShiftDAO {

    //khai bao cac bien

    private ConfigureDB db = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String lastError = null;
    //khai bao ca cau lenh SQL
    private final String SQL_CREATE = "INSERT INTO SHIFT(shiftID, shiftName,timeIn, timeOut  ) VALUES(?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE SHIFT set FirstName=?,LastName=?,DayOfBirth=?,Address=?where shiftID=?";
    private final String SQL_DELETE = "DELETE FROM SHIFT WHERE shiftID =?";
    private final String SQL_READ = "SELECT * FROM SHIFT";

    //create new shift

    /**
     * @return true or false
     * @param si, the fa to add into Shift table
     */

     public boolean create(Shift si) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CREATE);
            pst.setInt(1, si.getShiftID());
            pst.setString(2, si.getShiftName());
            pst.setString(3, si.getTimeIn());
            pst.setString(4, si.getTimeOut());
            if (pst.executeUpdate() == 1) {
                setLastError("Create successfully!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Create fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Create fail!");
        db.closeConnection();
        return false;
    }
    //edit shift

      /**
     *@return true or false
     *@param si, the ac to update into Shift table
     */
    public boolean update(Shift si) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setInt(1, si.getShiftID());
            pst.setString(2, si.getShiftName());
            pst.setString(3, si.getTimeIn());
            pst.setString(4, si.getTimeOut());
            if (pst.executeUpdate() == 1) {
                this.setLastError("Update successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Update fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Update fail!");
        db.closeConnection();
        return false;
    }
    //delete shift

    /**
     * @return true or false
     * @param shiftID,the shiftID to delete Shift
     */
    public boolean delete(int shiftID) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, shiftID);
            if (pst.executeUpdate() == 1) {
                this.setLastError("Delete successfuly!");
                db.closeConnection();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ShiftDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Delete fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Delete fail, error: ");
        db.closeConnection();
        return false;
    }
    //get shift by shiftName
    public ArrayList<Shift> readByName(String ShiftName){
        ArrayList<Shift> getList = new ArrayList<Shift>();
        ArrayList<Shift> list = readByAll();
         for(Shift si : list) {
            if(si.getShiftName().endsWith(ShiftName)) {
                getList.add(si);
            }
        }
        return getList;
    }

    //get all shift
     public ArrayList<Shift> readByAll() {
        ArrayList<Shift> list = new ArrayList<Shift>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ);
            rs = pst.executeQuery();
            while (rs.next()) {
                Shift si = new Shift();
                si.setShiftID(rs.getInt("ShiftID"));
                si.setShiftName(rs.getString("ShiftName"));
                si.setTimeIn(rs.getString("TimeIn"));
                si.setTimeOut(rs.getString("TimeOut"));
                list.add(si);
            }
            db.closeConnection();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Get all Shift fail, error: " + ex.getMessage());
            db.closeConnection();
            return list;
        }
    }

     public Shift readByID(int ShiftID){
        Shift si = new Shift();
        //code
        return si;
    }

    /**
     * @return the lastError
     */
    public String getLastError() {
        return lastError;
    }

    /**
     * @param lastError the lastError to set
     */
    public void setLastError(String lastError) {
        this.lastError = lastError;
    }
}
