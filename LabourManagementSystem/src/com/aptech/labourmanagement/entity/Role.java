/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.entity;

/**
 *
 * @author Noi Nho
 */
public class Role {

    private int roleID;
    private String roleName;
    private boolean isLoginSystem;
    private boolean isChangePassword;
    private boolean isAccountManagement;
    private boolean isRoleFunctionManagement;
    private boolean isWorkerManagement;
    private boolean isRefersManagement;
    private boolean isSalaryGradeManagement;
    private boolean isAttendanceManagement;
    private boolean isWeeklyAttendanceReport;
    private boolean IsWeeklySalaryReport;
    private String lastError;


    /*
     * Constructor
     */
    public Role() {
    }

    public Role(int roleID, String roleName, boolean isLoginSystem, boolean isChangePassword, boolean isAccountManagement, boolean isRoleFunctionManagement, boolean isWorkerManagement, boolean isRefersManagement, boolean isSalaryGradeManagement, boolean isAttendanceManagement, boolean isWeeklyAttendanceReport, boolean IsWeeklySalaryReport) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.isLoginSystem = isLoginSystem;
        this.isChangePassword = isChangePassword;
        this.isAccountManagement = isAccountManagement;
        this.isRoleFunctionManagement = isRoleFunctionManagement;
        this.isWorkerManagement = isWorkerManagement;
        this.isRefersManagement = isRefersManagement;
        this.isSalaryGradeManagement = isSalaryGradeManagement;
        this.isAttendanceManagement = isAttendanceManagement;
        this.isWeeklyAttendanceReport = isWeeklyAttendanceReport;
        this.IsWeeklySalaryReport = IsWeeklySalaryReport;

    }

    /**
     * @return the roleID
     */
    public int getRoleID() {
        return roleID;
    }

    /**
     * @param roleID the roleID to set
     */
    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return the isLoginSystem
     */
    public boolean isIsLoginSystem() {
        return isLoginSystem;
    }

    /**
     * @param isLoginSystem the isLoginSystem to set
     */
    public void setIsLoginSystem(boolean isLoginSystem) {
        this.isLoginSystem = isLoginSystem;
    }

    /**
     * @return the isChangePassword
     */
    public boolean isIsChangePassword() {
        return isChangePassword;
    }

    /**
     * @param isChangePassword the isChangePassword to set
     */
    public void setIsChangePassword(boolean isChangePassword) {
        this.isChangePassword = isChangePassword;
    }

    /**
     * @return the isAccountManagement
     */
    public boolean isIsAccountManagement() {
        return isAccountManagement;
    }

    /**
     * @param isAccountManagement the isAccountManagement to set
     */
    public void setIsAccountManagement(boolean isAccountManagement) {
        this.isAccountManagement = isAccountManagement;
    }

    /**
     * @return the isRoleFunctionManagement
     */
    public boolean isIsRoleFunctionManagement() {
        return isRoleFunctionManagement;
    }

    /**
     * @param isRoleFunctionManagement the isRoleFunctionManagement to set
     */
    public void setIsRoleFunctionManagement(boolean isRoleFunctionManagement) {
        this.isRoleFunctionManagement = isRoleFunctionManagement;
    }

    /**
     * @return the isWorkerManagement
     */
    public boolean isIsWorkerManagement() {
        return isWorkerManagement;
    }

    /**
     * @param isWorkerManagement the isWorkerManagement to set
     */
    public void setIsWorkerManagement(boolean isWorkerManagement) {
        this.isWorkerManagement = isWorkerManagement;
    }

    /**
     * @return the isRefersManagement
     */
    public boolean isIsRefersManagement() {
        return isRefersManagement;
    }

    /**
     * @param isRefersManagement the isRefersManagement to set
     */
    public void setIsRefersManagement(boolean isRefersManagement) {
        this.isRefersManagement = isRefersManagement;
    }

    /**
     * @return the isSalaryGradeManagement
     */
    public boolean isIsSalaryGradeManagement() {
        return isSalaryGradeManagement;
    }

    /**
     * @param isSalaryGradeManagement the isSalaryGradeManagement to set
     */
    public void setIsSalaryGradeManagement(boolean isSalaryGradeManagement) {
        this.isSalaryGradeManagement = isSalaryGradeManagement;
    }

    /**
     * @return the isAttendanceManagement
     */
    public boolean isIsAttendanceManagement() {
        return isAttendanceManagement;
    }

    /**
     * @param isAttendanceManagement the isAttendanceManagement to set
     */
    public void setIsAttendanceManagement(boolean isAttendanceManagement) {
        this.isAttendanceManagement = isAttendanceManagement;
    }

    /**
     * @return the isWeeklyAttendanceReport
     */
    public boolean isIsWeeklyAttendanceReport() {
        return isWeeklyAttendanceReport;
    }

    /**
     * @param isWeeklyAttendanceReport the isWeeklyAttendanceReport to set
     */
    public void setIsWeeklyAttendanceReport(boolean isWeeklyAttendanceReport) {
        this.isWeeklyAttendanceReport = isWeeklyAttendanceReport;
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

    /**
     * @return the IsWeeklySalaryReport
     */
    public boolean isIsWeeklySalaryReport() {
        return IsWeeklySalaryReport;
    }

    /**
     * @param IsWeeklySalaryReport the IsWeeklySalaryReport to set
     */
    public void setIsWeeklySalaryReport(boolean IsWeeklySalaryReport) {
        this.IsWeeklySalaryReport = IsWeeklySalaryReport;
    }
}
