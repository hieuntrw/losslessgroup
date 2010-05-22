/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.services;

import com.aptech.labourmanagement.dao.SalaryGradeDAO;
import com.aptech.labourmanagement.entity.SalaryGrade;
import java.util.ArrayList;

/**
 *
 * @author Noi Nho
 */
public class SalaryGradeServices {
//create, update phai validate salary grade name

    private String LastError;
    SalaryGradeDAO saDao;

    public SalaryGradeServices() {
        saDao = new SalaryGradeDAO();
    }

    /**
     * create Salary Grade
     * @param sg
     * @return true or false
     */
    public boolean create(SalaryGrade sg) {
        if (sg.validateSalaryGrade()) {
            if (!saDao.isExist(sg.getGradeName())) {
                if (saDao.create(sg)) {
                    this.setLastError(saDao.getLastError());
                    return true;
                } else {
                    this.setLastError(saDao.getLastError());
                    return false;
                }
            } else {
                this.setLastError(saDao.getLastError());
                return false;
            }
        } else {
            this.setLastError(sg.getLastError());
            return false;
        }
    }

    /**
     * update Salary Grade
     * @param sg
     * @return true or false
     */
    public boolean store(SalaryGrade sg) {
        if (sg.validateSalaryGrade()) {
            if (saDao.update(sg)) {
                this.setLastError(saDao.getLastError());
                return true;
            } else {
                this.setLastError(saDao.getLastError());
                return false;
            }
        } else {
            this.setLastError(sg.getLastError());
            return false;
        }
    }

    /**
     * remove salary grade by salry grade id
     * @param salaryGradeID
     * @return true or false
     */
    public boolean remove(int salaryGradeID) {
        if (saDao.delete(salaryGradeID)) {
            this.setLastError(saDao.getLastError());
            return true;
        } else {
            this.setLastError(saDao.getLastError());
            return false;
        }
    }

    /**
     * get salary grade by salary grade if
     * @param salaryGradeID
     * @return SalaryGrade
     */
    public SalaryGrade findByID(int salaryGradeID) {
        SalaryGrade sa = saDao.readByID(salaryGradeID);
        return sa;
    }

    /**
     * get all salary grade
     * @return ArrayList<SalaryGrade>
     */
    public ArrayList<SalaryGrade> finfByAll() {
        ArrayList<SalaryGrade> listSalaryGrade = saDao.readByAll();
        return listSalaryGrade;
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
