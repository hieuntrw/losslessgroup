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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.aptech.labourmanagement.util.ConfigureDB;

/**
 * 
 * @author Noi Nho
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
    private final String SQL_READ_GRADE_NUMBER = "SELECT * FROM SalaryGrade WHERE SalaryGradeID =?";
    private final String SQL_READ_ALL = "SELECT * FROM SalaryGrade";
    private final String SQL_READ_ALL_GRADE_NAME = "SELECT * FROM SalaryGrade WHERE GradeName =?";

    public SalaryGradeDAO() {
        db = new ConfigureDB();
    }



    /**
     * add new salary grade
     * @param sg
     * @return true or false
     */
    public boolean create(SalaryGrade sg) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CREATE);
            pst.setString(1, sg.getGradeName());
            pst.setFloat(2, sg.getGradeNum());
            if (pst.executeUpdate() == 1) {
                this.setLastError("Create successfully!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaryGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Create fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Create fail!");
        db.closeConnection();
        return false;
    }

    /**
     * edit salary grade
     * @param sg
     * @return true or false
     */
    public boolean update(SalaryGrade sg) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, sg.getGradeName());
            pst.setFloat(2, sg.getGradeNum());
            pst.setInt(3, sg.getSalaryGradeID());
            if (pst.executeUpdate() == 1) {
                this.setLastError("Update successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaryGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Update fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Update fail!");
        db.closeConnection();
        return false;

    }

    /**
     * delete salary grade
     * @param salaryGradeID
     * @return true or false
     */
    public boolean delete(int salaryGradeID) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, salaryGradeID);
            if (pst.executeUpdate() == 1) {
                this.setLastError("Delete successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaryGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Delete fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Delete fail, error: ");
        db.closeConnection();
        return false;
    }

    /**
     * check grade name
     * @param gradeName
     * @return true or false
     */
    public boolean isExist(String gradeName){
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_ALL_GRADE_NAME);
            pst.setString(1, gradeName);
            rs = pst.executeQuery();
            if (rs.next()) {
                this.setLastError("Grade name has exist!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaryGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Check grade name fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Grade name is available!");
        db.closeConnection();
        return false;
    }


    /**
     * get salary grade by SalaryGradeID
     * @param salaryGradeID
     * @return float
     */
    public SalaryGrade readByID(int salaryGradeID) {
        SalaryGrade sg = null;
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_GRADE_NUMBER);
            pst.setInt(1, salaryGradeID);
            rs = pst.executeQuery();
            if (rs.next()) {
                sg = new SalaryGrade();
                sg.setSalaryGradeID(rs.getInt("SalaryGradeID"));
                sg.setGradeName(rs.getString("GradeName"));
                sg.setGradeNum(rs.getFloat("GradeNum"));
                db.closeConnection();
                return sg;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaryGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get salary grade fail, error: " + ex.getMessage());
            db.closeConnection();
            return sg;
        }
        this.setLastError("Get salary grade fail");
        db.closeConnection();
        return sg;
    }

    /**
     * get all salary grade
     * @return list Salary Grade
     */
    public ArrayList<SalaryGrade> readByAll() {
        ArrayList<SalaryGrade> listSalaryGrade = new ArrayList<SalaryGrade>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_ALL);
            rs = pst.executeQuery();
            while (rs.next()) {
                SalaryGrade sg = new SalaryGrade();
                sg.setSalaryGradeID(rs.getInt("SalaryGradeID"));
                sg.setGradeName(rs.getString("GradeName"));
                sg.setGradeNum(rs.getFloat("GradeNum"));
                listSalaryGrade.add(sg);
            }
            db.closeConnection();
            return listSalaryGrade;
        } catch (SQLException ex) {
            Logger.getLogger(SalaryGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Get all salary grade fail, error: " + ex.getMessage());
            db.closeConnection();
            return listSalaryGrade;
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
