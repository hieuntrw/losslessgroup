/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.services;

import com.aptech.labourmanagement.dao.AttendanceDAO;
import com.aptech.labourmanagement.entity.Attendance;
import com.aptech.labourmanagement.entity.HourTotal;
import com.aptech.labourmanagement.entity.Shift;
import com.aptech.labourmanagement.entity.Worker;
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
     * @param at
     */
    public boolean create(Attendance at) {
        //validate at
        //check n = attendance of the labor on this date
        //if (n >=2 ) return false khong cho phep dang ki nua
        //if(n = 1) kiem tra ca da dang ki truoc co trung voi ca hien thoi ko
        //neu trung return false, da trung ca
        //neu chua thi mesage dang ki ca nay la ca them
        //if(n = 0) tao binh thuong

        if (at.validate()) {
            ArrayList<Attendance> arrAttendance = atDao.readAttendanceByDate(at.getWorkDay(), at.getWorker().getWorkerID());
            if (arrAttendance.size() < 2) {
                if (arrAttendance.size() == 1) {
                    //ckeck 2 shift
                    if (!checkShiftNested(arrAttendance.get(0).getShift(), at.getShift())) {
                        //register extra shift
                        if (atDao.create(at)) {
                            this.setLastError(atDao.getLastError());
                            return true;
                        } else {
                            this.setLastError(atDao.getLastError());
                            return false;
                        }
                    } else {
                        this.setLastError("This shift has time nested with the shift registered!");
                        return false;
                    }
                } else {
                    //register
                    if (atDao.create(at)) {
                        this.setLastError(atDao.getLastError());
                        return true;
                    } else {
                        this.setLastError(atDao.getLastError());
                        return false;
                    }
                }
            } else {
                this.setLastError("This worker register two shift this date, don't more!");
                return false;
            }
        } else {
            this.setLastError(at.getLastError());
            return false;
        }
        /*if (atDao.create(at)) {
        this.setLastError(at.getLastError());
        return true;
        } else {
        this.setLastError(at.getLastError());
        return false;
        }*/
    }

    /**
     * check shift nested
     * @param s1
     * @param s2
     * @return true or false
     */
    public boolean checkShiftNested(Shift s1, Shift s2) {
        String[] timeIn1 = s1.getTimeIn().split(":");
        String[] timeOut1 = s1.getTimeOut().split(":");
        String[] timeIn2 = s2.getTimeIn().split(":");
        String[] timeOut2 = s2.getTimeOut().split(":");

        //pareInt
        int hourIn1 = Integer.parseInt(timeIn1[0]);
        int hourOut1 = Integer.parseInt(timeOut1[0]);
        int hourIn2 = Integer.parseInt(timeIn2[0]);
        int hourOut2 = Integer.parseInt(timeOut2[0]);

        if (hourOut1 <= hourIn2) {
            return false;
        } else {
            if (hourIn1 >= hourOut2) {
                return false;
            }
        }
        //nestered
        return true;
    }

    /**
     * update attendance
     * @return true or false
     * @param at
     */
    public boolean store(Attendance at) {
        //
        if (at.validate()) {
            ArrayList<Attendance> arrAttendance = atDao.readAttendanceByDate(at.getWorkDay(), at.getWorker().getWorkerID());
            if (arrAttendance.size() == 2) {
                int index;
                if (arrAttendance.get(0).getID() == at.getID()) {
                    index = 1;

                } else {
                    index = 0;
                }
                if (!checkShiftNested(at.getShift(), arrAttendance.get(index).getShift())) {
                    if (atDao.update(at)) {
                        this.setLastError(atDao.getLastError());
                        return true;
                    } else {
                        this.setLastError(atDao.getLastError());
                        return false;
                    }
                } else {
                    this.setLastError("This shift has time nested with the shift registered!");
                    return false;
                }
            } else {
                if (atDao.update(at)) {
                    this.setLastError(atDao.getLastError());
                    return true;
                } else {
                    this.setLastError(atDao.getLastError());
                    return false;
                }
            }
        } else {
            this.setLastError(at.getLastError());
            return false;
        }
        /*if (atDao.update(at)) {
        this.setLastError(at.getLastError());
        return true;
        } else {
        this.setLastError(at.getLastError());
        return false;
        }*/

    }

   /**
    * remove attendance by attendance id
    * @param ID
    * @return true or false
    */
    public boolean remove(int ID) {
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
     * computing total weekly hours worked of each labor
     * @param date1
     * @param date2
     * @return total hour list of each labor
     */
    public ArrayList<HourTotal> computingHourTotal(Date date1, Date date2){
        ArrayList<Worker> arrWorker = atDao.readAttendanceBySomeDates(date1, date2);
        ArrayList<HourTotal> arrHourTotal = new ArrayList<HourTotal>();
        for(int i = 0; i < arrWorker.size(); i++){
            HourTotal hourTotal = new HourTotal();
            hourTotal.setWorker(arrWorker.get(i));
            hourTotal.setHourTotal(atDao.readTotalHourByWorkerID(arrWorker.get(i).getWorkerID(), date1, date2));
            arrHourTotal.add(hourTotal);
        }
        return arrHourTotal;
    }

    public ArrayList<Attendance> findAttendanceWorkerBySomeDays(int workerID,Date date1, Date date2){
        ArrayList<Attendance> listAttendance = atDao.readAttendanceOfWorkerBySomeDays(workerID, date1, date2);
        return listAttendance;
    }
}
