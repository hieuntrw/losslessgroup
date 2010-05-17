package com.aptech.labourmanagement.component;

import com.aptech.labourmanagement.entity.Account;
import com.aptech.labourmanagement.gui.main.MainFrm;
import com.l2fprod.common.swing.StatusBar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.JLabel;

/**
 * 
 * @author Noi Nho
 */
public class AppStatusBar {
    //public String username = "";
    public StatusBarFactory statusBarFactory;
    private StatusBar bar;
    private JLabel user = null;
    
    /** Creates a new instance of AppStatusBar */
    public AppStatusBar(String username, String permision) {
        this.initAppStatusBar(username,permision);
    }
    
    public void initAppStatusBar(String username, String permision) {
        String TIME_FORMAT = "MM'/'dd'/'yyyy' 'h':'mm' 'a";
        final SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        Calendar calCurrent = Calendar.getInstance(TimeZone.getDefault());
        sdf.setTimeZone(TimeZone.getDefault());
        statusBarFactory = new StatusBarFactory("../icon/");  //thu muc icon nam ngay tai thu muc goc cua project
        
        //final JLabel statusZone = statusBarFactory.addZone("statusZone", "75%", "Ready");
        user = statusBarFactory.addZone("user", "75%", "Username: "+username);
        statusBarFactory.addSeparator("sepIZone", "0.2%", "separator.png");
        final JLabel timerZone = statusBarFactory.addZone("timerZone", "*", "Time: " + sdf.format(calCurrent.getTime()));
        
        Runnable r = new Runnable() {
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
                        timerZone.setText("Date time: " + sdf.format(cal.getTime()));
                    }
                } catch ( Exception x ) {
                    x.printStackTrace();
                }
            }
        };
        Thread timerThread = new Thread(r);
        timerThread.start();
        
        bar = statusBarFactory.getStatusBar();        
    }
    
    public void setCurrentStatus(String status) {
        ((JLabel) this.bar.getZone("statusZone")).setText(status);
    }
    
    public StatusBar getBar() {
        return this.bar;
    }
    
}