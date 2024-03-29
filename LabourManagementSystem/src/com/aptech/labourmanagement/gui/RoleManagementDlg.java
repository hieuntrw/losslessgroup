/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RoleManagementDlg.java
 *
 * Created on May 7, 2010, 6:07:11 PM
 */
package com.aptech.labourmanagement.gui;

import com.aptech.labourmanagement.component.LookAndFeel;
import com.aptech.labourmanagement.entity.Role;
import com.aptech.labourmanagement.services.RoleServices;
import com.aptech.labourmanagement.component.ColumnData;
import com.aptech.labourmanagement.component.ObjectTableModel;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/**
 *
 * @author lab
 */
public class RoleManagementDlg extends javax.swing.JDialog {

    private RoleServices roleSer;
    private ObjectTableModel tableModel;
    private ArrayList<Role> arrRole = new ArrayList<Role>();
    //contains information header of columns
    private JTable headerTable;
    //index selected in table
    int index = -1;
    int selection;

    /** Creates new form RoleManagementDlg */
    public RoleManagementDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/LMSIcon.png")).getImage());
        loadDataOnTable();

        this.setSize(780, 500);
        this.setLocationRelativeTo(null);
        new LookAndFeel(this);

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

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblRoleName = new javax.swing.JLabel();
        ckbAll = new javax.swing.JCheckBox();
        ckbAccountManagement = new javax.swing.JCheckBox();
        ckbRoleManagement = new javax.swing.JCheckBox();
        ckbReferManagement = new javax.swing.JCheckBox();
        ckbFamilyManagement = new javax.swing.JCheckBox();
        ckbSalaryGrade = new javax.swing.JCheckBox();
        ckbLaborManagement = new javax.swing.JCheckBox();
        ckbAttendanceManagement = new javax.swing.JCheckBox();
        ckbWeeklySararyReport = new javax.swing.JCheckBox();
        ckbWeeklyAttendanceReport = new javax.swing.JCheckBox();
        txtRoleName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        scrRole = new javax.swing.JScrollPane();
        tblRole = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Role Management");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setText("Role Management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel1.add(lblTitle, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 20, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Role information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lblRoleName.setText("Role name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel2.add(lblRoleName, gridBagConstraints);

        ckbAll.setText("All");
        ckbAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbAllActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(ckbAll, gridBagConstraints);

        ckbAccountManagement.setText("Is account management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(ckbAccountManagement, gridBagConstraints);

        ckbRoleManagement.setText("Is role management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(ckbRoleManagement, gridBagConstraints);

        ckbReferManagement.setText("Is refer management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(ckbReferManagement, gridBagConstraints);

        ckbFamilyManagement.setText("Is family management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(ckbFamilyManagement, gridBagConstraints);

        ckbSalaryGrade.setText("Is salary grade management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(ckbSalaryGrade, gridBagConstraints);

        ckbLaborManagement.setText("Is labor management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(ckbLaborManagement, gridBagConstraints);

        ckbAttendanceManagement.setText("Is attendance management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(ckbAttendanceManagement, gridBagConstraints);

        ckbWeeklySararyReport.setText("Is weekly salary report");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(ckbWeeklySararyReport, gridBagConstraints);

        ckbWeeklyAttendanceReport.setText("Is weekly attendance report");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel2.add(ckbWeeklyAttendanceReport, gridBagConstraints);

        txtRoleName.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel2.add(txtRoleName, gridBagConstraints);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/check.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/delete.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel2.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Role list", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setLayout(new java.awt.BorderLayout(0, 10));

        scrRole.setPreferredSize(new java.awt.Dimension(350, 150));

        tblRole.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Role ID", "Role name"
            }
        ));
        tblRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoleMouseClicked(evt);
            }
        });
        scrRole.setViewportView(tblRole);

        jPanel4.add(scrRole, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel5.add(btnAdd);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/edit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel5.add(btnEdit);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/delete2.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel5.add(btnDelete);

        jPanel4.add(jPanel5, java.awt.BorderLayout.SOUTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        clearFields();
        enableFields();
        selection = 1;
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        enableFields();
        //btnAdd.setEnabled(false);
        selection = 0;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        disableFields();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tblRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoleMouseClicked
        index = tblRole.getSelectedRow();
        if (index > -1) {
            txtRoleName.setText(arrRole.get(index).getRoleName());
            ckbAccountManagement.setSelected(arrRole.get(index).isIsAccountManagement());
            ckbAttendanceManagement.setSelected(arrRole.get(index).isIsAttendanceManagement());
            ckbFamilyManagement.setSelected(arrRole.get(index).isIsFamilyManagement());
            ckbLaborManagement.setSelected(arrRole.get(index).isIsWorkerManagement());
            ckbReferManagement.setSelected(arrRole.get(index).isIsRefersManagement());
            ckbRoleManagement.setSelected(arrRole.get(index).isIsRoleManagement());
            ckbSalaryGrade.setSelected(arrRole.get(index).isIsSalaryGradeManagement());
            ckbWeeklyAttendanceReport.setSelected(arrRole.get(index).isIsWeeklyAttendanceReport());
            ckbWeeklySararyReport.setSelected(arrRole.get(index).isIsWeeklySalaryReport());
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
        }
    }//GEN-LAST:event_tblRoleMouseClicked

    private void ckbAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbAllActionPerformed
        if (ckbAll.isSelected() == true) {
            ckbAccountManagement.setSelected(true);
            ckbAttendanceManagement.setSelected(true);
            ckbFamilyManagement.setSelected(true);
            ckbLaborManagement.setSelected(true);
            ckbReferManagement.setSelected(true);
            ckbRoleManagement.setSelected(true);
            ckbSalaryGrade.setSelected(true);
            ckbWeeklyAttendanceReport.setSelected(true);
            ckbWeeklySararyReport.setSelected(true);
        } else {
            ckbAccountManagement.setSelected(false);
            ckbAttendanceManagement.setSelected(false);
            ckbFamilyManagement.setSelected(false);
            ckbLaborManagement.setSelected(false);
            ckbReferManagement.setSelected(false);
            ckbRoleManagement.setSelected(false);
            ckbSalaryGrade.setSelected(false);
            ckbWeeklyAttendanceReport.setSelected(false);
            ckbWeeklySararyReport.setSelected(false);
        }

    }//GEN-LAST:event_ckbAllActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Role role = new Role();
        if (selection == 0) {
            index = tblRole.getSelectedRow();
            role = arrRole.get(index);
        }
        role.setRoleName(txtRoleName.getText().trim());
        role.setIsAccountManagement(ckbAccountManagement.isSelected());
        role.setIsAttendanceManagement(ckbAttendanceManagement.isSelected());
        role.setIsFamilyManagement(ckbFamilyManagement.isSelected());
        role.setIsRefersManagement(ckbReferManagement.isSelected());
        role.setIsRoleManagement(ckbRoleManagement.isSelected());
        role.setIsSalaryGradeManagement(ckbSalaryGrade.isSelected());
        role.setIsWeeklyAttendanceReport(ckbWeeklyAttendanceReport.isSelected());
        role.setIsWeeklySalaryReport(ckbWeeklySararyReport.isSelected());
        role.setIsWorkerManagement(ckbLaborManagement.isSelected());
        roleSer = new RoleServices();
        if (selection == 1) {
            if (roleSer.create(role)) {
                JOptionPane.showMessageDialog(this, roleSer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                loadDataOnTable();
                disableFields();
            } else {
                JOptionPane.showMessageDialog(this, roleSer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            if (selection == 0) {
                if (roleSer.store(role)) {
                    JOptionPane.showMessageDialog(this, roleSer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                    loadDataOnTable();
                    disableFields();
                } else {
                    JOptionPane.showMessageDialog(this, roleSer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        selection = -1;
        index = tblRole.getSelectedRow();
        Role role = new Role();
        role = arrRole.get(index);
        int i = JOptionPane.showConfirmDialog(this, "Are you sure want to delete all data related to role name = " + role.getRoleName(), "Question", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            roleSer = new RoleServices();
            if (roleSer.remove(role.getRoleID())) {
                JOptionPane.showMessageDialog(this, roleSer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                loadDataOnTable();
                clearFields();
                disableFields();
            } else {
                JOptionPane.showMessageDialog(this, roleSer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
    /**
     * load data on table 
     */
    private void loadDataOnTable() {
        roleSer = new RoleServices();
        arrRole = roleSer.findRoleAll();
        ColumnData[] columns = {
            new ColumnData("Role ID", 50, SwingConstants.LEFT, 1),
            new ColumnData("Role name", 150, SwingConstants.LEFT, 2)
        };

        tableModel = new ObjectTableModel(tblRole, columns, arrRole);

        headerTable = tableModel.getHeaderTable();
        //tao cot stt tu dong
        headerTable.createDefaultColumnsFromModel();
        tblRole.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Put it in a viewport that we can control a bit
        JViewport viewport = new JViewport();

        //hien thi du lieu cot stt
        viewport.setView(headerTable);
        viewport.setPreferredSize(headerTable.getMaximumSize());
        scrRole.setRowHeader(viewport);
        scrRole.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    /**
     * disable fields
     */
    private void disableFields() {
        clearFields();
        txtRoleName.setEditable(false);
        ckbAccountManagement.setEnabled(false);
        ckbAll.setEnabled(false);
        ckbAttendanceManagement.setEnabled(false);
        ckbFamilyManagement.setEnabled(false);
        ckbLaborManagement.setEnabled(false);
        ckbReferManagement.setEnabled(false);
        ckbRoleManagement.setEnabled(false);
        ckbSalaryGrade.setEnabled(false);
        ckbWeeklyAttendanceReport.setEnabled(false);
        ckbWeeklySararyReport.setEnabled(false);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);

    }

    /**
     * enable Fields
     */
    private void enableFields() {
        //clearFields();
        txtRoleName.setEditable(true);
        ckbAccountManagement.setEnabled(true);
        ckbAll.setEnabled(true);
        ckbAttendanceManagement.setEnabled(true);
        ckbFamilyManagement.setEnabled(true);
        ckbLaborManagement.setEnabled(true);
        ckbReferManagement.setEnabled(true);
        ckbRoleManagement.setEnabled(true);
        ckbSalaryGrade.setEnabled(true);
        ckbWeeklyAttendanceReport.setEnabled(true);
        ckbWeeklySararyReport.setEnabled(true);
        btnCancel.setEnabled(true);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);

    }

    /**
     * clear Fields
     */
    private void clearFields() {
        txtRoleName.setText("");
        ckbAccountManagement.setSelected(false);
        ckbAll.setSelected(false);
        ckbAttendanceManagement.setSelected(false);
        ckbFamilyManagement.setSelected(false);
        ckbLaborManagement.setSelected(false);
        ckbReferManagement.setSelected(false);
        ckbRoleManagement.setSelected(false);
        ckbSalaryGrade.setSelected(false);
        ckbWeeklyAttendanceReport.setSelected(false);
        ckbWeeklySararyReport.setSelected(false);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                RoleManagementDlg dialog = new RoleManagementDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox ckbAccountManagement;
    private javax.swing.JCheckBox ckbAll;
    private javax.swing.JCheckBox ckbAttendanceManagement;
    private javax.swing.JCheckBox ckbFamilyManagement;
    private javax.swing.JCheckBox ckbLaborManagement;
    private javax.swing.JCheckBox ckbReferManagement;
    private javax.swing.JCheckBox ckbRoleManagement;
    private javax.swing.JCheckBox ckbSalaryGrade;
    private javax.swing.JCheckBox ckbWeeklyAttendanceReport;
    private javax.swing.JCheckBox ckbWeeklySararyReport;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblRoleName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane scrRole;
    private javax.swing.JTable tblRole;
    private javax.swing.JTextField txtRoleName;
    // End of variables declaration//GEN-END:variables
}
