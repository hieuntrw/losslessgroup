/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrm.java
 *
 * Created on May 6, 2010, 10:48:07 PM
 */
package com.aptech.labourmanagement.gui.main;

import com.aptech.labourmanagement.component.AppStatusBar;
import com.aptech.labourmanagement.component.LookAndFeel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Noi Nho
 */
public class MainFrm extends javax.swing.JFrame {

    /** Creates new form MainFrm */
    public MainFrm() {
        initComponents();

        // Cach lam cho form xuat hien giua man hinh
        this.setSize(1000, 735);
        int width = this.getWidth();
        int heigh = this.getHeight();
        int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.setBounds((screenWidth - width) / 2, (screenHeight - heigh) / 2, width, heigh);
        setIconImage(new ImageIcon(getClass().getResource("../../icon/LMSIcon.png")).getImage());
        this.initStatusBar();
        new LookAndFeel(this);
    }

    private void initStatusBar() {
        AppStatusBar status = new AppStatusBar();
        this.pnlStatus.add(status.getBar());
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

        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAccount = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnLabor = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnAttendance = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnWeeklySalary = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnWeeklyAttendance = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlStatus = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnSystem = new javax.swing.JMenu();
        mniLogin = new javax.swing.JMenuItem();
        mniChangePass = new javax.swing.JMenuItem();
        mniLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniExit = new javax.swing.JMenuItem();
        mnAccountManagement = new javax.swing.JMenu();
        mniRoleFunction = new javax.swing.JMenuItem();
        mniAccount = new javax.swing.JMenuItem();
        mnLaborManagement = new javax.swing.JMenu();
        mniRefer = new javax.swing.JMenuItem();
        mniFamily = new javax.swing.JMenuItem();
        mniSalaryGrade = new javax.swing.JMenuItem();
        mniLabor = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mniLaborInfor = new javax.swing.JMenuItem();
        mnAttendanceManagement = new javax.swing.JMenu();
        mniShift = new javax.swing.JMenuItem();
        mniAttendance = new javax.swing.JMenuItem();
        mnReport = new javax.swing.JMenu();
        mniSalaryReport = new javax.swing.JMenuItem();
        mniAttendanceReport = new javax.swing.JMenuItem();
        mnHelp = new javax.swing.JMenu();
        mniHelp = new javax.swing.JMenuItem();
        mniAbout = new javax.swing.JMenuItem();
        mniContactUs = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Labour Management System");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/id_card.png"))); // NOI18N
        btnAccount.setText("Account");
        btnAccount.setFocusable(false);
        btnAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnAccount);
        jToolBar1.add(jSeparator3);

        btnLabor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/user1_information.png"))); // NOI18N
        btnLabor.setText("Labor");
        btnLabor.setFocusable(false);
        btnLabor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLabor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnLabor);
        jToolBar1.add(jSeparator4);

        btnAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/stopwatch.png"))); // NOI18N
        btnAttendance.setText("Attendance");
        btnAttendance.setFocusable(false);
        btnAttendance.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAttendance.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnAttendance);
        jToolBar1.add(jSeparator5);

        btnWeeklySalary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/column_preferences.png"))); // NOI18N
        btnWeeklySalary.setText("Weekly Salary");
        btnWeeklySalary.setFocusable(false);
        btnWeeklySalary.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnWeeklySalary.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnWeeklySalary);
        jToolBar1.add(jSeparator6);

        btnWeeklyAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/line-chart.png"))); // NOI18N
        btnWeeklyAttendance.setText("Weekly Attendance");
        btnWeeklyAttendance.setFocusable(false);
        btnWeeklyAttendance.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnWeeklyAttendance.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnWeeklyAttendance);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.15;
        jPanel2.add(jToolBar1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.15;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/Hinhnen.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1024, 580));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.7;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        pnlStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        pnlStatus.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.15;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlStatus, gridBagConstraints);

        mnSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/window_time.png"))); // NOI18N
        mnSystem.setText("System");

        mniLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        mniLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/user1.png"))); // NOI18N
        mniLogin.setText("Login");
        mnSystem.add(mniLogin);

        mniChangePass.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mniChangePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/user1_information.png"))); // NOI18N
        mniChangePass.setText("Change password");
        mnSystem.add(mniChangePass);

        mniLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        mniLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/user1_delete.png"))); // NOI18N
        mniLogout.setText("Logout");
        mnSystem.add(mniLogout);
        mnSystem.add(jSeparator1);

        mniExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mniExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/delete2.png"))); // NOI18N
        mniExit.setText("Exit");
        mnSystem.add(mniExit);

        jMenuBar1.add(mnSystem);

        mnAccountManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/users2.png"))); // NOI18N
        mnAccountManagement.setText("Account Management");

        mniRoleFunction.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mniRoleFunction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/certificate.png"))); // NOI18N
        mniRoleFunction.setText("Role");
        mnAccountManagement.add(mniRoleFunction);

        mniAccount.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mniAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/id_card.png"))); // NOI18N
        mniAccount.setText("Account");
        mnAccountManagement.add(mniAccount);

        jMenuBar1.add(mnAccountManagement);

        mnLaborManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/worker.png"))); // NOI18N
        mnLaborManagement.setText("Labor Management");

        mniRefer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mniRefer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/users3_preferences.png"))); // NOI18N
        mniRefer.setText("Refer");
        mnLaborManagement.add(mniRefer);

        mniFamily.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mniFamily.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/users_family.png"))); // NOI18N
        mniFamily.setText("Family Ralate");
        mnLaborManagement.add(mniFamily);

        mniSalaryGrade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        mniSalaryGrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/cashier.png"))); // NOI18N
        mniSalaryGrade.setText("Salary Grade");
        mnLaborManagement.add(mniSalaryGrade);

        mniLabor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mniLabor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/user1_information.png"))); // NOI18N
        mniLabor.setText("Labor");
        mnLaborManagement.add(mniLabor);
        mnLaborManagement.add(jSeparator2);

        mniLaborInfor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mniLaborInfor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/user1_view.png"))); // NOI18N
        mniLaborInfor.setText("Labour Details");
        mnLaborManagement.add(mniLaborInfor);

        jMenuBar1.add(mnLaborManagement);

        mnAttendanceManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/alarmclock.png"))); // NOI18N
        mnAttendanceManagement.setText("Attendance Management");

        mniShift.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mniShift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/clock.png"))); // NOI18N
        mniShift.setText("Shift");
        mnAttendanceManagement.add(mniShift);

        mniAttendance.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mniAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/stopwatch.png"))); // NOI18N
        mniAttendance.setText("Attendance");
        mnAttendanceManagement.add(mniAttendance);

        jMenuBar1.add(mnAttendanceManagement);

        mnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/chart.png"))); // NOI18N
        mnReport.setText("Report");

        mniSalaryReport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mniSalaryReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/column_preferences.png"))); // NOI18N
        mniSalaryReport.setText("Weekly Salary");
        mnReport.add(mniSalaryReport);

        mniAttendanceReport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        mniAttendanceReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/line-chart.png"))); // NOI18N
        mniAttendanceReport.setText("Weekly Attendence");
        mnReport.add(mniAttendanceReport);

        jMenuBar1.add(mnReport);

        mnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/help2.png"))); // NOI18N
        mnHelp.setText("Help");

        mniHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/help.png"))); // NOI18N
        mniHelp.setText("Help");
        mnHelp.add(mniHelp);

        mniAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/about.png"))); // NOI18N
        mniAbout.setText("About");
        mniAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAboutActionPerformed(evt);
            }
        });
        mnHelp.add(mniAbout);

        mniContactUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aptech/labourmanagement/icon/address_book.png"))); // NOI18N
        mniContactUs.setText("Contact Us");
        mnHelp.add(mniContactUs);

        jMenuBar1.add(mnHelp);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAboutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniAboutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnAttendance;
    private javax.swing.JButton btnLabor;
    private javax.swing.JButton btnWeeklyAttendance;
    private javax.swing.JButton btnWeeklySalary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu mnAccountManagement;
    private javax.swing.JMenu mnAttendanceManagement;
    private javax.swing.JMenu mnHelp;
    private javax.swing.JMenu mnLaborManagement;
    private javax.swing.JMenu mnReport;
    private javax.swing.JMenu mnSystem;
    private javax.swing.JMenuItem mniAbout;
    private javax.swing.JMenuItem mniAccount;
    private javax.swing.JMenuItem mniAttendance;
    private javax.swing.JMenuItem mniAttendanceReport;
    private javax.swing.JMenuItem mniChangePass;
    private javax.swing.JMenuItem mniContactUs;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniFamily;
    private javax.swing.JMenuItem mniHelp;
    private javax.swing.JMenuItem mniLabor;
    private javax.swing.JMenuItem mniLaborInfor;
    private javax.swing.JMenuItem mniLogin;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenuItem mniRefer;
    private javax.swing.JMenuItem mniRoleFunction;
    private javax.swing.JMenuItem mniSalaryGrade;
    private javax.swing.JMenuItem mniSalaryReport;
    private javax.swing.JMenuItem mniShift;
    private javax.swing.JPanel pnlStatus;
    // End of variables declaration//GEN-END:variables
}
