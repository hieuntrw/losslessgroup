/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConfigureDB;

/**
 *
 * @author JONNY
 */
public class RoleDAO {

    private String lastError;
    //Khai bao cac bien
    private ConfigureDB db = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    // SQL statements
    private final String SQL_CREATE = "INSERT INTO RoleFunction(RoleName, IsLoginSystem, IsChangePassword,IsAccountManagement,IsRoleFunctionManagement,"
            + "IsWorkerManagement,IsRefersManagement,IsSalaryGradeManagement,IsAttendanceManagement,IsWeeklyAttendanceReport,IsWeeklyHightestLowestSalaryReport) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE RoleFunction set RoleName =?, IsLoginSystem =?, IsChangePassword =?,IsAccountManagement =?,IsRoleFunctionManagement =?"
            + "IsWorkerManagement =?,IsRefersManagement =?,IsSalaryGradeManagement =?,IsAttendanceManagement =?,IsWeeklyAttendanceReport =?,IsWeeklyHightestLowestSalaryReport =? WHERE RoleID =?";
    private final String SQL_DELETE = "DELETE FROM RoleFunction WHERE RoleName =?";
    private final String SQL_READ = "SELECT * FROM RoleFunction WHERE RoleID =?";
    private final String SQL_READ_ROLENAME = "SELECT RoleName FROM RoleFunction";

    //add new role
    /**
     * @param role
     * @return true or false
     */
    public boolean create(Role role) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CREATE);
            pst.setString(1, role.getRoleName());
            pst.setBoolean(2, role.isIsLoginSystem());
            pst.setBoolean(3, role.isIsChangePassword());
            pst.setBoolean(4, role.isIsAccountManagement());
            pst.setBoolean(5, role.isIsRoleFunctionManagement());
            pst.setBoolean(6, role.isIsWorkerManagement());
            pst.setBoolean(7, role.isIsRefersManagement());
            pst.setBoolean(8, role.isIsSalaryGradeManagement());
            pst.setBoolean(9, role.isIsAttendanceManagement());
            pst.setBoolean(10, role.isIsWeeklyAttendanceReport());
            pst.setBoolean(11, role.isIsWeeklySalaryReport());
            if (pst.executeUpdate() == 1) {
                setLastError("Create successfully!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Create fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Create fail!");
        db.closeConnection();
        return false;
    }
    //edit role

    /**
     * @param role
     * @return true or false
     */
    public boolean update(Role role) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, role.getRoleName());
            pst.setBoolean(2, role.isIsLoginSystem());
            pst.setBoolean(3, role.isIsChangePassword());
            pst.setBoolean(4, role.isIsAccountManagement());
            pst.setBoolean(5, role.isIsRoleFunctionManagement());
            pst.setBoolean(6, role.isIsWorkerManagement());
            pst.setBoolean(7, role.isIsRefersManagement());
            pst.setBoolean(8, role.isIsSalaryGradeManagement());
            pst.setBoolean(9, role.isIsAttendanceManagement());
            pst.setBoolean(10, role.isIsWeeklyAttendanceReport());
            pst.setBoolean(11, role.isIsWeeklySalaryReport());
            pst.setInt(12, role.getRoleID());
            if (pst.executeUpdate() == 1) {
                this.setLastError("Update successfuly!");
                db.closeConnection();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Update fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Update fail!");
        db.closeConnection();
        return false;
    }
    //delete role

    public boolean delete(String roleName) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setString(1, roleName);
            if (pst.executeUpdate() == 1) {
                this.setLastError("Delete successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Delete fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Delete fail");
        db.closeConnection();
        return false;
    }

    //get all role name
    /**
     *
     * @return role name list
     */
    public ArrayList<String> readRoleNameAll() {
        ArrayList<String> listRoleName = new ArrayList<String>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_ROLENAME);
            rs = pst.executeQuery();
            while (rs.next()) {
                listRoleName.add(rs.getString("RoleName"));
            }
            db.closeConnection();
            return listRoleName;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get role name list fail!");
            return listRoleName;
        }
    }

    //get role by roleID
    public Role getRoleByID(int roleID) {
        Role role = new Role();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ);
            pst.setInt(1, roleID);
            rs = pst.executeQuery();
            if (rs.next()) {
                role.setRoleID(rs.getInt("RoleID"));
                role.setRoleName(rs.getString("RoleName"));
                role.setIsLoginSystem(rs.getBoolean("IsLoginSystem"));
                role.setIsChangePassword(rs.getBoolean("IsChangePassword"));
                role.setIsAccountManagement(rs.getBoolean("IsAccountManagement"));
                role.setIsRoleFunctionManagement(rs.getBoolean("IsRoleFunctionManagement"));
                role.setIsWorkerManagement(rs.getBoolean("IsWorkerManagement"));
                role.setIsRefersManagement(rs.getBoolean("IsRefersManagement"));
                role.setIsSalaryGradeManagement(rs.getBoolean("IsSalaryGradeManagement"));
                role.setIsAttendanceManagement(rs.getBoolean("IsAttendanceManagement"));
                role.setIsWeeklyAttendanceReport(rs.getBoolean("IsWeeklyAttendanceReport"));
                role.setIsWeeklySalaryReport(rs.getBoolean("IsWeeklyHightestLowestSalaryReport"));
            }
            db.closeConnection();
            return role;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get rolefunction fail");
            return null;
        }
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
