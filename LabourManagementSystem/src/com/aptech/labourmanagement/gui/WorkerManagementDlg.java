/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WorkerManagementDlg.java
 *
 * Created on May 10, 2010, 6:17:29 PM
 */
package com.aptech.labourmanagement.gui;

import com.aptech.labourmanagement.component.ColumnData;
import com.aptech.labourmanagement.component.LookAndFeel;
import com.aptech.labourmanagement.component.ObjectTableModel;
import com.aptech.labourmanagement.entity.Refer;
import com.aptech.labourmanagement.entity.SalaryGrade;
import com.aptech.labourmanagement.entity.Worker;
import com.aptech.labourmanagement.services.ReferServices;
import com.aptech.labourmanagement.services.SalaryGradeServices;
import com.aptech.labourmanagement.services.WorkerServices;
import com.aptech.labourmanagement.util.CheckForm;
import java.awt.Toolkit;
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
 * @author lab
 */
public class WorkerManagementDlg extends javax.swing.JDialog {

    public WorkerServices workerSer;
    public ObjectTableModel tableModel;
    public ArrayList<Worker> arrWorker = new ArrayList<Worker>();
    public ArrayList<Refer> referList = new ArrayList<Refer>();
    public ArrayList<SalaryGrade> sgList = new ArrayList<SalaryGrade>();
    //contains information header of columns
    public JTable headerTable;
    //index selected in table
    int index = -1;
    int selection;

    /** Creates new form WorkerManagementDlg */
    public WorkerManagementDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../icon/LMSIcon.png")).getImage());
        // Cach lam cho form xuat hien giua man hinh
        this.setSize(910, 550);
        int width = this.getWidth();
        int heigh = this.getHeight();
        int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.setBounds((screenWidth - width) / 2, (screenHeight - heigh) / 2, width, heigh);
        new LookAndFeel(this);
        loadDataOnTable();
        loadDataCbbRefer();
        loadDataCbbSalaryGrade();
        disableFields();
        //dcsDayOfBirth.setDate(new java.util.Date());
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

        jPanel5 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtFirstName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLastname = new javax.swing.JTextField();
        dcsDayOfBirth = new com.toedter.calendar.JDateChooser();
        txtAddress = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        ckbIsTemporaryWorker = new javax.swing.JCheckBox();
        ckbIsWorking = new javax.swing.JCheckBox();
        txtWeight = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        cbbRefer = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbbSalaryGrade = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtExperienceYear = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        scrWorker = new javax.swing.JScrollPane();
        tblWorker = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Labor Management");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel5.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Labor Management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(lblTitle, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 25, 5);
        getContentPane().add(jPanel5, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Labor information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel3.setLayout(new java.awt.GridBagLayout());

        txtFirstName.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(txtFirstName, gridBagConstraints);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("First name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 2);
        jPanel3.add(jLabel1, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Last name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 2);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Day of birth:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 2);
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 2);
        jPanel3.add(jLabel4, gridBagConstraints);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Experience year:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 2);
        jPanel3.add(jLabel5, gridBagConstraints);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Salary grade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 2);
        jPanel3.add(jLabel7, gridBagConstraints);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Weight(kg):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        jPanel3.add(jLabel9, gridBagConstraints);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Height(cm):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 2);
        jPanel3.add(jLabel10, gridBagConstraints);

        txtLastname.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(txtLastname, gridBagConstraints);

        dcsDayOfBirth.setDateFormatString("MM/dd/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(dcsDayOfBirth, gridBagConstraints);

        txtAddress.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(txtAddress, gridBagConstraints);

        txtContact.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(txtContact, gridBagConstraints);

        ckbIsTemporaryWorker.setSelected(true);
        ckbIsTemporaryWorker.setText("is temporary worker");
        ckbIsTemporaryWorker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(ckbIsTemporaryWorker, gridBagConstraints);

        ckbIsWorking.setSelected(true);
        ckbIsWorking.setText("Is working");
        ckbIsWorking.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(ckbIsWorking, gridBagConstraints);

        txtWeight.setColumns(5);
        txtWeight.setText("0.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel3.add(txtWeight, gridBagConstraints);

        txtHeight.setColumns(5);
        txtHeight.setText("0.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel3.add(txtHeight, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(cbbRefer, gridBagConstraints);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Refer:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 2);
        jPanel3.add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(cbbSalaryGrade, gridBagConstraints);

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
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        jPanel3.add(jPanel2, gridBagConstraints);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Contact number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 2);
        jPanel3.add(jLabel8, gridBagConstraints);

        txtExperienceYear.setColumns(20);
        txtExperienceYear.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(txtExperienceYear, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Labor list", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setLayout(new java.awt.BorderLayout(5, 5));

        scrWorker.setPreferredSize(new java.awt.Dimension(450, 350));

        tblWorker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "First name", "Last name", "Day of birth", "Contact", "Salary grade", "Refer", "Is temporary worker", "Is working"
            }
        ));
        scrWorker.setViewportView(tblWorker);

        jPanel4.add(scrWorker, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);

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

        jPanel4.add(jPanel1, java.awt.BorderLayout.SOUTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        disableFields();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        clearFields();
        enableFields();
        selection = 1;
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        enableFields();
        selection = 0;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        selection = -1;
        index = tblWorker.getSelectedRow();
        Worker worker = new Worker();
        worker = arrWorker.get(index);
        int i = JOptionPane.showConfirmDialog(this, "Are you sure want to delete all data related to this worker. full name = " + worker.getFirstName() + " " + worker.getLastName());
        if (i == JOptionPane.YES_OPTION) {
            workerSer = new WorkerServices();
            if (workerSer.remove(worker.getWorkerID())) {
                JOptionPane.showMessageDialog(this, workerSer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                loadDataOnTable();
                clearFields();
                disableFields();
            } else {
                JOptionPane.showMessageDialog(this, workerSer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (!CheckForm.isNumberic(txtExperienceYear.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Experience year must be numberic type!", "Warning", JOptionPane.WARNING_MESSAGE);
            txtExperienceYear.requestFocus();
            txtExperienceYear.setText("");
            return;
        }
        if (!CheckForm.isNumberic(txtHeight.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Height must be numberic type!", "Warning", JOptionPane.WARNING_MESSAGE);
            txtHeight.requestFocus();
            txtHeight.setText("");
            return;
        }
        if (!CheckForm.isNumberic(txtWeight.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Weight must be numberic type!", "Warning", JOptionPane.WARNING_MESSAGE);
            txtWeight.requestFocus();
            txtWeight.setText("");
            return;
        }
        if (dcsDayOfBirth.getDate() == null) {
            JOptionPane.showMessageDialog(this, "DayOfBirth can not empty or the date is not valid!", "Warning", JOptionPane.WARNING_MESSAGE);
            dcsDayOfBirth.requestFocus();
            dcsDayOfBirth.setDate(null);
            return;
        }
        Worker worker = new Worker();
        if (selection == 0) {
            index = tblWorker.getSelectedRow();
            worker = arrWorker.get(index);
        }
        worker.setFirstName(txtFirstName.getText().trim());
        worker.setLastName(txtLastname.getText().trim());
        worker.setAddress(txtAddress.getText().trim());
        worker.setExperience(Integer.parseInt(txtExperienceYear.getText().trim()));
        worker.setContactNumber(txtContact.getText().trim());
        worker.setHeight(Float.parseFloat(txtHeight.getText().trim()));
        worker.setWeight(Float.parseFloat(txtWeight.getText().trim()));
        worker.setIsTemporaryWorker(ckbIsTemporaryWorker.isSelected());

        //get refer
        int referIndex = cbbSalaryGrade.getSelectedIndex();
        Refer refer = referList.get(referIndex);
        worker.setRefer(refer);

        //get salary grade
        int salaryGradeIndex = cbbRefer.getSelectedIndex();
        SalaryGrade sg = sgList.get(salaryGradeIndex);
        worker.setSalaryGrade(sg);

        worker.setStatus(ckbIsWorking.isSelected());

        //covert date calender to date sql
        Calendar ca = Calendar.getInstance();
        ca.setTime(dcsDayOfBirth.getDate());
        Date date = new Date(ca.getTimeInMillis());
        worker.setDayOfBirth(date);

        workerSer = new WorkerServices();
        if (selection == 1) {
            if (workerSer.create(worker)) {
                JOptionPane.showMessageDialog(this, workerSer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                loadDataOnTable();
                disableFields();
            } else {
                JOptionPane.showMessageDialog(this, workerSer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            if (workerSer.store(worker)) {
                JOptionPane.showMessageDialog(this, workerSer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                loadDataOnTable();
                disableFields();
            } else {
                JOptionPane.showMessageDialog(this, workerSer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * enable fields
     */
    public void enableFields() {
        txtAddress.setEditable(true);
        txtContact.setEditable(true);
        txtExperienceYear.setEditable(true);
        txtFirstName.setEditable(true);
        txtHeight.setEditable(true);
        txtLastname.setEditable(true);
        txtWeight.setEditable(true);
        cbbSalaryGrade.setEditable(true);
        cbbRefer.setEditable(true);
        ckbIsTemporaryWorker.setEnabled(true);
        ckbIsWorking.setEnabled(true);
        dcsDayOfBirth.setEnabled(true);
        btnCancel.setEnabled(true);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        cbbSalaryGrade.setEnabled(true);
        cbbRefer.setEnabled(true);

    }

    /**
     * disable fields
     */
    public void disableFields() {
        clearFields();
        txtAddress.setEditable(false);
        txtContact.setEditable(false);
        txtExperienceYear.setEditable(false);
        txtFirstName.setEditable(false);
        txtHeight.setEditable(false);
        txtLastname.setEditable(false);
        txtWeight.setEditable(false);
        cbbSalaryGrade.setEditable(false);
        cbbRefer.setEditable(false);
        ckbIsTemporaryWorker.setEnabled(false);
        ckbIsWorking.setEnabled(false);
        dcsDayOfBirth.setEnabled(false);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);
        cbbSalaryGrade.setEnabled(false);
        cbbRefer.setEnabled(false);
    }

    /**
     * clear fields
     */
    public void clearFields() {
        txtAddress.setText("");
        txtContact.setText("");
        txtExperienceYear.setText("0");
        txtFirstName.setText("");
        txtHeight.setText("0.0");
        txtLastname.setText("");
        txtWeight.setText("0.0");
        cbbSalaryGrade.setSelectedIndex(0);
        cbbRefer.setSelectedIndex(0);
        ckbIsTemporaryWorker.setSelected(true);
        ckbIsWorking.setSelected(true);
        dcsDayOfBirth.setDate(null);
    }

    /**
     * load data of refer to combobox
     */
    public void loadDataCbbRefer() {
        ReferServices referSer = new ReferServices();
        referList = referSer.findByAll();
        for (int i = 0; i < referList.size(); i++) {
            cbbRefer.addItem(referList.get(i).getFullName());
        }

    }

    public void loadDataCbbSalaryGrade() {
        SalaryGradeServices sgSer = new SalaryGradeServices();
        sgList = sgSer.finfByAll();
        for (int i = 0; i < sgList.size(); i++) {
            cbbSalaryGrade.addItem(String.valueOf(sgList.get(i).getGradeNum()));
        }
    }

    /**
     * load data on table
     */
    public void loadDataOnTable() {
        workerSer = new WorkerServices();
        arrWorker = workerSer.findByAll();

        ColumnData[] columns = {
            new ColumnData("First name", 70, SwingConstants.LEFT, 1),
            new ColumnData("Last name", 70, SwingConstants.LEFT, 2),
            new ColumnData("Day of birth", 60, SwingConstants.LEFT, 3),
            new ColumnData("Contact", 60, SwingConstants.LEFT, 4),
            new ColumnData("Salary grade", 60, SwingConstants.LEFT, 5),
            new ColumnData("Refer", 70, SwingConstants.LEFT, 6),
            new ColumnData("Temporary worker", 60, SwingConstants.CENTER, 7),
            new ColumnData("Is working", 40, SwingConstants.CENTER, 8)
        };
        tableModel = new ObjectTableModel(tblWorker, columns, arrWorker);
        headerTable = tableModel.getHeaderTable();

        //tao cot stt tu dong
        headerTable.createDefaultColumnsFromModel();

        tblWorker.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
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
                WorkerManagementDlg dialog = new WorkerManagementDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cbbRefer;
    private javax.swing.JComboBox cbbSalaryGrade;
    private javax.swing.JCheckBox ckbIsTemporaryWorker;
    private javax.swing.JCheckBox ckbIsWorking;
    private com.toedter.calendar.JDateChooser dcsDayOfBirth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane scrWorker;
    private javax.swing.JTable tblWorker;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtExperienceYear;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
