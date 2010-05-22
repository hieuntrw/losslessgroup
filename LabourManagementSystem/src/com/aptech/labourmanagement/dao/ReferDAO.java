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
import com.aptech.labourmanagement.util.ConfigureDB;

/**
 * 
 * @author Noi Nho
 */
public class ReferDAO {
    //variable declaration

    private ConfigureDB db = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String lastError = null;
    //SQL statements
    private final String SQL_CREATE = "INSERT INTO REFER(FullName,DayOfBirth,Address,WorkName,Position,ContactNumber) VALUES(?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE REFER set FullName=?,DayOfBirth=?,Address=?,WorkName=?,Position=?,ContactNumber=?  where ReferID=?";
    private final String SQL_DELETE = "DELETE FROM REFER WHERE ReferID =?";
    private final String SQL_READ_BY_ALL = "SELECT * FROM REFER order by FullName";
    private final String SQL_READ_BY_ReferID = "SELECT * FROM REFER WHERE ReferID =?";

    public ReferDAO() {
        db = new ConfigureDB();
    }

    /**
     * create new refer
     * @param re
     * @return true or false
     */
    public boolean create(Refer re) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CREATE);
            pst.setString(1, re.getFullName());
            pst.setDate(2, re.getDayOfBirth());
            pst.setString(3, re.getAddress());
            pst.setString(4, re.getWorkName());
            pst.setString(5, re.getPosition());
            pst.setString(6, re.getContactNumber());
            if (pst.executeUpdate() == 1) {
                this.setLastError("Create successfully!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReferDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Create fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Create fail!");
        db.closeConnection();
        return false;
    }

   /**
    * update the refer
    * @param re
    * @return true or false
    */
    public boolean update(Refer re) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, re.getFullName());
            pst.setDate(2, re.getDayOfBirth());
            pst.setString(3, re.getAddress());
            pst.setString(4, re.getWorkName());
            pst.setString(5, re.getPosition());
            pst.setString(6, re.getContactNumber());
            pst.setInt(7, re.getReferID());
            if (pst.executeUpdate() == 1) {
                this.setLastError("Update successfuly!");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReferDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Update fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Update fail!");
        db.closeConnection();
        return false;
    }

    /**
     * delete the refer
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

    /**
     * get refer by refer id
     * @param referID
     * @return Refer
     */
    public Refer readByID(int referID) {
        Refer refer = null;
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_BY_ReferID);
            pst.setInt(1, referID);
            rs = pst.executeQuery();
            if (rs.next()) {
                refer = new Refer();
                refer.setReferID(rs.getInt("ReferID"));
                refer.setFullName(rs.getString("FullName"));
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
     * get all refer
     * @return ArrayList<Refer>
     */
    public ArrayList<Refer> readByAll() {
        ArrayList<Refer> referList = new ArrayList<Refer>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_BY_ALL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Refer refer = new Refer();
                refer.setReferID(rs.getInt("ReferID"));
                refer.setFullName(rs.getString("FullName"));
                refer.setDayOfBirth(rs.getDate("DayOfBirth"));
                refer.setContactNumber(rs.getString("ContactNumber"));
                refer.setAddress(rs.getString("Address"));
                refer.setWorkName(rs.getString("WorkName"));
                refer.setPosition(rs.getString("Position"));
                referList.add(refer);
            }
            db.closeConnection();
            return referList;
        } catch (SQLException ex) {
            Logger.getLogger(ReferDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get refer by ReferID fail, error: " + ex.getMessage());
            db.closeConnection();
            return referList;
        }
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
