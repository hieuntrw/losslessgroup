/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.SalaryGrade;
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
public class SalaryGradeDAO {

    private String lastError;
    //Khai bao cac bien
    private ConfigureDB db = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    //SQL
    private final String SQL_CREATE = "INSERT INTO SalaryGrade(GradeName,GradeNum) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE SalaryGrade set GradeName =?,GradeNum =? WHERE SalaryGradeID =?";
    private final String SQL_DELETE = "DELETE FROM SalaryGrade WHERE SalaryGradeID =?";
    private final String SQL_READ_ALL = "SELECT * FROM SalaryGrade";

    //add new salary grade
    public boolean create(SalaryGrade sg) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CREATE);
            pst.setString(1, sg.getGradeName());
            pst.setFloat(2, sg.getGradeNum());
            if (pst.executeUpdate() == 1) {
                setLastError("Create successfully!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaryGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Create fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Create fail!");
        db.closeConnection();
        return false;
    }

    //edit salary grade
    //delete salary grade
    //get salary grade by SalaryGradeName
    //get all salary grade
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
