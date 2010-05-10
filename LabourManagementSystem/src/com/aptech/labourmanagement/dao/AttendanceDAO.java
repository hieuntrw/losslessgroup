/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Attendance;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConfigureDB;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Noi Nho
 */
public class AttendanceDAO {

    private ConfigureDB db = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String lastError;
    // SQL statements
    private final String SQL_CREATE = "INSERT INTO ATTENDANCE(ShiftID,WorkDay,WorkerID,Status,IsExtraShift) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE ATTENDANCE set ShiftID =?,WorkDay =?,Status =?,IsExtraShift =? WHERE ID=?";
    private final String SQL_DELETE = "DELETE FROM ATTENDANCE WHERE ID =?";
    private final String SQL_READ_BY_WORKERID = "SELECT * FROM ATTENDANCE WHERE WorkerID =?";
    private final String SQL_READ_BY_DATE = "SELECT * FROM ATTENDANCE WHERE WorkDay =?";

    public AttendanceDAO() {
        db = new ConfigureDB();
    }

    /**
     * create attendance
     * @return true or false
     * @param at, the at to create into Attendance table
     */
    public boolean create(Attendance at) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CREATE);
            pst.setInt(1, at.getShift().getShiftID());
            pst.setDate(2, at.getWorkDay());
            pst.setInt(3, at.getWorker().getWorkerID());
            pst.setBoolean(4, at.isStatus());
            pst.setBoolean(5, at.isIsExtraShift());
            if (pst.executeUpdate() == 1) {
                setLastError("Create successfully!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Create fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Create fail!");
        db.closeConnection();
        return false;
    }

    /**
     *update attendance
     * @param at at to update
     * @return true or false
     */
    public boolean update(Attendance at) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setInt(1, at.getShift().getShiftID());
            pst.setDate(2, at.getWorkDay());
            pst.setBoolean(3, at.isStatus());
            pst.setBoolean(4, at.isIsExtraShift());
            pst.setInt(5, at.getID());
            if (pst.executeUpdate() == 1) {
                this.setLastError("Update successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Update fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Update fail!");
        db.closeConnection();
        return false;
    }

    /**
     * delete attendance
     * @return true or false
     * @param ID,the ID to delete Attendance
     */
    public boolean delete(int ID) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, ID);
            if (pst.executeUpdate() == 1) {
                this.setLastError("Delete successfuly!");
                db.closeConnection();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Delete fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Delete fail, error: ");
        db.closeConnection();
        return false;
    }

    /**
     * get all attendance by WorkerID
     * @param workerID
     * @return list Attendance
     */
    public ArrayList<Attendance> readAttendanceByWorkerID(int workerID) {
        ArrayList<Attendance> listAttendance = new ArrayList<Attendance>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_BY_WORKERID);
            pst.setInt(1, workerID);
            rs = pst.executeQuery();
            while (rs.next()) {
                WorkerDAO workerDAO = new WorkerDAO();
                ShiftDAO siDao = new ShiftDAO();
                Attendance at = new Attendance();
                at.setID(rs.getInt("ID"));
                at.setWorker(workerDAO.readByID(rs.getInt("WorkerID")));
                at.setWorkDay(rs.getDate("WorkerDay"));
                at.setShift(siDao.readByID(rs.getInt("ShiftID")));
                at.setStatus(rs.getBoolean("Status"));
                at.setIsExtraShift(rs.getBoolean("IsExtraShift"));

                listAttendance.add(at);
            }
            db.closeConnection();
            return listAttendance;
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get attendance by workerId fail, error: " + ex.getMessage());
            db.closeConnection();
            return listAttendance;
        }

    }

    /**
     * get all attendance by date
     * @param date
     * @return list attendance
     */
    public ArrayList<Attendance> readAttendanceByDate(Date date) {
        ArrayList<Attendance> listAttendance = new ArrayList<Attendance>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_BY_DATE);
            pst.setDate(1, date);
            rs = pst.executeQuery();
            WorkerDAO workerDAO = new WorkerDAO();
            ShiftDAO siDao = new ShiftDAO();
            while (rs.next()) {
                Attendance at = new Attendance();
                at.setID(rs.getInt("ID"));
                at.setWorker(workerDAO.readByID(rs.getInt("WorkerID")));
                at.setWorkDay(rs.getDate("WorkerDay"));
                at.setShift(siDao.readByID(rs.getInt("ShiftID")));
                at.setStatus(rs.getBoolean("Status"));
                at.setIsExtraShift(rs.getBoolean("IsExtraShift"));

                listAttendance.add(at);
            }
            db.closeConnection();
            return listAttendance;
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get attendance by workerId fail, error: " + ex.getMessage());
            db.closeConnection();
            return listAttendance;
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
