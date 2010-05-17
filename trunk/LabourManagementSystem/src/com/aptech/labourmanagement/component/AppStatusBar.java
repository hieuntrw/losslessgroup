package com.aptech.labourmanagement.component;

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
    private String username;
    private String permission;
    private StatusBarFactory statusBarFactory;
    private StatusBar bar;
    private JLabel user = null;
    private JLabel permi = null;
    
    /** Creates a new instance of AppStatusBar */
    public AppStatusBar(String username, String permission) {
        this.username = username;
        this.permission = permission;
        this.initAppStatusBar();
    }
    
    public void initAppStatusBar() {
        String TIME_FORMAT = "MM'/'dd'/'yyyy' 'h':'mm' 'a";
        final SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        Calendar calCurrent = Calendar.getInstance(TimeZone.getDefault());
        sdf.setTimeZone(TimeZone.getDefault());
        statusBarFactory = new StatusBarFactory("../icon/"); 
        
        //final JLabel statusZone = statusBarFactory.addZone("statusZone", "75%", "Ready");
        user = statusBarFactory.addZone("user", "25%", "Username: "+username);
        statusBarFactory.addSeparator("sepICone", "0.2%", "separator.png");
        permi = statusBarFactory.addZone("permi", "50%", "Permission: "+permission);
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