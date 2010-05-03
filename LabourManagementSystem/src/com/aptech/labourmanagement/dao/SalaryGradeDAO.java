/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.util.PassEncryption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.ConfigureDB;

/**
 *
 * @author JONNY
 */
public class SalaryGradeDAO {

    private String lastError;
    //Khai bao cac bien
    private ConfigureDB db = null;
    private PassEncryption pe = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private final String SQL_ADD = "INSERT INTO [User] VALUES(?,?)";
    private final String SQL_LOGIN = "SELECT * FROM [User] WHERE Username = ? AND Password = ?";


    
    //add new salary grade
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
