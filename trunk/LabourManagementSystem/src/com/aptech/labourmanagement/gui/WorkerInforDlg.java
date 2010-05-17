/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WorkerInforDlg.java
 *
 * Created on May 16, 2010, 11:35:40 PM
 */
package com.aptech.labourmanagement.gui;

import com.aptech.labourmanagement.component.ColumnData;
import com.aptech.labourmanagement.component.LookAndFeel;
import com.aptech.labourmanagement.component.ObjectTableModel;
import com.aptech.labourmanagement.entity.Worker;
import com.aptech.labourmanagement.services.WorkerServices;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/**
 *
 * @author Noi Nho
 */
public class WorkerInforDlg extends javax.swing.JDialog {

    private ObjectTableModel tableModel;
    private JTable headerTable;
    private WorkerServices workerSer;
    private ArrayList<Worker> arrWorker = new ArrayList<Worker>();
    int indexWorkerTAble = -1;

    /** Creates new form WorkerInforDlg */
    public WorkerInforDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../icon/LMSIcon.png")).getImage());
        // Cach lam cho form xuat hien giua man hinh
        this.setSize(845, 620);
        int width = this.getWidth();
        int heigh = this.getHeight();
        int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.setBounds((screenWidth - width) / 2, (screenHeight - heigh) / 2, width, heigh);
        new LookAndFeel(this);
        workerSer = new WorkerServices();
        arrWorker = workerSer.findByAll();
        loadDataOnTableWorker(arrWorker);
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

        pnlRefer = new javax.swing.JPanel();
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
        pnlWorker = new javax.swing.JPanel();
        scrWorker = new javax.swing.JScrollPane();
        tblWorker = new javax.swing.JTable();
        pnlFamily = new javax.swing.JPanel();
        scrFamily = new javax.swing.JScrollPane();
        tblFamily = new javax.swing.JTable();
        pnlOption = new javax.swing.JPanel();
        lblOption = new javax.swing.JLabel();
        cbbOption = new javax.swing.JComboBox();
        lblValue = new javax.swing.JLabel();
        txtValue = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Labor Information");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlRefer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Refer information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlRefer.setPreferredSize(new java.awt.Dimension(200, 210));
        pnlRefer.setLayout(new java.awt.GridBagLayout());

        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFirstName.setText("Full name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        pnlRefer.add(lblFirstName, gridBagConstraints);

        lblDayOfBirth.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDayOfBirth.setText("Day of birth:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        pnlRefer.add(lblDayOfBirth, gridBagConstraints);

        lblAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddress.setText("Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        pnlRefer.add(lblAddress, gridBagConstraints);

        lblWorkName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWorkName.setText("Work name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        pnlRefer.add(lblWorkName, gridBagConstraints);

        lblPosition.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPosition.setText("Position:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        pnlRefer.add(lblPosition, gridBagConstraints);

        lblContactNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactNumber.setText("Contact number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        pnlRefer.add(lblContactNumber, gridBagConstraints);

        txtFullName.setColumns(20);
        txtFullName.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        pnlRefer.add(txtFullName, gridBagConstraints);

        txtAddress.setColumns(20);
        txtAddress.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        pnlRefer.add(txtAddress, gridBagConstraints);

        txtWorkName.setColumns(20);
        txtWorkName.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        pnlRefer.add(txtWorkName, gridBagConstraints);

        txtPosition.setColumns(20);
        txtPosition.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        pnlRefer.add(txtPosition, gridBagConstraints);

        txtContactNumber.setColumns(20);
        txtContactNumber.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        pnlRefer.add(txtContactNumber, gridBagConstraints);

        dcsDayOfBirth.setDateFormatString("MM/dd/yyyy");
        dcsDayOfBirth.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        pnlRefer.add(dcsDayOfBirth, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.45;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlRefer, gridBagConstraints);

        pnlWorker.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Labor list", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlWorker.setPreferredSize(new java.awt.Dimension(450, 200));
        pnlWorker.setLayout(new java.awt.BorderLayout(5, 5));

        scrWorker.setPreferredSize(new java.awt.Dimension(450, 250));

        tblWorker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First name", "Last name", "Day of birth", "Contact", "Salary grade", "Refer", "Is temporary worker", "Is working"
            }
        ));
        scrWorker.setViewportView(tblWorker);

        pnlWorker.add(scrWorker, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlWorker, gridBagConstraints);

        pnlFamily.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ralate family list", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlFamily.setPreferredSize(new java.awt.Dimension(250, 200));
        pnlFamily.setLayout(new java.awt.BorderLayout(5, 5));

        scrFamily.setPreferredSize(new java.awt.Dimension(250, 200));

        tblFamily.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Full name", "Day of birth", "Ralate name", "Address"
            }
        ));
        scrFamily.setViewportView(tblFamily);

        pnlFamily.add(scrFamily, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 0.45;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlFamily, gridBagConstraints);

        pnlOption.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlOption.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblOption.setText("Option:");
        pnlOption.add(lblOption);

        cbbOption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First name", "Last name", "Labor ID" }));
        pnlOption.add(cbbOption);

        lblValue.setText("Value:");
        pnlOption.add(lblValue);

        txtValue.setColumns(20);
        pnlOption.add(txtValue);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/view.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        pnlOption.add(btnSearch);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlOption, gridBagConstraints);

        pnlTitle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlTitle.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Labor Information");
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
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.15;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlTitle, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        int indexSelectOption = cbbOption.getSelectedIndex();
        if (indexSelectOption == 0) {
            //tim theo last name
            //loadData
        }else{
            if(indexSelectOption == 1){
                //tim theo first name
                //loadData
            }else{
                //tim theo laborID
                //loadData
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void loadDataOnTableWorker(ArrayList<Worker> arrWorker) {
//        workerSer = new WorkerServices();
//        arrWorker = workerSer.findByAll();

        ColumnData[] columns = {
            new ColumnData("Last name", 70, SwingConstants.LEFT, 2),
            new ColumnData("First name", 30, SwingConstants.LEFT, 1),
            new ColumnData("Day of birth", 60, SwingConstants.LEFT, 3),
            new ColumnData("Contact", 60, SwingConstants.LEFT, 4),
            new ColumnData("Address", 100, SwingConstants.LEFT, 9),
            new ColumnData("Salary grade", 60, SwingConstants.CENTER, 5),
            new ColumnData("Experience", 40, SwingConstants.CENTER, 12),
            new ColumnData("Temporary worker", 60, SwingConstants.CENTER, 7),
            new ColumnData("Working", 40, SwingConstants.CENTER, 8),
            new ColumnData("Height", 25, SwingConstants.CENTER, 10),
            new ColumnData("Weight", 25, SwingConstants.CENTER, 11),
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
                WorkerInforDlg dialog = new WorkerInforDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cbbOption;
    private com.toedter.calendar.JDateChooser dcsDayOfBirth;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblDayOfBirth;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblOption;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblValue;
    private javax.swing.JLabel lblWorkName;
    private javax.swing.JPanel pnlFamily;
    private javax.swing.JPanel pnlOption;
    private javax.swing.JPanel pnlRefer;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPanel pnlWorker;
    private javax.swing.JScrollPane scrFamily;
    private javax.swing.JScrollPane scrWorker;
    private javax.swing.JTable tblFamily;
    private javax.swing.JTable tblWorker;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtValue;
    private javax.swing.JTextField txtWorkName;
    // End of variables declaration//GEN-END:variables
}
