/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.dao;

import com.aptech.labourmanagement.entity.Worker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.aptech.labourmanagement.util.ConfigureDB;
import java.sql.Statement;

/**
 *
 * @author JONNY
 */
public class WorkerDAO {

    //variable declaration
    private ConfigureDB db = null;
    private Connection con = null;
    private PreparedStatement pst = null;
    private Statement st = null;
    private ResultSet rs = null;
    private String lastError;
    //SQL statements
    private final String SQL_CREATE = "INSERT INTO WORKER(ReferID,FirstName,LastName,Address,DayOfBirth,SalaryGradeID,ContactNumber,Experience,IsTemporaryWorker,Weight,Height,Status) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE WORKER set ReferID =?,FirstName =?,LastName =?,Address =?,DayOfBirth =?,SalaryGradeID =?,ContactNumber =?,Experience =?,IsTemporaryWorker =?,"
            + "Weight =?,Height =?,Status =? WHERE WorkerID=?";
    private final String SQL_DELETE = "DELETE FROM WORKER WHERE WorkerID =?";
    private final String SQL_READ_ALL = "SELECT * FROM WORKER order by FirstName, LastName";
    private final String SQL_READ_BY_WORKERID = "SELECT * FROM WORKER WHERE WorkerID =?";

    public WorkerDAO() {
        db = new ConfigureDB();
    }

    /**
     * create new worker
     * @param worker
     * @return true or false
     */
    public boolean create(Worker worker) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_CREATE);
            pst.setInt(1, worker.getRefer().getReferID());
            pst.setString(2, worker.getFirstName());
            pst.setString(3, worker.getLastName());
            pst.setString(4, worker.getAddress());
            pst.setDate(5, worker.getDayOfBirth());
            pst.setInt(6, worker.getSalaryGrade().getSalaryGradeID());
            pst.setString(7, worker.getContactNumber());
            pst.setInt(8, worker.getExperience());
            pst.setBoolean(9, worker.isIsTemporaryWorker());
            pst.setFloat(10, worker.getWeight());
            pst.setFloat(11, worker.getHeight());
            pst.setBoolean(12, worker.isStatus());
            if (pst.executeUpdate() == 1) {
                setLastError("Create successfully!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Create fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Create fail!");
        db.closeConnection();
        return false;
    }

    /**
     * update information of the worker
     * @param worker
     * @return true or false
     */
    public boolean update(Worker worker) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setInt(1, worker.getRefer().getReferID());
            pst.setString(2, worker.getFirstName());
            pst.setString(3, worker.getLastName());
            pst.setString(4, worker.getAddress());
            pst.setDate(5, worker.getDayOfBirth());
            pst.setInt(6, worker.getSalaryGrade().getSalaryGradeID());
            pst.setString(7, worker.getContactNumber());
            pst.setInt(8, worker.getExperience());
            pst.setBoolean(9, worker.isIsTemporaryWorker());
            pst.setFloat(10, worker.getWeight());
            pst.setFloat(11, worker.getHeight());
            pst.setBoolean(12, worker.isStatus());
            pst.setInt(13, worker.getWorkerID());
            if (pst.executeUpdate() == 1) {
                this.setLastError("Update successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Update fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        setLastError("Update fail!");
        db.closeConnection();
        return false;
    }

    /**
     * delete the worker
     * @param workerID
     * @return true or false
     */
    public boolean delete(int workerID) {
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, workerID);
            if (pst.executeUpdate() == 1) {
                this.setLastError("Delete successfuly!");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Delete fail, error: " + ex.getMessage());
            db.closeConnection();
            return false;
        }
        this.setLastError("Delete fail");
        db.closeConnection();
        return false;
    }

    /**
     * get worker list
     * @return ArrayList<Worker>
     */
    public ArrayList<Worker> readByAll() {
        ArrayList<Worker> listWorker = new ArrayList<Worker>();
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_ALL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Worker w = new Worker();
                w.setWorkerID(rs.getInt("WorkerID"));
                ReferDAO referDAO = new ReferDAO();
                w.setRefer(referDAO.readByID(rs.getInt("ReferID")));
                w.setFirstName(rs.getString("FirstName"));
                w.setLastName(rs.getString("LastName"));
                w.setAddress(rs.getString("Address"));
                w.setDayOfBirth(rs.getDate("DayOfBirth"));
                SalaryGradeDAO sgDAO = new SalaryGradeDAO();
                w.setSalaryGrade(sgDAO.readByID(rs.getInt("SalaryGradeID")));
                w.setContactNumber(rs.getString("ContactNumber"));
                w.setExperience(rs.getInt("Experience"));
                w.setIsTemporaryWorker(rs.getBoolean("IsTemporaryWorker"));
                w.setWeight(rs.getFloat("Weight"));
                w.setHeight(rs.getFloat("Height"));
                w.setStatus(rs.getBoolean("Status"));
                listWorker.add(w);
            }
            db.closeConnection();
            return listWorker;
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDAO.class.getName()).log(Level.SEVERE, null, ex);
            setLastError("Get all worker fail, error: " + ex.getMessage());
            db.closeConnection();
            return listWorker;
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
     * read worker by id
     * @param workerID
     * @return Worker
     */
    public Worker readByID(int workerID) {
        Worker w = null;
        try {
            con = db.getConnection();
            pst = con.prepareStatement(SQL_READ_BY_WORKERID);
            pst.setInt(1, workerID);
            rs = pst.executeQuery();
            if (rs.next()) {
                w = new Worker();
                w.setWorkerID(rs.getInt("WorkerID"));
                ReferDAO referDAO = new ReferDAO();
                w.setRefer(referDAO.readByID(rs.getInt("ReferID")));
                w.setFirstName(rs.getString("FirstName"));
                w.setLastName(rs.getString("LastName"));
                w.setAddress(rs.getString("Address"));
                w.setDayOfBirth(rs.getDate("DayOfBirth"));
                SalaryGradeDAO sgDAO = new SalaryGradeDAO();
                w.setSalaryGrade(sgDAO.readByID(rs.getInt("SalaryGradeID")));
                w.setContactNumber(rs.getString("ContactNumber"));
                w.setExperience(rs.getInt("Experience"));
                w.setIsTemporaryWorker(rs.getBoolean("IsTemporaryWorker"));
                w.setWeight(rs.getFloat("Weight"));
                w.setHeight(rs.getFloat("Height"));
                w.setStatus(rs.getBoolean("Status"));
            }
            db.closeConnection();
            return w;
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get worker by workerID fail, error: " + ex.getMessage());
            db.closeConnection();
            return w;
        }
    }

    /**
     * read worker list by first name
     * @param firstname
     * @return ArrayList<Worker>
     */
    public ArrayList<Worker> readByFirstName(String firstname) {
        ArrayList<Worker> arr = new ArrayList<Worker>();
        String SQL_READ_BY_FIRSTNAME;
        try {
            con = db.getConnection();
            SQL_READ_BY_FIRSTNAME = "SELECT * FROM WORKER WHERE FirstName like '%" + firstname + "%'";
            st = con.createStatement();
            rs = st.executeQuery(SQL_READ_BY_FIRSTNAME);
            while (rs.next()) {
                Worker w = new Worker();
                w.setWorkerID(rs.getInt("WorkerID"));
                ReferDAO referDAO = new ReferDAO();
                w.setRefer(referDAO.readByID(rs.getInt("ReferID")));
                w.setFirstName(rs.getString("FirstName"));
                w.setLastName(rs.getString("LastName"));
                w.setAddress(rs.getString("Address"));
                w.setDayOfBirth(rs.getDate("DayOfBirth"));
                SalaryGradeDAO sgDAO = new SalaryGradeDAO();
                w.setSalaryGrade(sgDAO.readByID(rs.getInt("SalaryGradeID")));
                w.setContactNumber(rs.getString("ContactNumber"));
                w.setExperience(rs.getInt("Experience"));
                w.setIsTemporaryWorker(rs.getBoolean("IsTemporaryWorker"));
                w.setWeight(rs.getFloat("Weight"));
                w.setHeight(rs.getFloat("Height"));
                w.setStatus(rs.getBoolean("Status"));
                arr.add(w);
            }
            db.closeConnection();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get worker by workerID fail, error: " + ex.getMessage());
            db.closeConnection();
            return arr;
        }
    }

    /**
     * read worker list by last name
     * @param lastname
     * @return ArrayList<Worker>
     */
    public ArrayList<Worker> readByLastName(String lastname) {
        ArrayList<Worker> arr = new ArrayList<Worker>();
        String SQL_READ_BY_LASTNAME;
        try {
            con = db.getConnection();
            SQL_READ_BY_LASTNAME = "SELECT * FROM WORKER WHERE LastName like '%" + lastname + "%'";
            st = con.createStatement();
            rs = st.executeQuery(SQL_READ_BY_LASTNAME);
            while (rs.next()) {
                Worker w = new Worker();
                w.setWorkerID(rs.getInt("WorkerID"));
                ReferDAO referDAO = new ReferDAO();
                w.setRefer(referDAO.readByID(rs.getInt("ReferID")));
                w.setFirstName(rs.getString("FirstName"));
                w.setLastName(rs.getString("LastName"));
                w.setAddress(rs.getString("Address"));
                w.setDayOfBirth(rs.getDate("DayOfBirth"));
                SalaryGradeDAO sgDAO = new SalaryGradeDAO();
                w.setSalaryGrade(sgDAO.readByID(rs.getInt("SalaryGradeID")));
                w.setContactNumber(rs.getString("ContactNumber"));
                w.setExperience(rs.getInt("Experience"));
                w.setIsTemporaryWorker(rs.getBoolean("IsTemporaryWorker"));
                w.setWeight(rs.getFloat("Weight"));
                w.setHeight(rs.getFloat("Height"));
                w.setStatus(rs.getBoolean("Status"));
                arr.add(w);
            }
            db.closeConnection();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDAO.class.getName()).log(Level.SEVERE, null, ex);
            this.setLastError("Get worker by workerID fail, error: " + ex.getMessage());
            db.closeConnection();
            return arr;
        }
    }

    /**
     * set last error
     * @param lastError the lastError to set
     */
    public void setLastError(String lastError) {
        this.lastError = lastError;
    }
}
