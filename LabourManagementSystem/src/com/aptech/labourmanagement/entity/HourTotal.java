/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.entity;

import com.aptech.labourmanagement.component.PropertyIndex;
import java.text.SimpleDateFormat;

/**
 * for attendance report
 * @author Noi Nho
 */
public class HourTotal implements PropertyIndex {

    private Worker worker;
    private int hourTotal;

    /**
     * @return the worker
     */
    public Worker getWorker() {
        return worker;
    }

    /**
     * @param worker the worker to set
     */
    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    /**
     * @return the hourTotal
     */
    public int getHourTotal() {
        return hourTotal;
    }

    /**
     * @param hourTotal the hourTotal to set
     */
    public void setHourTotal(int hourTotal) {
        this.hourTotal = hourTotal;
    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = this.getWorker().getFirstName();
                break;
            case 2:
                value = this.getWorker().getLastName();
                break;
            case 3:
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                value = dateFormat.format(this.getWorker().getDayOfBirth());
                break;
            case 4:
                value = String.valueOf(this.getWorker().getSalaryGrade().getGradeNum());
                break;
            case 5:
                value = String.valueOf(this.getHourTotal());
                break;
            case 6:
                float salary = this.getWorker().getSalaryGrade().getGradeNum() * this.getHourTotal();
                value = String.valueOf(salary);
                break;
        }
        return value;
    }

    public void setPropertyValue(int index, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Class getPropertyClass(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
