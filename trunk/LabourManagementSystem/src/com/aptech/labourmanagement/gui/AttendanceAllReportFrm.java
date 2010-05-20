/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AttendanceAllReportFrm.java
 *
 * Created on May 19, 2010, 12:43:25 PM
 */

package com.aptech.labourmanagement.gui;

import com.aptech.labourmanagement.component.LookAndFeel;
import com.aptech.labourmanagement.component.ReportAttendanceAll;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Noi Nho
 */
public class AttendanceAllReportFrm extends javax.swing.JFrame {

    WeeklyAttendanceReportDlg war;
    /** Creates new form AttendanceAllReportFrm */
    public AttendanceAllReportFrm(WeeklyAttendanceReportDlg war) {
        initComponents();
        this.war = war;
        ReportAttendanceAll report = new ReportAttendanceAll();
        this.add(report.getEnumerationViewer(this.war.arrHoueTotal, true, this.war.dateFrom, this.war.dateTo));
        this.setSize(300, 400);
        int width = this.getWidth();
        int heigh = this.getHeight();
        int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.setBounds((screenWidth - width) / 2, (screenHeight - heigh) / 2, width, heigh);
        setIconImage(new ImageIcon(getClass().getResource("../icon/LMSIcon.png")).getImage());
        new LookAndFeel(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Attendance report all labor");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceAllReportFrm(new WeeklyAttendanceReportDlg(null, true)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
