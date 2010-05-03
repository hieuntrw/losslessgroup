/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Account;
import com.aptech.labourmanagement.util.PassEncryption;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import util.ConfigureDB;

/**
 *
 * @author JONNY
 */
public class AccountDAO {
    private ConfigureDB db = null;
    private PassEncryption pe = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String lastError = null;


    //khai bao ca cau lenh SQL
    private final String SQL_ADD = "INSERT INTO ACCOUNT VALUES(?,?)";
    private final String SQL_DELETE = "DELETE FROM login WHERE username = ?";
    private final String SQL_READ = "SELECT * FROM ACCOUNT";
    private final String SQL_LOGIN = "SELECT * FROM ACCOUNT WHERE Username = ? AND Password = ?";
    //add new account
    /*
     * @return true or false
     * @param ac, the ac to add into Account table
     */
    public boolean addAccount(Account ac) {
        //code
        String pass = pe.encryptPass(ac.getPassword());
        con = db.getConnection();
        try {
            pst = con.prepareStatement(SQL_ADD);
            pst.setString(1, ac.getUsername());
            pst.setString(2, pass);
            //pst.setInt(3, ac.getRole());
            if(pst.executeUpdate() > 0) {
                setLastError("Add successfully!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            setLastError("SQL error!");
            db.closeConnection();
            return false;
        }
        setLastError("Add fail!");
        db.closeConnection();



        return false;
    }
    //edit account
    public boolean updateAccount(Account ac){
        ArrayList<Account> list = getAllAccount();
        for (Account s : list) {
            if (s.getAccountID() == ac.getAccountID()) {
                list.remove(s);
                list.add(ac);
                setLastError("Update success");
                return true;
            }
        }
        setLastError("Update fail!");
        return false;
    }

    //delete account
    public boolean deleteAccount(String username) {
        con = db.getConnection();
        try {
            pst = con.prepareStatement(SQL_DELETE);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst.setString(1, username);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }




    //getAccountByID
    public ArrayList<Account> getAllAccountByID(Account acc){
        ArrayList<Account> getList = new ArrayList<Account>();
        ArrayList<Account> list = getAllAccount();
        for (Account a : list) {
            if (a.getAccountID() == acc.getAccountID()) {
                getList.add(acc);
            }
        }

        return getList;
    }
    //disnableAccount

    //getAllAccount
    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> list = new ArrayList<Account>();
        con = db.getConnection();
        try {
            pst = con.prepareStatement(SQL_READ);
            rs = pst.executeQuery();
             while(rs.next()){
                 Account ac = new Account();
                 ac.setUsername(rs.getString(1));
                 ac.setPassword(rs.getString(2));
                 list.add(ac);

             }

        } catch (SQLException ex) {
            setLastError("SQL Error!");

            //Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;
    }
    //changePassword


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
