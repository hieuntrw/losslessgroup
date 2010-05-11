/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.entity;

import com.aptech.labourmanagement.component.PropertyIndex;

/**
 *
 * @author Noi Nho
 */
public class Account implements PropertyIndex {

    private int accountID;
    private String username;
    private String password;
    private Role role;
    private boolean status;
    private String lastError;

    /*
     * Constructor
     */
    public Account(int accountID, String username, String password, Role role, boolean status) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;

    }

    public Account() {
        setLastError("");
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
     * @return the lastError
     */
    public String getLastError() {
        return lastError;
    }

    /**
     * @param lastError, the lastError to set
     */
    public void setLastError(String lastError) {
        this.lastError = lastError;
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
    /*
     * @return true or false
     */

    public boolean validateAccount() {
        if (this.username.length() == 0) {
            this.setLastError("Username can not empty!");
            return false;
        }
        if (this.password.length() == 0) {
            this.setLastError("Password can not empty!");
            return false;
        }
        if (this.getRole() == null) {
            this.setLastError("Role can not null!");
            return false;
        }
        return true;
    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = String.valueOf(this.getAccountID());
                break;
            case 2:
                value = this.getUsername();
                break;
            case 3:
                value = this.getRole().getRoleName();
                break;
            case 4:
                if (isStatus()) {
                    value = "Yes";
                } else {
                    value = "No";
                }
        }
        return value;

    }

    public void setPropertyValue(int index, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Class getPropertyClass(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
