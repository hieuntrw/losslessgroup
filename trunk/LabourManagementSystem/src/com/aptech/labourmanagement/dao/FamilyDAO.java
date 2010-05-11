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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.aptech.labourmanagement.util.ConfigureDB;

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
    // SQL statements
    private final String SQL_CREATE = "INSERT INTO FAMILY(WorkerID, RalateName, FullName, WorkName, DayOfBirth, Address) VALUES(?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE FAMILY set RalateName=?,FullName=? ,WorkName=?,DayOfBirth=?, Address=?  where WorkerID=?";
    private final String SQL_DELETE = "DELETE FROM FAMILY WHERE FamilyID =?";
    private final String SQL_READ = "SELECT * FROM FAMILY WHERE WorkerID =?";

    public FamilyDAO() {
        db = new ConfigureDB();
    }


    //create famlily
    /**
     * @return true or false
     * @param fa, the fa to add into Family table
     */
    public boolean create(Family fa) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CREATE);
            pst.setInt(1, fa.getWorker().getWorkerID());
            pst.setString(2, fa.getRalateName());
            pst.setString(3, fa.getFullName());
            pst.setString(4, fa.getWorkName());
            pst.setDate(5, fa.getDayOfBirth());
            pst.setString(6, fa.getAddress());
            if (pst.executeUpdate() == 1) {
                setLastError("Create successfully!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FamilyDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Create fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Create fail!");
        db.closeConnection();
        return false;
    }

    //edit
    /**
     *@return true or false
     *@param fa, the ac to update into Family table
     */
    public boolean update(Family fa) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, fa.getRalateName());
            pst.setString(2, fa.getFullName());
            pst.setString(3, fa.getWorkName());
            pst.setDate(4, fa.getDayOfBirth());
            pst.setString(5, fa.getAddress());
            if (pst.executeUpdate() == 1) {
                this.setLastError("Update successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FamilyDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean delete(int familyID) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, familyID);
            if (pst.executeUpdate() == 1) {
                this.setLastError("Delete successfuly!");
                db.closeConnection();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FamilyDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Delete fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Delete fail, error: ");
        db.closeConnection();
        return false;
    }

    //getFamilyByWorkerID
    /**
     * @param workerID
     * @return list Family
     */
    public ArrayList<Family> readFamilyByWorkerID(int workerID) {
        ArrayList<Family> listFamily = new ArrayList<Family>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ);
            pst.setInt(1, workerID);
            rs = pst.executeQuery();
            WorkerDAO workerDAO = new WorkerDAO();
            while (rs.next()) {
                Family fa = new Family();
                fa.setFamilyID(rs.getInt("FamilyID"));
                fa.setWorker(workerDAO.readByID(rs.getInt("WorkerID")));
                fa.setRalateName(rs.getString("WorkerID"));
                fa.setFullName(rs.getString("FullName"));
                fa.setWorkName(rs.getString("WorkName"));
                fa.setDayOfBirth(rs.getDate("DayOfBirth"));
                fa.setAddress(rs.getString("Address"));
                listFamily.add(fa);
            }
            db.closeConnection();
            return listFamily;
        } catch (SQLException ex) {
            Logger.getLogger(FamilyDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get family by workerId fail, error: " + ex.getMessage());
            db.closeConnection();
            return listFamily;
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
