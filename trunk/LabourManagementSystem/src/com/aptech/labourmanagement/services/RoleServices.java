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
        if (role.validateRole()) {
            if (!roDao.isExist(role.getRoleName())) {
                if (roDao.create(role)) {
                    this.setLastError(roDao.getLastError());
                    return true;
                } else {
                    this.setLastError(roDao.getLastError());
                    return false;
                }
            } else {
                this.setLastError(roDao.getLastError());
                return false;
            }

        } else {
            this.setLastError(role.getLastError());
            return false;
        }

    }
    /**
     *
     * @param role
     * @return
     */
    public boolean store(Role role) {
        if (role.validateRole()) {
            if (roDao.update(role)) {
                this.setLastError(roDao.getLastError());
                return true;
            } else {
                this.setLastError(roDao.getLastError());
                return false;
            }
        } else {
            this.setLastError(role.getLastError());
            return false;
        }
    }

    /**
     *
     * @param roleName
     * @return
     */
    public boolean remove(int roleID) {
        if (roDao.delete(roleID)) {
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
    public ArrayList<Role> findRoleAll() {
        ArrayList<Role> listRole = roDao.readByAll();
        return listRole;
    }

    /**
     *
     * @param roleID
     * @return
     */
    public Role findRoleByID(int roleID) {
        Role ro = roDao.getRoleByID(roleID);
        return ro;
    }

    public Role findRoleByName(String roleName) {
        Role ro = roDao.getRoleByName(roleName);
        return ro;
    }

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
