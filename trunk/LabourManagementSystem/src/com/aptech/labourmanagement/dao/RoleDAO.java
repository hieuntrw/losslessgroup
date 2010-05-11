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
import com.aptech.labourmanagement.util.ConfigureDB;

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
    private final String SQL_CREATE = "INSERT INTO RoleFunction(RoleName, IsAccountManagement,IsRoleManagement,"
            + "IsWorkerManagement,IsRefersManagement,IsSalaryGradeManagement,IsAttendanceManagement,IsWeeklyAttendanceReport,IsWeeklySalaryReport,IsFamilyManagement) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE RoleFunction set RoleName =?,IsAccountManagement =?,IsRoleManagement =?,"
            + "IsWorkerManagement =?,IsRefersManagement =?,IsSalaryGradeManagement =?,IsAttendanceManagement =?,IsWeeklyAttendanceReport =?,IsWeeklySalaryReport =?,IsFamilyManagement =? WHERE RoleID =?";
    private final String SQL_DELETE = "DELETE FROM RoleFunction WHERE RoleID =?";
    private final String SQL_READ = "SELECT * FROM RoleFunction WHERE RoleID =?";
    private final String SQL_IS_EXIST = "SELECT * FROM RoleFunction WHERE RoleName =?";
    private final String SQL_READ_ALL = "SELECT * FROM RoleFunction";

    public RoleDAO() {
        db = new ConfigureDB();
    }

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
            pst.setBoolean(2, role.isIsAccountManagement());
            pst.setBoolean(3, role.isIsRoleManagement());
            pst.setBoolean(4, role.isIsWorkerManagement());
            pst.setBoolean(5, role.isIsRefersManagement());
            pst.setBoolean(6, role.isIsSalaryGradeManagement());
            pst.setBoolean(7, role.isIsAttendanceManagement());
            pst.setBoolean(8, role.isIsWeeklyAttendanceReport());
            pst.setBoolean(9, role.isIsWeeklySalaryReport());
            pst.setBoolean(10, role.isIsFamilyManagement());
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
            pst.setBoolean(2, role.isIsAccountManagement());
            pst.setBoolean(3, role.isIsRoleManagement());
            pst.setBoolean(4, role.isIsWorkerManagement());
            pst.setBoolean(5, role.isIsRefersManagement());
            pst.setBoolean(6, role.isIsSalaryGradeManagement());
            pst.setBoolean(7, role.isIsAttendanceManagement());
            pst.setBoolean(8, role.isIsWeeklyAttendanceReport());
            pst.setBoolean(9, role.isIsWeeklySalaryReport());
            pst.setBoolean(10, role.isIsFamilyManagement());
            pst.setInt(11, role.getRoleID());
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

    public boolean delete(int roleID) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, roleID);
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

    /**
     * check role name
     * @param roleName
     * @return true or false
     */
    public boolean isExist(String roleName) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_IS_EXIST);
            pst.setString(1, roleName);
            rs = pst.executeQuery();
            if (rs.next()) {
                this.setLastError("Role has exist");
                db.closeConnection();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Connection error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        db.closeConnection();
        this.setLastError("Role does not exist!");
        return false;
    }

    /**
     * get all role name
     * @return role name list
     */
    public ArrayList<Role> readByAll() {
        ArrayList<Role> listRole = new ArrayList<Role>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_ALL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setRoleID(rs.getInt("RoleID"));
                role.setRoleName(rs.getString("RoleName"));
                role.setIsAccountManagement(rs.getBoolean("IsAccountManagement"));
                role.setIsRoleManagement(rs.getBoolean("IsRoleManagement"));
                role.setIsWorkerManagement(rs.getBoolean("IsWorkerManagement"));
                role.setIsRefersManagement(rs.getBoolean("IsRefersManagement"));
                role.setIsSalaryGradeManagement(rs.getBoolean("IsSalaryGradeManagement"));
                role.setIsAttendanceManagement(rs.getBoolean("IsAttendanceManagement"));
                role.setIsWeeklyAttendanceReport(rs.getBoolean("IsWeeklyAttendanceReport"));
                role.setIsWeeklySalaryReport(rs.getBoolean("IsWeeklySalaryReport"));
                role.setIsFamilyManagement(rs.getBoolean("IsFamilyManagement"));
                listRole.add(role);
            }
            db.closeConnection();
            return listRole;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get role list fail!");
            return listRole;
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
                role.setIsAccountManagement(rs.getBoolean("IsAccountManagement"));
                role.setIsRoleManagement(rs.getBoolean("IsRoleManagement"));
                role.setIsWorkerManagement(rs.getBoolean("IsWorkerManagement"));
                role.setIsRefersManagement(rs.getBoolean("IsRefersManagement"));
                role.setIsSalaryGradeManagement(rs.getBoolean("IsSalaryGradeManagement"));
                role.setIsAttendanceManagement(rs.getBoolean("IsAttendanceManagement"));
                role.setIsWeeklyAttendanceReport(rs.getBoolean("IsWeeklyAttendanceReport"));
                role.setIsWeeklySalaryReport(rs.getBoolean("IsWeeklySalaryReport"));
                role.setIsFamilyManagement(rs.getBoolean("IsFamilyManagement"));
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
     * get role by role name
     * @param roleName
     * @return Role
     */
    public Role getRoleByName(String roleName) {
        Role role = new Role();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_IS_EXIST);
            pst.setString(1, roleName);
            rs = pst.executeQuery();
            if (rs.next()) {
                role.setRoleID(rs.getInt("RoleID"));
                role.setRoleName(rs.getString("RoleName"));
                role.setIsAccountManagement(rs.getBoolean("IsAccountManagement"));
                role.setIsRoleManagement(rs.getBoolean("IsRoleManagement"));
                role.setIsWorkerManagement(rs.getBoolean("IsWorkerManagement"));
                role.setIsRefersManagement(rs.getBoolean("IsRefersManagement"));
                role.setIsSalaryGradeManagement(rs.getBoolean("IsSalaryGradeManagement"));
                role.setIsAttendanceManagement(rs.getBoolean("IsAttendanceManagement"));
                role.setIsWeeklyAttendanceReport(rs.getBoolean("IsWeeklyAttendanceReport"));
                role.setIsWeeklySalaryReport(rs.getBoolean("IsWeeklySalaryReport"));
                role.setIsFamilyManagement(rs.getBoolean("IsFamilyManagement"));
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
