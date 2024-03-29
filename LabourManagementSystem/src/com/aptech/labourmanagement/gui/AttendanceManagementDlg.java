/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FamilyRalateManagement.java
 *
 * Created on May 10, 2010, 1:12:52 PM
 */
package com.aptech.labourmanagement.gui;

import com.aptech.labourmanagement.component.ColumnData;
import com.aptech.labourmanagement.component.LookAndFeel;
import com.aptech.labourmanagement.component.ObjectTableModel;
import com.aptech.labourmanagement.entity.Attendance;
import com.aptech.labourmanagement.entity.Shift;
import com.aptech.labourmanagement.entity.Worker;
import com.aptech.labourmanagement.services.AttendanceServices;
import com.aptech.labourmanagement.services.ShiftServices;
import com.aptech.labourmanagement.services.WorkerServices;
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
public class AttendanceManagementDlg extends javax.swing.JDialog {

    private WorkerServices workerSer;
    private AttendanceServices attendanceSer;
    private ObjectTableModel tableModel;
    private ArrayList<Attendance> arrAttendance = new ArrayList<Attendance>();
    private ArrayList<Worker> arrWorker = new ArrayList<Worker>();
    private ArrayList<Shift> arrShift = new ArrayList<Shift>();
    //contains information header of columns
    private JTable headerTable;
    //index selected in table
    int indexLabor = -1;
    int indexAttendance = -1;
    int indexSelectShiftName = 0;
    int selection;

    /** Creates new form FamilyRalateManagement */
    public AttendanceManagementDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/LMSIcon.png")).getImage());
        this.setSize(860, 660);
        this.setLocationRelativeTo(null);
        new LookAndFeel(this);
        dcsWorkDate.setDate(new java.util.Date());
        loadDataOnLaborTable();
        loadDataOnCbbShiftName();
        disableFields();
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

        pnlAttendanceInfor = new javax.swing.JPanel();
        lblFirstlName = new javax.swing.JLabel();
        lblDayOfBirth = new javax.swing.JLabel();
        lblShiftName = new javax.swing.JLabel();
        lblTimeOut = new javax.swing.JLabel();
        lblLastname = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        dcsDayOfBirth = new com.toedter.calendar.JDateChooser();
        cbbShiftName = new javax.swing.JComboBox();
        txtTimeOut = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblTimeIn = new javax.swing.JLabel();
        lblWorkDate = new javax.swing.JLabel();
        txtTimeIn = new javax.swing.JTextField();
        ckbIsExtraShift = new javax.swing.JCheckBox();
        ckbComplete = new javax.swing.JCheckBox();
        dcsWorkDate = new com.toedter.calendar.JDateChooser();
        pnlAttendanceList = new javax.swing.JPanel();
        scrAttendance = new javax.swing.JScrollPane();
        tblAttendance = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnTimekeeping = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        pnlLaborList = new javax.swing.JPanel();
        scrWorker = new javax.swing.JScrollPane();
        tblWorker = new javax.swing.JTable();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Attendance Management");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlAttendanceInfor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Attendance information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlAttendanceInfor.setLayout(new java.awt.GridBagLayout());

        lblFirstlName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFirstlName.setText("Firstl name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(lblFirstlName, gridBagConstraints);

        lblDayOfBirth.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDayOfBirth.setText("Day of birth:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(lblDayOfBirth, gridBagConstraints);

        lblShiftName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblShiftName.setText("Shift name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(lblShiftName, gridBagConstraints);

        lblTimeOut.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTimeOut.setText("Time out:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(lblTimeOut, gridBagConstraints);

        lblLastname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLastname.setText("Last name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(lblLastname, gridBagConstraints);

        txtFirstName.setColumns(20);
        txtFirstName.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(txtFirstName, gridBagConstraints);

        dcsDayOfBirth.setDateFormatString("MM/dd/yyyy");
        dcsDayOfBirth.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(dcsDayOfBirth, gridBagConstraints);

        cbbShiftName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbShiftNameItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(cbbShiftName, gridBagConstraints);

        txtTimeOut.setColumns(7);
        txtTimeOut.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(txtTimeOut, gridBagConstraints);

        txtLastName.setColumns(20);
        txtLastName.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(txtLastName, gridBagConstraints);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/check.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/delete.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(jPanel2, gridBagConstraints);

        lblTimeIn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTimeIn.setText("Time In:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(lblTimeIn, gridBagConstraints);

        lblWorkDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWorkDate.setText("Work date:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(lblWorkDate, gridBagConstraints);

        txtTimeIn.setColumns(7);
        txtTimeIn.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(txtTimeIn, gridBagConstraints);

        ckbIsExtraShift.setText("Is extra shift");
        ckbIsExtraShift.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(ckbIsExtraShift, gridBagConstraints);

        ckbComplete.setSelected(true);
        ckbComplete.setText("Complete");
        ckbComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(ckbComplete, gridBagConstraints);

        dcsWorkDate.setDateFormatString("MM/dd/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 0);
        pnlAttendanceInfor.add(dcsWorkDate, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.55;
        gridBagConstraints.weighty = 0.45;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(pnlAttendanceInfor, gridBagConstraints);

        pnlAttendanceList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Attendance list of labor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlAttendanceList.setLayout(new java.awt.BorderLayout(0, 5));

        scrAttendance.setPreferredSize(new java.awt.Dimension(450, 200));

        tblAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Work date", "Time in", "Time out", "Is extra shift", "Complete"
            }
        ));
        tblAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAttendanceMouseClicked(evt);
            }
        });
        scrAttendance.setViewportView(tblAttendance);

        pnlAttendanceList.add(scrAttendance, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnTimekeeping.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/add.png"))); // NOI18N
        btnTimekeeping.setText("Timekeeping");
        btnTimekeeping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimekeepingActionPerformed(evt);
            }
        });
        jPanel1.add(btnTimekeeping);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/edit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/delete2.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);

        pnlAttendanceList.add(jPanel1, java.awt.BorderLayout.SOUTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.55;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(pnlAttendanceList, gridBagConstraints);

        pnlLaborList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Labor list", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlLaborList.setLayout(new java.awt.BorderLayout());

        scrWorker.setPreferredSize(new java.awt.Dimension(300, 402));

        tblWorker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "First name", "Last name", "Day of birth"
            }
        ));
        tblWorker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblWorkerMouseClicked(evt);
            }
        });
        scrWorker.setViewportView(tblWorker);

        pnlLaborList.add(scrWorker, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.45;
        gridBagConstraints.weighty = 0.85;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(pnlLaborList, gridBagConstraints);

        pnlTitle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlTitle.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Attendance Management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlTitle.add(lblTitle, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.15;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 20, 2);
        getContentPane().add(pnlTitle, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbShiftNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbShiftNameItemStateChanged
        indexSelectShiftName = cbbShiftName.getSelectedIndex();
        txtTimeIn.setText(arrShift.get(indexSelectShiftName).getTimeIn());
        txtTimeOut.setText(arrShift.get(indexSelectShiftName).getTimeOut());
    }//GEN-LAST:event_cbbShiftNameItemStateChanged

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        disableFields();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tblAttendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAttendanceMouseClicked
        indexAttendance = tblAttendance.getSelectedRow();
        if (indexAttendance > -1) {
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
            dcsWorkDate.setDate(arrAttendance.get(indexAttendance).getWorkDay());
            cbbShiftName.setSelectedItem(arrAttendance.get(indexAttendance).getShift().getShiftName());
            ckbComplete.setSelected(arrAttendance.get(indexAttendance).isStatus());
            ckbIsExtraShift.setSelected(arrAttendance.get(indexAttendance).isIsExtraShift());
            txtFirstName.setText(arrAttendance.get(indexAttendance).getWorker().getFirstName());
            txtLastName.setText(arrAttendance.get(indexAttendance).getWorker().getLastName());
            dcsDayOfBirth.setDate(arrAttendance.get(indexAttendance).getWorker().getDayOfBirth());
        }
    }//GEN-LAST:event_tblAttendanceMouseClicked

    private void tblWorkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWorkerMouseClicked
        indexLabor = tblWorker.getSelectedRow();
        if (indexLabor > -1) {
            loadDataOnAttendanceTable(arrWorker.get(indexLabor).getWorkerID());
            disableFields();
            btnTimekeeping.setEnabled(true);
            txtFirstName.setText(arrWorker.get(indexLabor).getFirstName());
            txtLastName.setText(arrWorker.get(indexLabor).getLastName());
            dcsDayOfBirth.setDate(arrWorker.get(indexLabor).getDayOfBirth());
        }
    }//GEN-LAST:event_tblWorkerMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        selection = 0;
        enableFields();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        selection = -1;
        indexAttendance = tblAttendance.getSelectedRow();
        Attendance at = new Attendance();
        at = arrAttendance.get(indexAttendance);
        int i = JOptionPane.showConfirmDialog(this, "Are you sure want to delete all data related to this attendance have ID = " + at.getID(), "Question", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            attendanceSer = new AttendanceServices();
            if (attendanceSer.remove(at.getID())) {
                JOptionPane.showMessageDialog(this, attendanceSer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                loadDataOnAttendanceTable(arrWorker.get(indexLabor).getWorkerID());
                clearFields();
                disableFields();
                btnTimekeeping.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, attendanceSer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnTimekeepingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimekeepingActionPerformed
        selection = 1;
        clearFields();
        enableFields();
    }//GEN-LAST:event_btnTimekeepingActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Attendance at = new Attendance();
        if (selection == 0) {
            indexAttendance = tblAttendance.getSelectedRow();
            at = arrAttendance.get(indexAttendance);
        } else {
            at.setWorker(workerSer.readByID(arrWorker.get(indexLabor).getWorkerID()));
        }
        if (dcsWorkDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "DayOfBirth can not empty or the date is not valid!", "Warning", JOptionPane.WARNING_MESSAGE);
            dcsWorkDate.requestFocus();
            dcsWorkDate.setDate(null);
            return;
        }
        //set value for attendance
        indexSelectShiftName = cbbShiftName.getSelectedIndex();
        at.setShift(arrShift.get(indexSelectShiftName));
        at.setIsExtraShift(ckbIsExtraShift.isSelected());
        at.setStatus(ckbComplete.isSelected());

        //covert date calender to date sql
        Calendar ca = Calendar.getInstance();
        ca.setTime(dcsWorkDate.getDate());
        Date date = new Date(ca.getTimeInMillis());
        at.setWorkDay(date);


        attendanceSer = new AttendanceServices();
        if (selection == 1) {
            if (attendanceSer.create(at)) {
                JOptionPane.showMessageDialog(this, attendanceSer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                loadDataOnAttendanceTable(at.getWorker().getWorkerID());
                disableFields();
                btnTimekeeping.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, attendanceSer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            if (selection == 0) {
                if (attendanceSer.store(at)) {
                    JOptionPane.showMessageDialog(this, attendanceSer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                    loadDataOnAttendanceTable(at.getWorker().getWorkerID());
                    disableFields();
                    btnTimekeeping.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, attendanceSer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * enable fields
     */
    private void enableFields() {
        cbbShiftName.setEnabled(true);
        dcsWorkDate.setEnabled(true);
        btnCancel.setEnabled(true);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnTimekeeping.setEnabled(true);
        ckbComplete.setEnabled(true);
        ckbIsExtraShift.setEnabled(true);
    }

    /**
     * disable fields
     */
    private void disableFields() {
        clearFields();
        cbbShiftName.setEnabled(false);
        dcsWorkDate.setEnabled(false);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);
        btnTimekeeping.setEnabled(false);
        ckbComplete.setEnabled(false);
        ckbIsExtraShift.setEnabled(false);

    }

    /**
     * clear fields
     */
    private void clearFields() {
        txtFirstName.setText("");
        txtLastName.setText("");
        dcsDayOfBirth.setDate(null);
        cbbShiftName.setSelectedIndex(0);
        dcsWorkDate.setDate(new java.util.Date());
        ckbComplete.setSelected(true);
        ckbIsExtraShift.setSelected(false);
    }

    /**
     * load data on combobox shift name
     */
    private void loadDataOnCbbShiftName() {
        ShiftServices shiftSer = new ShiftServices();
        arrShift = shiftSer.findByAll();
        for (int i = 0; i < arrShift.size(); i++) {
            cbbShiftName.addItem(arrShift.get(i).getShiftName());
        }
    }

    /**
     * load attendance of the labor on table attendance
     * @param workerID
     */
    private void loadDataOnAttendanceTable(int workerID) {
        attendanceSer = new AttendanceServices();
        arrAttendance = attendanceSer.findAttendanceByWorkerID(workerID);

        ColumnData[] columns = {
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

    /**
     * load data on labor table
     */
    private void loadDataOnLaborTable() {
        workerSer = new WorkerServices();
        arrWorker = workerSer.findByAll();

        ColumnData[] columns = {
            new ColumnData("Last name", 120, SwingConstants.LEFT, 2),
            new ColumnData("First name", 80, SwingConstants.LEFT, 1),
            new ColumnData("Day of birth", 90, SwingConstants.LEFT, 3)
        };
        tableModel = new ObjectTableModel(tblWorker, columns, arrWorker);
        headerTable = tableModel.getHeaderTable();

        //tao cot stt tu dong
        headerTable.createDefaultColumnsFromModel();

        tblWorker.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Put it in a viewport that we can control a bit
        JViewport viewport = new JViewport();

        //hien thi du lieu cot stt
        viewport.setView(headerTable);

        viewport.setPreferredSize(headerTable.getMaximumSize());

        scrWorker.setRowHeader(viewport);
        scrWorker.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                AttendanceManagementDlg dialog = new AttendanceManagementDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTimekeeping;
    private javax.swing.JComboBox cbbShiftName;
    private javax.swing.JCheckBox ckbComplete;
    private javax.swing.JCheckBox ckbIsExtraShift;
    private com.toedter.calendar.JDateChooser dcsDayOfBirth;
    private com.toedter.calendar.JDateChooser dcsWorkDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDayOfBirth;
    private javax.swing.JLabel lblFirstlName;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblShiftName;
    private javax.swing.JLabel lblTimeIn;
    private javax.swing.JLabel lblTimeOut;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWorkDate;
    private javax.swing.JPanel pnlAttendanceInfor;
    private javax.swing.JPanel pnlAttendanceList;
    private javax.swing.JPanel pnlLaborList;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JScrollPane scrAttendance;
    private javax.swing.JScrollPane scrWorker;
    private javax.swing.JTable tblAttendance;
    private javax.swing.JTable tblWorker;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtTimeIn;
    private javax.swing.JTextField txtTimeOut;
    // End of variables declaration//GEN-END:variables
}
