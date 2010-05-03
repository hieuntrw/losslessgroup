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

    private String lassError;
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
