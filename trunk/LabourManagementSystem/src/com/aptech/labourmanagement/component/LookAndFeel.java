package com.aptech.labourmanagement.component;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Container;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Nguyen Thi My Ha
 */
public class LookAndFeel {

    private Container container;

    public LookAndFeel(Container container) {
        this.container = container;
        this.setLookAndFeel();
    }

    /**
     * set look and feel
     */
    private void setLookAndFeel() {
        try {
            com.jgoodies.looks.plastic.PlasticLookAndFeel.setCurrentTheme(new com.jgoodies.looks.plastic.theme.ExperienceBlue());
            UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
            //            UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
            //            UIManager.setLookAndFeel("org.jdesktop.layout.LayoutStyle");
            SwingUtilities.updateComponentTreeUI(container);
        } catch (Exception ex) {
            System.out.println("error: "+ex.getMessage());
        }
    }
}
