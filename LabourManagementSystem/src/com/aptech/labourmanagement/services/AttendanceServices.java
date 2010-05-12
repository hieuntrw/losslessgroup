/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.services;

import com.aptech.labourmanagement.dao.AttendanceDAO;
import com.aptech.labourmanagement.entity.Attendance;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Noi Nho
 */
public class AttendanceServices {

    private String LastError;
    AttendanceDAO atDao;

    public AttendanceServices() {
        atDao = new AttendanceDAO();

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

    /**
     * @return true or false
     * @param at the ac to insert into table Attendance
     */
    public boolean create(Attendance at) {
        if (atDao.create(at)) {
            this.setLastError(at.getLastError());
            return true;
        } else {
            this.setLastError(at.getLastError());
            return false;
        }
    }

    /**
     * @return true or false
     * @param at the ac to insert into table Attendance
     */
    public boolean update(Attendance at) {
        if (atDao.update(at)) {
            this.setLastError(at.getLastError());
            return true;
        } else {
            this.setLastError(at.getLastError());
            return false;
        }
    }

    /**
     * @return true or false
     * @param at the ac to insert into table Attendance
     */
    public boolean delete(int ID) {
        if (atDao.delete(ID)) {
            this.setLastError(atDao.getLastError());
            return true;
        } else {
            this.setLastError(atDao.getLastError());
            return false;
        }

    }

    /**
     *@return list Attendance by workerID
     */
    public ArrayList<Attendance> findAttendanceByWorkerID(int workerID) {
        ArrayList<Attendance> listAttendance = atDao.readAttendanceByWorkerID(workerID);
        return listAttendance;
    }

    /**
     *@return list Attendance by date
     *
     */
    public ArrayList<Attendance> findAttendanceByDate(Date date) {
        ArrayList<Attendance> listAttendance = atDao.readAttendanceByDate(date);
        return listAttendance;
    }
}