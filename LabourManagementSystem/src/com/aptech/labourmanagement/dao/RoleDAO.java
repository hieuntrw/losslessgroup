/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Role;

/**
 *
 * @author JONNY
 */
public class RoleDAO {

    private String lastError;
    //Khai bao cac bien

    //add new role
    //edit role
    //delete role
    //get role by RoleID
    //get all role

    public Role getRoleByID(int roleID){
        Role role = new Role();
        //code
        return role;
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
}
