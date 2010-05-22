/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Account;
import com.aptech.labourmanagement.entity.Role;
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
public class AccountDAO {

    private ConfigureDB db = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String lastError;
    // SQL statements
    private final String SQL_CREATE = "INSERT INTO ACCOUNT(Username, Password, RoleID, Status) VALUES(?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE ACCOUNT set Username =?,Password=?,RoleID=?,Status=? where AccountID=?";
    private final String SQL_DELETE = "DELETE FROM ACCOUNT WHERE username =?";
    private final String SQL_READ = "SELECT * FROM ACCOUNT order by Username";
    private final String SQL_CHECK_USER = "SELECT * FROM ACCOUNT WHERE username =?";
    private final String SQL_LOGIN = "SELECT * FROM ACCOUNT WHERE Username =? AND Password =? and Status =?";

    public AccountDAO() {
        db = new ConfigureDB();
    }

    /**
     * Add new an account
     * @return true or false
     * @param ac, the ac to add into Account table
     */
    public boolean create(Account ac) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CREATE);
            pst.setString(1, ac.getUsername());
            pst.setString(2, ac.getPassword());
            pst.setInt(3, ac.getRole().getRoleID());
            pst.setBoolean(4, ac.isStatus());
            if (pst.executeUpdate() == 1) {
                setLastError("Create successfully!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            setLastError("Create fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Create fail!");
        db.closeConnection();
        return false;
    }

    /**
     * edit the account
     *@return true or false
     *@param ac, the ac to update into Account table
     */
    public boolean update(Account ac) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, ac.getUsername());
            pst.setString(2, ac.getPassword());
            pst.setInt(3, ac.getRole().getRoleID());
            pst.setBoolean(4, ac.isStatus());
            pst.setInt(5, ac.getAccountID());
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

    /**
     * delete the account
     * @return true or false
     * @param username,the username to delete account
     */
    public boolean delete(String username) {
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
        this.setLastError("Delete fail");
        db.closeConnection();
        return false;

    }

    /**
     * check the username has exist
     * @return true or false
     * @param username,the username to check account
     */
    public boolean isExist(String username) {
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
     * get account by username
     * @return account
     * @param username,the username to get account
     */
    public Account readByUsername(String username) {
        Account ac = null;
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CHECK_USER);
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                ac = new Account();
                RoleDAO roleDAO = new RoleDAO();
                ac.setAccountID(rs.getInt("AccountID"));
                ac.setUsername(rs.getString("Username"));
                ac.setPassword(rs.getString("Password"));
                ac.setRole(roleDAO.getRoleByID(rs.getInt("RoleID")));
                ac.setStatus(rs.getBoolean("Status"));
            }
            db.closeConnection();
            return ac;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("get account fail!");
            db.closeConnection();
            return null;
        }

    }

    /**
     * get all account
     *@return a list account
     */
    public ArrayList<Account> readByAll() {
        ArrayList<Account> list = new ArrayList<Account>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ);
            rs = pst.executeQuery();
            RoleDAO roleDAO = new RoleDAO();
            while (rs.next()) {
                Account ac = new Account();
                ac.setAccountID(rs.getInt("AccountID"));
                ac.setUsername(rs.getString("Username"));
                ac.setPassword(rs.getString("Password"));
                ac.setRole((Role) roleDAO.getRoleByID(rs.getInt("RoleID")));
                ac.setStatus(rs.getBoolean("Status"));
                list.add(ac);
            }
            db.closeConnection();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Get all account fail, error: " + ex.getMessage());
            db.closeConnection();
            return list;
        }
    }

    /**
     * login into system
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
            pst.setBoolean(3, true);
            rs = pst.executeQuery();
            if (rs.next()) {
                this.setLastError("Login successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Erro connection! " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Username or password wrong!");
        db.closeConnection();

        return false;
    }

    /**
     * get last error
     * @return the lassError
     */
    public String getLastError() {
        return lastError;
    }

    /**
     * set last error
     * @param lassError the lassError to set
     */
    public void setLastError(String lassError) {
        this.lastError = lassError;
    }
}
