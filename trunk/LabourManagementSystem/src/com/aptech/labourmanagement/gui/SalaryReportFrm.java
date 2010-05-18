/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SalaryReportFrm.java
 *
 * Created on May 18, 2010, 5:44:41 PM
 */

package com.aptech.labourmanagement.gui;

import com.aptech.labourmanagement.component.ReportManager;
import com.aptech.labourmanagement.entity.HourTotal;
import java.util.ArrayList;
/**
 *
 * @author Noi Nho
 */
public class SalaryReportFrm extends javax.swing.JFrame {

    WeeklySalaryReportDlg wsr;
    /** Creates new form SalaryReportFrm */
    public SalaryReportFrm(WeeklySalaryReportDlg wsr) {
        initComponents();
        this.wsr = wsr;
        ArrayList<HourTotal> arr = new ArrayList<HourTotal>();
        arr = wsr.arrHoueTotal;
        ReportManager report = new ReportManager();        
        this.add(report.getEnumerationViewer(arr, true, wsr.dateFrom, wsr.dateTo));
        this.setSize(300, 400);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Salary Report");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalaryReportFrm(new WeeklySalaryReportDlg(null, true)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
