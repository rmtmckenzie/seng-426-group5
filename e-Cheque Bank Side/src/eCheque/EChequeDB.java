/*
 * EChequeDB.java
 *
 * Created on June 6, 2007, 6:02 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package eCheque;

import javax.swing.JOptionPane;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Saad
 */
public class EChequeDB {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String database_url;
    private String userName;
    private String password;
    private Connection connection = null;
    private Statement sqlStatement = null;
    private ResultSet resultSet;

    /**
     * Creates a new instance of EChequeDB
     */
    public EChequeDB() {
        try {
            // Read in the db.config file.
            // Format
            // jdbc:mysql://localhost/ebank
            // username
            // password
            FileInputStream fis = new FileInputStream("db.config");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            database_url = br.readLine();
            userName = br.readLine();
            password = br.readLine();
            br.close();
        } catch (IOException exp) {
            database_url = "";
            userName = "";
            password = "";
            exp.printStackTrace();
        }
    }

    private boolean connectToDataBase() throws ClassNotFoundException, SQLException {
        // Initialize Connection to DB:
        Class.forName(JDBC_DRIVER); // load database driver class
        connection = DriverManager.getConnection(database_url, userName, password);
        return true;
    }

    private boolean closeDataBaseConnection() {
        try {
            connection.close();
            if(sqlStatement != null){
                sqlStatement.close();
            }
            return true;
        } catch (SQLException exp) {
            exp.printStackTrace();
            return false;
        }
    }

    public boolean runQuery(String statement, Object ... objects) {
        boolean result = false;
        
        try {
            connectToDataBase();
            PreparedStatement s = connection.prepareStatement(statement);
            for(int i = 0; i < objects.length; i++) {
                s.setObject(i + 1, objects[i]);
            }
            resultSet = s.executeQuery();
            result = resultSet.next();
        } catch (SQLException exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EChequeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDataBaseConnection();
        }
        
        return result;
    }
    
    public boolean runUpdate(String statement, Object ... objects) {
        boolean result = false;
        
        try {
            connectToDataBase();
            PreparedStatement s = connection.prepareStatement(statement);
            for(int i = 0; i < objects.length; i++) {
                s.setObject(i + 1, objects[i]);
            }
            s.executeUpdate();
            result = true;
        } catch (SQLException exp) {
            //JOptionPane.showMessageDialog(null, exp.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
				Logger.getLogger(EChequeDB.class.getName()).log(Level.SEVERE, null, exp);
            exp.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EChequeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDataBaseConnection();
        }
        
        return result;
    }
    
    public Object runReturnQuery(String statement, Object ... objects) {
        Object obj = null;
        boolean flag = runQuery(statement, objects);
        if(flag){
            try {
                obj =  resultSet.getObject(userName);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        return obj;
    }
}
