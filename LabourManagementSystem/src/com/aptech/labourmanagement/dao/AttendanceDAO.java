/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Attendance;
import com.aptech.labourmanagement.entity.Shift;
import com.aptech.labourmanagement.entity.Worker;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.aptech.labourmanagement.util.ConfigureDB;
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
    private final String SQL_READ_BY_WORKERID = "SELECT * FROM ATTENDANCE WHERE WorkerID =? order by WorkDay";
    private final String SQL_READ_BY_DATE = "SELECT * FROM ATTENDANCE WHERE WorkerID = ? and WorkDay =?";
    private final String SQL_READ_Worker_BY_SOME_DATES = "SELECT DISTINCT workerID FROM ATTENDANCE WHERE (WorkDay between ? and ?) and status = ?";
    private final String SQL_READ_TOTAL_HOUR = "SELECT ShiftID, count(*) as 'Count' FROM ATTENDANCE WHERE WorkerID =? and (WorkDay between ? and ?) and Status =? group by shiftID";
    private final String SQL_READ_ATTENDANCE_WORKER_BY_SOME_DAYS = "SELECT * FROM ATTENDANCE WHERE WorkerID =? and (WorkDay between ? and ?) order by WorkDay";

    public AttendanceDAO() {
        db = new ConfigureDB();
    }

    /**
     * create new an attendance
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
     *  update the attendance
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
     * delete the attendance
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
                at.setWorkDay(rs.getDate("WorkDay"));
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
    public ArrayList<Attendance> readAttendanceByDate(Date date, int workerID) {
        ArrayList<Attendance> listAttendance = new ArrayList<Attendance>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_BY_DATE);
            pst.setInt(1, workerID);
            pst.setDate(2, date);
            rs = pst.executeQuery();
            WorkerDAO workerDAO = new WorkerDAO();
            ShiftDAO siDao = new ShiftDAO();
            while (rs.next()) {
                Attendance at = new Attendance();
                at.setID(rs.getInt("ID"));
                at.setWorker(workerDAO.readByID(rs.getInt("WorkerID")));
                at.setWorkDay(rs.getDate("WorkDay"));
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
     * get worker list in attendace in some dates
     * @param date1
     * @param date2
     * @return worker list
     */
    public ArrayList<Worker> readAttendanceBySomeDates(Date date1, Date date2) {
        ArrayList<Worker> listWorker = new ArrayList<Worker>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_Worker_BY_SOME_DATES);
            pst.setDate(1, date1);
            pst.setDate(2, date2);
            pst.setBoolean(3, true);
            rs = pst.executeQuery();
            WorkerDAO workerDAO = new WorkerDAO();
            while (rs.next()) {
                Worker worker = new Worker();
                worker = workerDAO.readByID(rs.getInt("WorkerID"));
                listWorker.add(worker);
            }
            db.closeConnection();
            return listWorker;
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get worker in attendance by some dates fail, error: " + ex.getMessage());
            db.closeConnection();
            return listWorker;
        }
    }

    /**
     * get list attendance of the worker some days
     * @param workerID
     * @param date1
     * @param date2
     * @return list attendance
     */
    public ArrayList<Attendance> readAttendanceOfWorkerBySomeDays(int workerID, Date date1, Date date2) {
        ArrayList<Attendance> listAttendance = new ArrayList<Attendance>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_ATTENDANCE_WORKER_BY_SOME_DAYS);
            pst.setInt(1, workerID);
            pst.setDate(2, date1);
            pst.setDate(3, date2);
            rs = pst.executeQuery();
            WorkerDAO workerDAO = new WorkerDAO();
            ShiftDAO siDao = new ShiftDAO();
            while (rs.next()) {
                Attendance at = new Attendance();
                at.setID(rs.getInt("ID"));
                at.setWorker(workerDAO.readByID(rs.getInt("WorkerID")));
                at.setWorkDay(rs.getDate("WorkDay"));
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
     * computing total weekly hours worked of each labor
     * @param workerID
     * @param date1
     * @param date2
     * @return total hour
     */
    public int readTotalHourByWorkerID(int workerID, Date date1, Date date2) {
        int totalHuor = -1;
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_TOTAL_HOUR);
            pst.setInt(1, workerID);
            pst.setDate(2, date1);
            pst.setDate(3, date2);
            pst.setBoolean(4, true);
            rs = pst.executeQuery();
            ShiftDAO shiftDAO = new ShiftDAO();
            while (rs.next()) {
                Shift shift = new Shift();
                shift = shiftDAO.readByID(rs.getInt("ShiftID"));
                int totalShift = rs.getInt("Count");
                // computing total each shift
                totalHuor += shift.getHour() * totalShift;
            }
            db.closeConnection();
            return totalHuor;
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Computing total hour in attendance by some dates fail, error: " + ex.getMessage());
            db.closeConnection();
            return totalHuor;
        }
    }

    /**
     * get the last error
     * @return the lastError
     */
    public String getLastError() {
        return lastError;
    }

    /**
     * set last error
     * @param lastError the lastError to set
     */
    public void setLastError(String lastError) {
        this.lastError = lastError;
    }
}
