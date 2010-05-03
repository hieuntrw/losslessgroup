/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Family;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConfigureDB;

/**
 *
 * @author JONNY
 */
public class FamilyDAO {
    
    //Khai bao ca bien
    private ConfigureDB db = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String lastError = null;

    //khai bao ca cau lenh SQL
    private final String SQL_ADD = "INSERT INTO FAMILY(FamilyID, RalateName, FullName, WorkName, DayOfBirth, Address) VALUES(?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE FAMILY set FamilyID=?,RalateName=?,FullName=? ,WorkName=?,DayOfBirth=?, Address=?  where WorkerID=?";
    private final String SQL_DELETE = "DELETE FROM Family WHERE WorkerID =?";
    private final String SQL_READ = "SELECT * FROM FAMILY";
    private final String SQL_CHECK_FAMILY = "SELECT * FROM FAMILY WHERE WorkerID =?";
    //private final String SQL_LOGIN = "SELECT * FROM FAMILY WHERE Username =? AND Password =?";
    
    //add famlily
    /**
     * @return true or false
     * @param fa, the fa to add into Family table
     */
    public boolean addFamily(Family fa) {
        //code
        //String pass = pe.encryptPass(ac.getPassword()); encrypt in services
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_ADD);
            pst.setInt(1, fa.getFamilyID());
            pst.setString(2, fa.getRalateName());
            pst.setString(3, fa.getFullName());
            pst.setString(4, fa.getWorkName());
            pst.setDate(5, fa.getDayOfBirth());
            pst.setString(6, fa.getAddress());
            if (pst.executeUpdate() == 1) {
                setLastError("Add successfully!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            setLastError("Add fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Add fail!");
        db.closeConnection();
        return false;
    }

    //edit
     /**
     *@return true or false
     *@param fa, the ac to update into Family table
     */
    public boolean updateFamily(Family fa) {
        //String pass = pe.encryptPass(ac.getPassword());encrypt in services
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setInt(1, fa.getFamilyID());
            pst.setString(2, fa.getRalateName());
            pst.setString(3, fa.getFullName());
            pst.setString(4, fa.getWorkName());
            pst.setDate(5, fa.getDayOfBirth());
            pst.setString(6, fa.getAddress());
            if (pst.executeUpdate() == 1) {
                this.setLastError("Update successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Update fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Update fail!");
        db.closeConnection();
        return false;
    }
    //delete
    /**
     * @return true or false
     * @param WorkerID,the WorkerID to delete Family
     */
    public boolean deleteFamily(Family fa, int WorkerID) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, WorkerID);
            rs = pst.executeQuery();
            rs.last();
            rs.deleteRow();
            con.close();
            this.setLastError("Delete successfuly!");
            db.closeConnection();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Delete fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
//        this.setLastError("Delete fail, error: ");
//        db.closeConnection();
//        return false;

    }
    //getFamilyByWorkerID
    

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
