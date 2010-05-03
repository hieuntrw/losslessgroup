/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Account;
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
public class AccountDAO {

    private ConfigureDB db = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String lastError = null;
    
    //khai bao ca cau lenh SQL
    private final String SQL_ADD = "INSERT INTO ACCOUNT(Username, Password, RoleID,Status) VALUES(?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE ACCOUNT set Password=?,RoleID=?,Status=? where AccountID=?";
    private final String SQL_DELETE = "DELETE FROM ACCOUNT WHERE username =?";
    private final String SQL_READ = "SELECT * FROM ACCOUNT";
    private final String SQL_CHECK_USER = "SELECT * FROM ACCOUNT WHERE username =?";
    private final String SQL_LOGIN = "SELECT * FROM ACCOUNT WHERE Username =? AND Password =?";

    public AccountDAO() {
        db = new ConfigureDB();
    }

    //add new account
    /**
     * @return true or false
     * @param ac, the ac to add into Account table
     */
    public boolean addAccount(Account ac) {
        //code
        //String pass = pe.encryptPass(ac.getPassword()); encrypt in services
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_ADD);
            pst.setString(1, ac.getUsername());
            pst.setString(2, ac.getPassword());
            pst.setInt(3, ac.getRole().getRoleID());
            pst.setBoolean(4, ac.isStatus());
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

    //edit account
    /**
     *@return true or false
     *@param ac, the ac to update into Account table
     */
    public boolean updateAccount(Account ac) {
        //String pass = pe.encryptPass(ac.getPassword());encrypt in services
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, ac.getPassword());
            pst.setInt(2, ac.getRole().getRoleID());
            pst.setBoolean(3, ac.isStatus());
            pst.setInt(4, ac.getAccountID());
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

    //delete account
    /**
     * @return true or false
     * @param username,the username to delete account
     */
    public boolean deleteAccount(String username) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setString(1, username);
            if (pst.executeUpdate() == 1) {
                this.setLastError("Delete successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Delete fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Delete fail, error: ");
        db.closeConnection();
        return false;

    }

    //Check username exist
    /**
     * @return true or false
     * @param username,the username to check account
     */
    public boolean checkUsername(String username) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CHECK_USER);
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                this.setLastError("Username has exist!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Username is available!");
            db.closeConnection();
            return false;
        }
        this.setLastError("Username is available!");
        db.closeConnection();
        return false;
    }

    /**
     * @return account
     * @param username,the username to get account
     */
    public Account getAccountByUsername(String username) {
        Account ac = new Account();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CHECK_USER);
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                RoleDAO roleDAO = new RoleDAO();
                ac.setAccountID(rs.getInt("AccountID"));
                ac.setUsername(rs.getString("Username"));
                ac.setPassword(rs.getString("Password"));
                ac.setRole(roleDAO.getRoleByID(rs.getInt("RoleID")));
                ac.setStatus(rs.getBoolean("Status"));
                db.closeConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("get account fail!");
            db.closeConnection();
        }
        return ac;
    }

    //getAllAccount
    /**
     *@return a list account
     */
    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> list = new ArrayList<Account>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ);
            rs = pst.executeQuery();
            while (rs.next()) {
                RoleDAO roleDAO = new RoleDAO();
                Account ac = new Account();
                ac.setAccountID(rs.getInt("AccountID"));
                ac.setUsername(rs.getString("Username"));
                ac.setPassword(rs.getString("Password"));
                ac.setRole(roleDAO.getRoleByID(rs.getInt("RoleID")));
                ac.setStatus(rs.getBoolean("Status"));
                list.add(ac);
            }
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Get all account fail, error: " + ex.getMessage());
            db.closeConnection();
        }
        return list;
    }
//Login system
    /**
     * @return true or false
     * @param username, password. username, password to check 
     */

    public boolean loginSystem(String username, String password) {
        //String pass = pe.encryptPass(password);encrypt in services
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_LOGIN);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                this.setLastError("Login successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Username or password wrong!");
            db.closeConnection();
            return false;
        }
        this.setLastError("Username or password wrong!");
        db.closeConnection();

        return false;
    }

    /**
     * @return the lassError
     */
    public String getLastError() {
        return lastError;
    }

    /**
     * @param lassError the lassError to set
     */
    public void setLastError(String lassError) {
        this.lastError = lassError;
    }
}
