/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReferManagementDlg.java
 *
 * Created on May 8, 2010, 3:59:00 PM
 */
package com.aptech.labourmanagement.gui;

import com.aptech.labourmanagement.component.ColumnData;
import com.aptech.labourmanagement.component.LookAndFeel;
import com.aptech.labourmanagement.component.ObjectTableModel;
import com.aptech.labourmanagement.entity.Refer;
import com.aptech.labourmanagement.services.ReferServices;
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
 * @author Noi Nho
 */
public class ReferManagementDlg extends javax.swing.JDialog {

    private ReferServices referSer;
    private ObjectTableModel tableModel;
    private ArrayList<Refer> arrRefers = new ArrayList<Refer>();
    //contains information header of columns
    private JTable headerTable;
    //index selected in table
    int index = -1;
    int selection;

    /** Creates new form ReferManagementDlg */
    public ReferManagementDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/LMSIcon.png")).getImage());
        this.setSize(780, 450);
        this.setLocationRelativeTo(null);
        new LookAndFeel(this);
        //dcsDayOfBirth.getDate();
        loadDataOnTable();
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

        jPanel5 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblFirstName = new javax.swing.JLabel();
        lblDayOfBirth = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblWorkName = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        lblContactNumber = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtWorkName = new javax.swing.JTextField();
        txtPosition = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        dcsDayOfBirth = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scrRefer = new javax.swing.JScrollPane();
        tblRefer = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Refer Management");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setText("Refer Management");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(lblTitle))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 25, 3);
        getContentPane().add(jPanel5, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Refer information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFirstName.setText("Full name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        jPanel1.add(lblFirstName, gridBagConstraints);

        lblDayOfBirth.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDayOfBirth.setText("Day of birth:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        jPanel1.add(lblDayOfBirth, gridBagConstraints);

        lblAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddress.setText("Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        jPanel1.add(lblAddress, gridBagConstraints);

        lblWorkName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWorkName.setText("Work name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        jPanel1.add(lblWorkName, gridBagConstraints);

        lblPosition.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPosition.setText("Position:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        jPanel1.add(lblPosition, gridBagConstraints);

        lblContactNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactNumber.setText("Contact number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        jPanel1.add(lblContactNumber, gridBagConstraints);

        txtFullName.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel1.add(txtFullName, gridBagConstraints);

        txtAddress.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel1.add(txtAddress, gridBagConstraints);

        txtWorkName.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel1.add(txtWorkName, gridBagConstraints);

        txtPosition.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel1.add(txtPosition, gridBagConstraints);

        txtContactNumber.setColumns(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel1.add(txtContactNumber, gridBagConstraints);

        dcsDayOfBirth.setDateFormatString("MM/dd/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel1.add(dcsDayOfBirth, gridBagConstraints);

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
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.35;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Refer list", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        scrRefer.setPreferredSize(new java.awt.Dimension(452, 250));

        tblRefer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Full name", "Day of birth", "Position", "Address"
            }
        ));
        tblRefer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReferMouseClicked(evt);
            }
        });
        scrRefer.setViewportView(tblRefer);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(scrRefer, gridBagConstraints);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdd);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/edit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel4.add(btnEdit);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/delete2.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel4.add(btnDelete);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.65;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblReferMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReferMouseClicked
        index = tblRefer.getSelectedRow();
        if (index > -1) {
            btnDelete.setEnabled(true);
            btnEdit.setEnabled(true);
            txtAddress.setText(arrRefers.get(index).getAddress());
            txtContactNumber.setText(arrRefers.get(index).getContactNumber());
            txtFullName.setText(arrRefers.get(index).getFullName());
            txtPosition.setText(arrRefers.get(index).getPosition());
            txtWorkName.setText(arrRefers.get(index).getWorkName());
            dcsDayOfBirth.setDate(arrRefers.get(index).getDayOfBirth());
        }
    }//GEN-LAST:event_tblReferMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        disableFields();

    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        selection = 0;
        enableFields();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        selection = -1;
        index = tblRefer.getSelectedRow();
        Refer refer = new Refer();
        refer = arrRefers.get(index);
        int i = JOptionPane.showConfirmDialog(this, "Are you sure want to delete all data related to Refer Name = " + refer.getFullName(), "Question", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            referSer = new ReferServices();
            if (referSer.remove(refer.getReferID())) {
                JOptionPane.showMessageDialog(this, referSer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                loadDataOnTable();
                clearFields();
                disableFields();
            } else {
                JOptionPane.showMessageDialog(this, referSer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Refer refer = new Refer();
        if (selection == 0) {
            index = tblRefer.getSelectedRow();
            refer = arrRefers.get(index);
        }
        if (!CheckForm.checkPhoneNumber(txtContactNumber.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Contact number not valid!", "Warning", JOptionPane.WARNING_MESSAGE);
            txtContactNumber.requestFocus();
            return;
        }
        refer.setContactNumber(txtContactNumber.getText().trim());
        refer.setAddress(txtAddress.getText().trim());

        //convert date calender to date SQL
        if (dcsDayOfBirth.getDate() != null) {
            Calendar ca = Calendar.getInstance();
            ca.setTime(dcsDayOfBirth.getDate());
            Date date = new Date(ca.getTimeInMillis());
            refer.setDayOfBirth(date);
            refer.setFullName(txtFullName.getText().trim());
            refer.setPosition(txtPosition.getText().trim());
            refer.setWorkName(txtWorkName.getText().trim());
            referSer = new ReferServices();
            if (selection == 1) {
                if (referSer.create(refer)) {
                    JOptionPane.showMessageDialog(this, referSer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                    loadDataOnTable();
                    disableFields();
                } else {
                    JOptionPane.showMessageDialog(this, referSer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                if (selection == 0) {
                    if (referSer.store(refer)) {
                        JOptionPane.showMessageDialog(this, referSer.getLastError(), "Message", JOptionPane.INFORMATION_MESSAGE);
                        loadDataOnTable();
                        disableFields();
                    } else {
                        JOptionPane.showMessageDialog(this, referSer.getLastError(), "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Day of birth can not empty or the date is not valid!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        enableFields();
        clearFields();
        selection = 1;
    }//GEN-LAST:event_btnAddActionPerformed

    private void clearFields() {
        txtAddress.setText("");
        txtContactNumber.setText("");
        txtFullName.setText("");
        txtPosition.setText("");
        txtWorkName.setText("");
        dcsDayOfBirth.setDate(null);
    }

    private void disableFields() {
        clearFields();
        txtAddress.setEditable(false);
        txtContactNumber.setEditable(false);
        txtFullName.setEditable(false);
        txtPosition.setEditable(false);
        txtWorkName.setEditable(false);
        dcsDayOfBirth.setEnabled(false);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);

    }

    private void enableFields() {
        txtAddress.setEditable(true);
        txtContactNumber.setEditable(true);
        txtFullName.setEditable(true);
        txtPosition.setEditable(true);
        dcsDayOfBirth.setEnabled(true);

        txtWorkName.setEditable(true);
        btnCancel.setEnabled(true);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
    }

    /**
     *
     */
    private void loadDataOnTable() {
        referSer = new ReferServices();
        arrRefers = referSer.findByAll();
        //JOptionPane.showMessageDialog(this, arrRefers.get(arrRefers.size() -1).getFullName(), "Warning", JOptionPane.WARNING_MESSAGE);
        ColumnData[] columns = {
            new ColumnData("Full Name", 100, SwingConstants.LEFT, 1),
            new ColumnData("Day Of Birth", 80, SwingConstants.LEFT, 2),
            new ColumnData("Position", 80, SwingConstants.LEFT, 3),
            new ColumnData("Address", 80, SwingConstants.LEFT, 4)
        };

        tableModel = new ObjectTableModel(tblRefer, columns, arrRefers);

        headerTable = tableModel.getHeaderTable();
        //tao cot stt tu dong
        headerTable.createDefaultColumnsFromModel();
        tblRefer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Put it in a viewport that we can control a bit
        JViewport viewport = new JViewport();

        //hien thi du lieu cot stt
        viewport.setView(headerTable);
        viewport.setPreferredSize(headerTable.getMaximumSize());
        scrRefer.setRowHeader(viewport);
        scrRefer.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER, headerTable.getTableHeader());

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ReferManagementDlg dialog = new ReferManagementDlg(new javax.swing.JFrame(), true);
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
    private com.toedter.calendar.JDateChooser dcsDayOfBirth;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblDayOfBirth;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWorkName;
    private javax.swing.JScrollPane scrRefer;
    private javax.swing.JTable tblRefer;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtWorkName;
    // End of variables declaration//GEN-END:variables
}
