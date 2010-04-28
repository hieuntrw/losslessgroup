/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.entity;

/**
 *
 * @author Noi Nho
 */
public class Account {
    private int accountID;
    private String username;
    private String password;
    private Role role;
    private boolean status;
    private String lassError;

    /*
     * Constructor
     */

    public Account() {
        setLassError("");
    }


    /**
     * @return the accountID
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     * @param accountID, the accountID to set
     */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username, the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password, the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status, the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the lassError
     */
    public String getLassError() {
        return lassError;
    }

    /**
     * @param lassError, the lassError to set
     */
    public void setLassError(String lassError) {
        this.lassError = lassError;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }
}
