/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Refer;
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
 * @author Noi Nho
 */
public class ReferDAO {
    //khai bao cac bien

    private ConfigureDB db = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String lastError = null;
    //khai bao ca cau lenh SQL
    private final String SQL_CREATE = "INSERT INTO REFER(FirstName, LastName,DayOfBirth, Address,WorkName ,Position, ContactNumber) VALUES(?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE REFER set FirstName=?,LastName=?,DayOfBirth=?,Address=?,WorkName=?,Position=?,ContactNumber=?  where ReferID=?";
    private final String SQL_DELETE = "DELETE FROM REFER WHERE ReferID =?";
    //private final String SQL_READ_BY_ALL = "SELECT * FROM REFER";
    private final String SQL_READ_BY_ReferID = "SELECT * FROM REFER WHERE ReferID =?";

    public ReferDAO() {
        db = new ConfigureDB();
    }


    /**
     * create new refer
     *@return true or false
     *@param fa, the re to update into Refer table
     */
    public boolean create(Refer re) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CREATE);
            pst.setString(1, re.getFirstName());
            pst.setString(2, re.getLastName());
            pst.setDate(3, re.getDayOfBirth());
            pst.setString(4, re.getAddress());
            pst.setString(5, re.getWorkName());
            pst.setString(6, re.getPosition());
            pst.setString(7, re.getContactNumber());
            if (pst.executeUpdate() == 1) {
                setLastError("Create successfully!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReferDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Create fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Create fail!");
        db.closeConnection();
        return false;
    }

    /**
     * update refer
     *@return true or false
     *@param fa, the ac to update into Family table
     */
    public boolean update(Refer re) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, re.getFirstName());
            pst.setString(2, re.getLastName());
            pst.setDate(3, re.getDayOfBirth());
            pst.setString(4, re.getAddress());
            pst.setString(5, re.getWorkName());
            pst.setString(6, re.getPosition());
            pst.setString(7, re.getContactNumber());
            pst.setInt(8, re.getReferID());
            if (pst.executeUpdate() == 1) {
                this.setLastError("Update successfuly!");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReferDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Update fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Update fail!");
        db.closeConnection();
        return false;
    }

    /**
     * delete refer
     * @param referID
     * @return true or false
     */
    public boolean delete(int referID) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, referID);
            if (pst.executeUpdate() == 1) {
                this.setLastError("Delete successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReferDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Delete fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Delete fail");
        db.closeConnection();
        return false;
    }

    public Refer readByID(int referID){
        Refer refer = new Refer();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_BY_ReferID);
            pst.setInt(1, referID);
            if (rs.next()) {
                refer.setReferID(rs.getInt("ReferID"));
                refer.setFirstName(rs.getString("FirstName"));
                refer.setLastName(rs.getString("LastName"));
                refer.setDayOfBirth(rs.getDate("DayOfBirth"));
                refer.setContactNumber(rs.getString("ContactNumber"));
                refer.setAddress(rs.getString("Address"));
                refer.setWorkName(rs.getString("WorkName"));
                refer.setPosition(rs.getString("Position"));
            }
            db.closeConnection();
            return refer;
        } catch (SQLException ex) {
            Logger.getLogger(ReferDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get refer by ReferID fail, error: " + ex.getMessage());
            db.closeConnection();
            return null;
        }
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
