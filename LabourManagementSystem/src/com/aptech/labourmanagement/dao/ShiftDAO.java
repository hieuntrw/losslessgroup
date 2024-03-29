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
import com.aptech.labourmanagement.util.ConfigureDB;

/**
 * 
 * @author Noi Nho
 */
public class ShiftDAO {

    //variable declaration
    private ConfigureDB db = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String lastError;
    //SLQ statements
    private final String SQL_CREATE = "INSERT INTO SHIFT(ShiftName,TimeIn,TimeOut) VALUES(?,?,?)";
    private final String SQL_UPDATE = "UPDATE SHIFT set ShiftName=?,TimeIn=?,TimeOut=? WHERE ShiftID=?";
    private final String SQL_DELETE = "DELETE FROM SHIFT WHERE ShiftID =?";
    private final String SQL_READ_ALL = "SELECT * FROM SHIFT order by ShiftName";
    private final String SQL_READ_ALL_SHIFT_NAME = "SELECT ShiftName FROM SHIFT";
    private final String SQL_READ_BY_SHIFTID = "SELECT * FROM SHIFT WHERE ShiftID =?";
    private final String SQL_READ_BY_SHIFT_NAME = "SELECT * FROM SHIFT WHERE ShiftName =?";

    public ShiftDAO() {
        db = new ConfigureDB();
    }

    /**
     * create new shift
     * @param si
     * @return true or false
     */
    public boolean create(Shift si) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CREATE);
            pst.setString(1, si.getShiftName());
            pst.setString(2, si.getTimeIn());
            pst.setString(3, si.getTimeOut());
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

    /**
     * update the shift
     * @return true or false
     * @param si
     */
    public boolean update(Shift si) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, si.getShiftName());
            pst.setString(2, si.getTimeIn());
            pst.setString(3, si.getTimeOut());
            pst.setInt(4, si.getShiftID());
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

    /**
     * delete the shift
     * @return true or false
     * @param shiftID
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
        this.setLastError("Delete fail!");
        db.closeConnection();
        return false;
    }

    /**
     * get list Shift name
     * @return ArrayList<String>
     */
    public ArrayList<String> readByName() {
        ArrayList<String> listNameShift = new ArrayList<String>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_ALL_SHIFT_NAME);
            rs = pst.executeQuery();
            while (rs.next()) {
                listNameShift.add(rs.getString("ShiftName"));
            }
            db.closeConnection();
            return listNameShift;
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get all shift name fail, error: " + ex.getMessage());
            db.closeConnection();
            return listNameShift;
        }
    }

    /**
     * get all shift
     * @return ArrayList<Shift>
     */
    public ArrayList<Shift> readByAll() {
        ArrayList<Shift> list = new ArrayList<Shift>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_ALL);
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

   /**
    * read shift by shift id
    * @param shiftID
    * @return Shift
    */
    public Shift readByID(int shiftID) {
        Shift si = null;
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_BY_SHIFTID);
            pst.setInt(1, shiftID);
            rs = pst.executeQuery();
            if (rs.next()) {
                si = new Shift();
                si.setShiftID(rs.getInt("ShiftID"));
                si.setShiftName(rs.getString("ShiftName"));
                si.setTimeIn(rs.getString("TimeIn"));
                si.setTimeOut(rs.getString("TimeOut"));
            }
            db.closeConnection();
            return si;
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get shift by shiftID fail, error: " + ex.getMessage());
            db.closeConnection();
            return null;
        }
    }

    /**
     * get all shift name
     * @param shiftName
     * @return Shift
     */
    public Shift readByShiftName(String shiftName) {
        Shift si = new Shift();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_BY_SHIFT_NAME);
            pst.setString(1, shiftName);
            rs = pst.executeQuery();
            if (rs.next()) {
                si.setShiftID(rs.getInt("ShiftID"));
                si.setShiftName(rs.getString("ShiftName"));
                si.setTimeIn(rs.getString("TimeIn"));
                si.setTimeOut(rs.getString("TimeOut"));
            }
            db.closeConnection();
            return si;
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get shift by shiftID fail, error: " + ex.getMessage());
            db.closeConnection();
            return null;
        }
    }

    /**
     * read Hour By shift id
     * @param shiftID
     * @return int
     */
    public int readHourByID(int shiftID) {
        Shift si = new Shift();
        int hour = 0;
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_BY_SHIFTID);
            pst.setInt(1, shiftID);
            rs = pst.executeQuery();
            if (rs.next()) {
                si.setShiftID(rs.getInt("ShiftID"));
                si.setShiftName(rs.getString("ShiftName"));
                si.setTimeIn(rs.getString("TimeIn"));
                si.setTimeOut(rs.getString("TimeOut"));
                String[] strIn = si.getTimeIn().split(":");
                String[] strOut = si.getTimeOut().split(":");
                int hourIn = Integer.parseInt(strIn[0]);
                int hourOut = Integer.parseInt(strOut[0]);
                hour = hourOut - hourIn;
            }
            db.closeConnection();
            return hour;
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get shift by shiftID fail, error: " + ex.getMessage());
            db.closeConnection();
            return hour;
        }
    }

    /**
     * check shift name is exist
     * @param shiftName
     * @return true or false
     */
    public boolean isExist(String shiftName) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_BY_SHIFT_NAME);
            pst.setString(1, shiftName);
            rs = pst.executeQuery();
            if (rs.next()) {
                this.setLastError("Shift Name has exist!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Check shift name fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Shift Name is available!");
        db.closeConnection();
        return false;
    }

    /**
     * get the last error
     * @return the lastError
     */
    public String getLastError() {
        return lastError;
    }

    /**
     * set last error
     * @param lastError the lastError to set
     */
    public void setLastError(String lastError) {
        this.lastError = lastError;
    }
}
