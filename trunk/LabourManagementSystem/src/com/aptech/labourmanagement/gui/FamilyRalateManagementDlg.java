/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FamilyRalateManagementDlg.java
 *
 * Created on May 10, 2010, 1:12:52 PM
 */
package com.aptech.labourmanagement.gui;

import com.aptech.labourmanagement.component.ColumnData;
import com.aptech.labourmanagement.component.LookAndFeel;
import com.aptech.labourmanagement.component.ObjectTableModel;
import com.aptech.labourmanagement.entity.Family;
import com.aptech.labourmanagement.entity.Worker;
import com.aptech.labourmanagement.services.FamilyServices;
import com.aptech.labourmanagement.services.WorkerServices;
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
 * @author Noi Nho
 */
public class FamilyRalateManagementDlg extends javax.swing.JDialog {

    private WorkerServices workerSer;
    private FamilyServices familySer;
    private ObjectTableModel tableModel;
    private ArrayList<Family> arrFamily = new ArrayList<Family>();
    private ArrayList<Worker> arrWorker = new ArrayList<Worker>();
    //contains information header of columns
    private JTable headerTable;
    //index selected in table
    int indexLabor = -1;
    int indexFamily = -1;
    int selection;

    /** Creates new form FamilyRalateManagementDlg */
    public FamilyRalateManagementDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/LMSIcon.png")).getImage());
        // Cach lam cho form xuat hien giua man hinh
        this.setSize(855, 640);
        int width = this.getWidth();
        int heigh = this.getHeight();
        int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.setBounds((screenWidth - width) / 2, (screenHeight - heigh) / 2, width, heigh);
        new LookAndFeel(this);
        loadDataOnLaborTable();
        loadCcRalateName();
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

        pnlFamilyInfor = new javax.swing.JPanel();
        lblFullName = new javax.swing.JLabel();
        lblDayOfBirth = new javax.swing.JLabel();
        lblRalateName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        dcsDayOfBirth = new com.toedter.calendar.JDateChooser();
        cbbRalateName = new javax.swing.JComboBox();
        txtAddress = new javax.swing.JTextField();
        txtWorkName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pnlFamilyList = new javax.swing.JPanel();
        scrFamily = new javax.swing.JScrollPane();
        tblFamily = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        pnlLaborList = new javax.swing.JPanel();
        scrWorker = new javax.swing.JScrollPane();
        tblWorker = new javax.swing.JTable();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Family Ralate Management");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlFamilyInfor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Family member information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlFamilyInfor.setLayout(new java.awt.GridBagLayout());

        lblFullName.setText("Full name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        pnlFamilyInfor.add(lblFullName, gridBagConstraints);

        lblDayOfBirth.setText("Day of birth:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        pnlFamilyInfor.add(lblDayOfBirth, gridBagConstraints);

        lblRalateName.setText("Ralate name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        pnlFamilyInfor.add(lblRalateName, gridBagConstraints);

        lblAddress.setText("Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        pnlFamilyInfor.add(lblAddress, gridBagConstraints);

        jLabel6.setText("Work name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        pnlFamilyInfor.add(jLabel6, gridBagConstraints);

        txtFullName.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 5);
        pnlFamilyInfor.add(txtFullName, gridBagConstraints);

        dcsDayOfBirth.setDateFormatString("MM/dd/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 5);
        pnlFamilyInfor.add(dcsDayOfBirth, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 5);
        pnlFamilyInfor.add(cbbRalateName, gridBagConstraints);

        txtAddress.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 5);
        pnlFamilyInfor.add(txtAddress, gridBagConstraints);

        txtWorkName.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 5);
        pnlFamilyInfor.add(txtWorkName, gridBagConstraints);

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
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlFamilyInfor.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.55;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlFamilyInfor, gridBagConstraints);

        pnlFamilyList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Family members list", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlFamilyList.setLayout(new java.awt.BorderLayout(0, 5));

        scrFamily.setPreferredSize(new java.awt.Dimension(450, 200));

        tblFamily.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Full name", "Day of birth", "Ralate name", "Address"
            }
        ));
        tblFamily.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFamilyMouseClicked(evt);
            }
        });
        scrFamily.setViewportView(tblFamily);

        pnlFamilyList.add(scrFamily, java.awt.BorderLayout.CENTER);

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

        pnlFamilyList.add(jPanel1, java.awt.BorderLayout.SOUTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.55;
        gridBagConstraints.weighty = 0.55;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlFamilyList, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlLaborList, gridBagConstraints);

        pnlTitle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlTitle.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Family Relationship Management");
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
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 25, 5);
        getContentPane().add(pnlTitle, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblWorkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWorkerMouseClicked
        indexLabor = tblWorker.getSelectedRow();
        if (indexLabor > -1) {
            loadDataOnFamilyTable(arrWorker.get(indexLabor).getWorkerID());
            disableFields();
            btnAdd.setEnabled(true);
        }
    }//GEN-LAST:event_tblWorkerMouseClicked
    /**
     * load data to combobox ralate name
     */
    public void loadCcRalateName() {
        cbbRalateName.addItem("Father");
        cbbRalateName.addItem("Mother");
        cbbRalateName.addItem("Sister");
        cbbRalateName.addItem("Brother");
        cbbRalateName.addItem("Grandfather");
        cbbRalateName.addItem("Grandmother");
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Family family = new Family();
        if (selection == 0) {
            indexFamily = tblFamily.getSelectedRow();
            family = arrFamily.get(indexFamily);
        } else {
            family.setWorker(workerSer.readByID(arrWorker.get(indexLabor).getWorkerID()));
        }
        if (dcsDayOfBirth.getDate() == null) {
            JOptionPane.showMessageDialog(this, "DayOfBirth can not empty or the date is not valid!", "Warning", JOptionPane.WARNING_MESSAGE);
            dcsDayOfBirth.requestFocus();
            dcsDayOfBirth.setDate(null);
            return;
        }
        //set value for family
        family.setAddress(txtAddress.getText().trim());
        family.setFullName(txtFullName.getText().trim());
        family.setWorkName(txtWorkName.getText().trim());
        family.setRalateName((String) cbbRalateName.getSelectedItem());
        //covert date calender to date sql
        Calendar ca = Calendar.getInstance();
        ca.setTime(dcsDayOfBirth.getDate());
        Date date = new Date(ca.getTimeInMillis());
        family.setDayOfBirth(date);


        familySer = new FamilyServices();
        if (selection == 1) {
            if (familySer.create(family)) {
                JOptionPane.showMessageDialog(this, familySer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                loadDataOnFamilyTable(family.getWorker().getWorkerID());
                disableFields();
                btnAdd.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, familySer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            if (selection == 0) {
                if (familySer.store(family)) {
                    JOptionPane.showMessageDialog(this, familySer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                    loadDataOnFamilyTable(family.getWorker().getWorkerID());
                    disableFields();
                    btnAdd.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, familySer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        disableFields();
        btnAdd.setEnabled(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tblFamilyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFamilyMouseClicked
        indexFamily = tblFamily.getSelectedRow();
        if (indexFamily > -1) {
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
            txtAddress.setText(arrFamily.get(indexFamily).getAddress());
            txtFullName.setText(arrFamily.get(indexFamily).getFullName());
            txtWorkName.setText(arrFamily.get(indexFamily).getWorkName());
            cbbRalateName.setSelectedItem(arrFamily.get(indexFamily).getRalateName());
            dcsDayOfBirth.setDate(arrFamily.get(indexFamily).getDayOfBirth());
        }
    }//GEN-LAST:event_tblFamilyMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        selection = 0;
        enableFields();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        selection = 1;
        clearFields();
        enableFields();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        selection = -1;
        indexFamily = tblFamily.getSelectedRow();
        Family family = new Family();
        family = arrFamily.get(indexFamily);
        int i = JOptionPane.showConfirmDialog(this, "Are you sure want to delete all data related to family member have full name = " + family.getFullName(), "Question", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            familySer = new FamilyServices();
            if (familySer.remove(family.getFamilyID())) {
                JOptionPane.showMessageDialog(this, familySer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                loadDataOnFamilyTable(arrWorker.get(indexLabor).getWorkerID());
                clearFields();
                disableFields();
                btnAdd.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, familySer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * enable fields
     */
    private void enableFields() {
        txtAddress.setEditable(true);
        txtFullName.setEditable(true);
        txtWorkName.setEditable(true);
        dcsDayOfBirth.setEnabled(true);
        cbbRalateName.setEnabled(true);
        btnAdd.setEnabled(true);
        btnCancel.setEnabled(true);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
    }

    /**
     * disable fields
     */
    private void disableFields() {
        clearFields();
        txtAddress.setEditable(false);
        txtFullName.setEditable(false);
        txtWorkName.setEditable(false);
        dcsDayOfBirth.setEnabled(false);
        cbbRalateName.setEnabled(false);
        btnAdd.setEnabled(false);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);
    }

    /**
     *  clear fields
     */
    private void clearFields() {
        txtAddress.setText("");
        txtFullName.setText("");
        txtWorkName.setText("");
        dcsDayOfBirth.setDate(null);
        cbbRalateName.setSelectedIndex(0);
    }

    /**
     * load data on family table
     * @param workerID
     */
    private void loadDataOnFamilyTable(int workerID) {
        familySer = new FamilyServices();
        arrFamily = familySer.findFamilyByWorkerID(workerID);

        ColumnData[] columns = {
            new ColumnData("Full name", 150, SwingConstants.LEFT, 1),
            new ColumnData("Day of birth", 90, SwingConstants.LEFT, 2),
            new ColumnData("Ralate name", 90, SwingConstants.LEFT, 3),
            new ColumnData("Address", 100, SwingConstants.LEFT, 4)
        };
        tableModel = new ObjectTableModel(tblFamily, columns, arrFamily);
        headerTable = tableModel.getHeaderTable();

        //tao cot stt tu dong
        headerTable.createDefaultColumnsFromModel();

        tblFamily.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Put it in a viewport that we can control a bit
        JViewport viewport = new JViewport();

        //hien thi du lieu cot stt
        viewport.setView(headerTable);

        viewport.setPreferredSize(headerTable.getMaximumSize());

        scrFamily.setRowHeader(viewport);
        scrFamily.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());
    }

    /**
     * load data on table Labor
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
                FamilyRalateManagementDlg dialog = new FamilyRalateManagementDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cbbRalateName;
    private com.toedter.calendar.JDateChooser dcsDayOfBirth;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDayOfBirth;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblRalateName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlFamilyInfor;
    private javax.swing.JPanel pnlFamilyList;
    private javax.swing.JPanel pnlLaborList;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JScrollPane scrFamily;
    private javax.swing.JScrollPane scrWorker;
    private javax.swing.JTable tblFamily;
    private javax.swing.JTable tblWorker;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtWorkName;
    // End of variables declaration//GEN-END:variables
}
