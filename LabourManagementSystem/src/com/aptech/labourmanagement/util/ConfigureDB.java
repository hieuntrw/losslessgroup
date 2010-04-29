/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lab
 */
public class ConfigureDB {

    Connection con = null;

    public Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=LabourManagementSystem";
        String user = "sa";
        String pass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(ConfigureDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfigureDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void closeConnection() {
        try {
            if (!con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfigureDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
