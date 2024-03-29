/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WeeklySalaryReportDlg.java
 *
 * Created on May 11, 2010, 4:07:50 AM
 */
package com.aptech.labourmanagement.gui;

import com.aptech.labourmanagement.component.ColumnData;
import com.aptech.labourmanagement.component.LookAndFeel;
import com.aptech.labourmanagement.component.ObjectTableModel;
import com.aptech.labourmanagement.entity.Attendance;
import com.aptech.labourmanagement.entity.HourTotal;
import com.aptech.labourmanagement.services.AttendanceServices;
import com.aptech.labourmanagement.util.CheckForm;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/**
 *
 * @author Noi Nho
 */
public class WeeklyAttendanceReportDlg extends javax.swing.JDialog {

    private AttendanceServices atSer;
    public ArrayList<Attendance> arrAttendance = new ArrayList<Attendance>();
    public ArrayList<HourTotal> arrHoueTotal = new ArrayList<HourTotal>();
    private JTable headerTable;
    private ObjectTableModel tableModel;
    int indexSelectOption;
    public Date dateFrom;
    public Date dateTo;

    /** Creates new form WeeklySalaryReportDlg */
    public WeeklyAttendanceReportDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/LMSIcon.png")).getImage());
        this.setSize(770, 625);
        this.setLocationRelativeTo(null);
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dcsFromDay = new com.toedter.calendar.JDateChooser();
        dcsToDay = new com.toedter.calendar.JDateChooser();
        lblFromDay = new javax.swing.JLabel();
        lblToDay = new javax.swing.JLabel();
        btnAttendanceReport = new javax.swing.JButton();
        lblOption = new javax.swing.JLabel();
        cbbOption = new javax.swing.JComboBox();
        txtLaborID = new javax.swing.JTextField();
        lblLaborID = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnPrint = new javax.swing.JButton();
        scrAttendance = new javax.swing.JScrollPane();
        tblAttendance = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Weekly Attendance Report");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setText("Weekly Attendance Report");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(lblTitle, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.25;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 20, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report option", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        dcsFromDay.setDateFormatString("MM/dd/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 5);
        jPanel2.add(dcsFromDay, gridBagConstraints);

        dcsToDay.setDateFormatString("MM/dd/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 5);
        jPanel2.add(dcsToDay, gridBagConstraints);

        lblFromDay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFromDay.setText("From day:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel2.add(lblFromDay, gridBagConstraints);

        lblToDay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblToDay.setText("To day:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel2.add(lblToDay, gridBagConstraints);

        btnAttendanceReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/chart.png"))); // NOI18N
        btnAttendanceReport.setText("Report");
        btnAttendanceReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendanceReportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        jPanel2.add(btnAttendanceReport, gridBagConstraints);

        lblOption.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOption.setText("Option:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel2.add(lblOption, gridBagConstraints);

        cbbOption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All labor", "One lalor" }));
        cbbOption.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbOptionItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 5);
        jPanel2.add(cbbOption, gridBagConstraints);

        txtLaborID.setColumns(10);
        txtLaborID.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 5);
        jPanel2.add(txtLaborID, gridBagConstraints);

        lblLaborID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLaborID.setText("Labor ID:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel2.add(lblLaborID, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.15;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Attendance report", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout(0, 5));

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/printer2.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.setPreferredSize(new java.awt.Dimension(85, 25));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel4.add(btnPrint);

        jPanel3.add(jPanel4, java.awt.BorderLayout.SOUTH);

        scrAttendance.setPreferredSize(new java.awt.Dimension(730, 300));

        tblAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrAttendance.setViewportView(tblAttendance);

        jPanel3.add(scrAttendance, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbOptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbOptionItemStateChanged
        txtLaborID.setText("");
        if (cbbOption.getSelectedIndex() == 0) {
            txtLaborID.setEditable(false);
        } else {
            if (cbbOption.getSelectedIndex() == 1) {
                txtLaborID.setEditable(true);
            }
        }


    }//GEN-LAST:event_cbbOptionItemStateChanged

    private void btnAttendanceReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttendanceReportActionPerformed
        indexSelectOption = cbbOption.getSelectedIndex();
        if (dcsToDay.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Date can not empty or the date is not valid!", "Warning", JOptionPane.WARNING_MESSAGE);
            dcsToDay.requestFocus();
            dcsToDay.setDate(null);
            return;
        }
        if (dcsFromDay.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Date can not empty or the date is not valid!", "Warning", JOptionPane.WARNING_MESSAGE);
            dcsFromDay.requestFocus();
            dcsFromDay.setDate(null);
            return;
        }

        Calendar ca = Calendar.getInstance();
        ca.setTime(dcsFromDay.getDate());
        dateFrom = new Date(ca.getTimeInMillis());

        ca.setTime(dcsToDay.getDate());
        dateTo = new Date(ca.getTimeInMillis());

        if (indexSelectOption == 0) {
            loadDataOnTableAllLabor(dateFrom, dateTo);
        }
        if (indexSelectOption == 1) {
            if (!CheckForm.isNumberic(txtLaborID.getText().trim())) {
                JOptionPane.showMessageDialog(this, "Labor ID must be digits!", "Warning", JOptionPane.WARNING_MESSAGE);
                txtLaborID.requestFocus();
                return;
            }
            int workerID = Integer.parseInt(txtLaborID.getText().trim());
            loadDataOnTableALabor(workerID, dateFrom, dateTo);
        }
    }//GEN-LAST:event_btnAttendanceReportActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        if (indexSelectOption == 0) {
            //report All labor
            if (arrHoueTotal.size() > 0) {
                new AttendanceAllReportFrm(this).setVisible(true);
                this.setModal(false);
            } else {
                JOptionPane.showMessageDialog(this, "Data is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        }
        if (indexSelectOption == 1) {
            //report one labor
            if (arrAttendance.size() > 0) {
                new AttendanceOneReportFrm(this).setVisible(true);
                this.setModal(false);
            } else {
                JOptionPane.showMessageDialog(this, "Data is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        }

    }//GEN-LAST:event_btnPrintActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                WeeklyAttendanceReportDlg dialog = new WeeklyAttendanceReportDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttendanceReport;
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox cbbOption;
    private com.toedter.calendar.JDateChooser dcsFromDay;
    private com.toedter.calendar.JDateChooser dcsToDay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblFromDay;
    private javax.swing.JLabel lblLaborID;
    private javax.swing.JLabel lblOption;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblToDay;
    private javax.swing.JScrollPane scrAttendance;
    private javax.swing.JTable tblAttendance;
    private javax.swing.JTextField txtLaborID;
    // End of variables declaration//GEN-END:variables

    private void loadDataOnTableAllLabor(Date dateFrom, Date dateTo) {
        atSer = new AttendanceServices();
        arrHoueTotal = atSer.computingHourTotal(dateFrom, dateTo);
        ColumnData[] columns = {
            new ColumnData("Last name", 80, SwingConstants.LEFT, 2),
            new ColumnData("First name", 50, SwingConstants.LEFT, 1),
            new ColumnData("Day of birth", 90, SwingConstants.LEFT, 3),
            new ColumnData("Total hours", 80, SwingConstants.LEFT, 5)
        };
        tableModel = new ObjectTableModel(tblAttendance, columns, arrHoueTotal);
        headerTable = tableModel.getHeaderTable();

        //tao cot stt tu dong
        headerTable.createDefaultColumnsFromModel();

        tblAttendance.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Put it in a viewport that we can control a bit
        JViewport viewport = new JViewport();

        //hien thi du lieu cot stt
        viewport.setView(headerTable);

        viewport.setPreferredSize(headerTable.getMaximumSize());

        scrAttendance.setRowHeader(viewport);
        scrAttendance.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    private void loadDataOnTableALabor(int workerID, Date dateFrom, Date dateTo) {
        atSer = new AttendanceServices();
        arrAttendance = atSer.findAttendanceWorkerBySomeDays(workerID, dateFrom, dateTo);
        ColumnData[] columns = {
            new ColumnData("First name", 50, SwingConstants.LEFT, 6),
            new ColumnData("Last name", 80, SwingConstants.LEFT, 7),
            new ColumnData("Day of birth", 90, SwingConstants.LEFT, 8),
            new ColumnData("Working day", 80, SwingConstants.LEFT, 1),
            new ColumnData("Time in", 50, SwingConstants.LEFT, 2),
            new ColumnData("Time out", 50, SwingConstants.LEFT, 3),
            new ColumnData("Is extra shift", 80, SwingConstants.CENTER, 4),
            new ColumnData("Complete", 50, SwingConstants.CENTER, 5)
        };
        tableModel = new ObjectTableModel(tblAttendance, columns, arrAttendance);
        headerTable = tableModel.getHeaderTable();

        //tao cot stt tu dong
        headerTable.createDefaultColumnsFromModel();

        tblAttendance.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Put it in a viewport that we can control a bit
        JViewport viewport = new JViewport();

        //hien thi du lieu cot stt
        viewport.setView(headerTable);

        viewport.setPreferredSize(headerTable.getMaximumSize());

        scrAttendance.setRowHeader(viewport);
        scrAttendance.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }
}
