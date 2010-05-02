/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.services;

import com.aptech.labourmanagement.dao.AccountDAO;
import com.aptech.labourmanagement.entity.Account;

/**
 *
 * @author Noi Nho
 */
public class AccountServives {

    private String lassError;

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

    /*
     * @return true or false
     */
    public boolean addAccount(Account acc) {
        //acc da validate trong form!
        //Create instance AccountDAO
        //add account
        AccountDAO accDao = new AccountDAO();
        if (accDao.addAccount(acc)) {
            return true;
        } else {
            this.setLassError(accDao.getLassError());
            return false;
        }

    }
}
