/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.services;

import com.aptech.labourmanagement.dao.AccountDAO;
import com.aptech.labourmanagement.entity.Account;
import com.aptech.labourmanagement.util.PassEncryption;
import java.util.ArrayList;

/**
 *
 * @author Noi Nho
 */
public class AccountServives {

    private PassEncryption pe = null;
    private String lassError;
    AccountDAO accDao;

    public AccountServives() {
        pe = new PassEncryption();
        accDao = new AccountDAO();
    }

    /**
     * @return the lassError
     */
    public String getLassError() {
        return lassError;
    }

    /**
     * @param lassError the lassError to set
     */
    public void setLassError(String lassError) {
        this.lassError = lassError;
    }

    /**
     * @return true or false
     * @param ac the ac to insert into table Account
     */
    public boolean addAccount(Account ac) {
        //acc da validate trong form!
        //Create instance AccountDAO
        //add account
        ac.setPassword(pe.encryptPass(ac.getPassword()));
        if (accDao.addAccount(ac)) {
            this.setLassError(accDao.getLastError());
            return true;
        } else {
            this.setLassError(accDao.getLastError());
            return false;
        }
    }
    /**
     * @return true or false
     * @param username the username to check from table Account
     */

    public boolean checkUsername(String username) {
        if (accDao.checkUsername(username)) {
            this.setLassError(accDao.getLastError());
            return true;
        } else {
            this.setLassError(accDao.getLastError());
            return false;
        }
    }

    /**
     * @return true or false
     * @param ac the ac to update to table Account
     */
    public boolean updateAccount(Account ac) {
        ac.setPassword(pe.encryptPass(ac.getPassword()));
        if (accDao.updateAccount(ac)) {
            this.setLassError(accDao.getLastError());
            return true;
        } else {
            this.setLassError(accDao.getLastError());
            return false;
        }
    }

    /**
     * @return true or false
     * @param username the username to delete from table Account
     */
    public boolean deleteAccount(String username) {
        if (accDao.deleteAccount(username)) {
            this.setLassError(accDao.getLastError());
            return true;
        } else {
            this.setLassError(accDao.getLastError());
            return false;
        }
    }

    /**
     * @return account
     * @param username,the username to get account
     */
    public Account getAccountByUsername(String username) {
        Account ac = accDao.getAccountByUsername(username);
        return ac;
    }

    /**
     *@return a list account
     */
    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> listAccount = accDao.getAllAccount();
        return listAccount;
    }

    /**
     * @return true or false
     * @param username, password. username, password to check
     */
    public boolean loginSystem(String username, String password) {
        if (accDao.loginSystem(username, pe.encryptPass(password))) {
            this.setLassError(accDao.getLastError());
            return true;
        } else {
            this.setLassError(accDao.getLastError());
            return false;
        }
    }
}
