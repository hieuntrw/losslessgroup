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
     * create new role
     * @param role
     * @return true or false
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
     * update role
     * @param role
     * @return true or false
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
     * remove role by role id
     * @param roleID
     * @return true or false
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
     * get all role
     * @return ArrayList<Role>
     */
    public ArrayList<Role> findRoleAll() {
        ArrayList<Role> listRole = roDao.readByAll();
        return listRole;
    }

    /**
     * get role by role id
     * @param roleID
     * @return Role
     */
    public Role findRoleByID(int roleID) {
        Role ro = roDao.getRoleByID(roleID);
        return ro;
    }

    /**
     * get role by role name
     * @param roleName
     * @return Role
     */
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
