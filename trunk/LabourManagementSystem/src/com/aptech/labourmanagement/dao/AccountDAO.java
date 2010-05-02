/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Account;

/**
 *
 * @author JONNY
 */
public class AccountDAO {

    private String lassError;

    //khai bao ca cau lenh SQL

    //add new account
    /*
     * @return true or false
     * @param ac, the ac to add into Account table
     */
    public boolean addAccount(Account ac) {
        //code
        return false;
    }
    //edit account
    //delete account
    //getAccountByID
    //disnableAccount
    //getAllAccount
    //changePassword

    
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
}
