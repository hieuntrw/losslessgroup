/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.services;

import com.aptech.labourmanagement.dao.RoleDAO;
import com.aptech.labourmanagement.entity.Role;
import java.util.ArrayList;

/**
 *
 * @author Noi Nho
 */
public class RoleServices {

    private String LastError;
    RoleDAO roDao;

    public RoleServices() {
        roDao = new RoleDAO();
    }

    /**
     *
     * @param role
     * @return
     */
    public boolean create(Role role) {
        if (roDao.create(role)) {
            this.setLastError(roDao.getLastError());
            return true;
        } else {
            this.setLastError(roDao.getLastError());
            return false;
        }
    }

    /**
     *
     * @param role
     * @return
     */
    public boolean update(Role role) {
        if (roDao.update(role)) {
            this.setLastError(roDao.getLastError());
            return true;
        } else {
            this.setLastError(roDao.getLastError());
            return false;
        }
    }

    /**
     *
     * @param roleName
     * @return
     */
    public boolean remove(String roleName) {
        if (roDao.delete(roleName)) {
            this.setLastError(roDao.getLastError());
            return true;
        } else {
            this.setLastError(roDao.getLastError());
            return false;
        }
    }

    /**
     * 
     * @return
     */
    public ArrayList<String> findRoleNameAll() {
        ArrayList<String> listString = roDao.readRoleNameAll();
        return listString;
    }

//    public Role findRoleByID(int roleID) {
//
//        return null;
//    }

    /**
     * @return the LastError
     */
    public String getLastError() {
        return LastError;
    }

    /**
     * @param LastError the LastError to set
     */
    public void setLastError(String LastError) {
        this.LastError = LastError;
    }
}
