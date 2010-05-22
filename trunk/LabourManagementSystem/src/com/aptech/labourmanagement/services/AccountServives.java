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
    private String lastError;
    AccountDAO accDao;

    public AccountServives() {
        pe = new PassEncryption();
        accDao = new AccountDAO();
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

    /**
     * @return true or false
     * @param ac the ac to insert into table Account
     */
    public boolean create(Account ac) {
        //Create instance AccountDAO
        //add account
        if (ac.validateAccount()) {
            ac.setPassword(pe.encryptPass(ac.getPassword()));
            if (!accDao.isExist(ac.getUsername())) {
                if (accDao.create(ac)) {
                    this.setLastError(accDao.getLastError());
                    return true;
                } else {
                    this.setLastError(accDao.getLastError());
                    return false;
                }
            } else {
                this.setLastError(accDao.getLastError());
                return false;
            }
        } else {
            this.setLastError(ac.getLastError());
            return false;
        }
    }

    /**
     * @return true or false
     * @param ac the ac to update to table Account
     */
    public boolean store(Account ac) {
        if (ac.validateAccount()) {
            ac.setPassword(pe.encryptPass(ac.getPassword()));
            if (accDao.update(ac)) {
                this.setLastError(accDao.getLastError());
                return true;
            } else {
                this.setLastError(accDao.getLastError());
                return false;
            }
        } else {
            this.setLastError(ac.getLastError());
            return false;
        }
    }

    /**
     * @return true or false
     * @param username the username to delete from table Account
     */
    public boolean remove(String username) {
        if (accDao.delete(username)) {
            this.setLastError(accDao.getLastError());
            return true;
        } else {
            this.setLastError(accDao.getLastError());
            return false;
        }
    }

    /**
     * get account by username
     * @param username
     * @return
     */
    public Account findByUsername(String username) {
        Account ac = accDao.readByUsername(username);
        return ac;
    }

    /**
     *@return a list account
     */
    public ArrayList<Account> findByAll() {
        ArrayList<Account> listAccount = accDao.readByAll();
        this.setLastError(accDao.getLastError());
        return listAccount;
    }

    /**
     * login system
     * @param username
     * @param password
     * @return true or false
     */
    public boolean loginSystem(String username, String password) {
        if (accDao.loginSystem(username, pe.encryptPass(password))) {
            this.setLastError(accDao.getLastError());
            return true;
        } else {
            this.setLastError(accDao.getLastError());
            return false;
        }
    }
}
