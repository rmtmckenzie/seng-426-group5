/*
 * EChequeDB.java
 *
 * Created on June 6, 2007, 6:02 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package eCheque;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

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
    private int databaseMode;
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
            sqlStatement.close();
            return true;
        } catch (SQLException exp) {
            exp.printStackTrace();
            return false;
        }
    }

    private boolean createStatement() throws SQLException {
        sqlStatement = connection.createStatement();
        return true;
    }

    private void executeSQLStatement(String statement, int statType) throws SQLException {
        // Initialize sql statement and execute it.
        if (statType == 0) {
            resultSet = sqlStatement.executeQuery(statement);
        } else if (statType == 1) {
            sqlStatement.executeUpdate(statement);
        }
    }
    
    public boolean runQuery(String statement, Object ... objects) {
        boolean result = false;
        
        try {
            PreparedStatement s = connection.prepareStatement(statement);
            for(int i = 0; i < objects.length; i++) {
                s.setObject(i + 1, objects[i]);
            }
            resultSet = s.executeQuery();
            result = resultSet.next();
        } catch (SQLException exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();
        } finally {
            closeDataBaseConnection();
        }
        
        return result;
    }
    
    public boolean runUpdate(String statement, Object ... objects) {
        boolean result = false;
        
        try {
            PreparedStatement s = connection.prepareStatement(statement);
            for(int i = 0; i < objects.length; i++) {
                s.setObject(i + 1, objects[i]);
            }
            s.executeUpdate();
            result = true;
        } catch (SQLException exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();
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

    public boolean runDB(int databaseMode, String databaseStat) {
        boolean flag = false;
        try {
            connectToDataBase();
            createStatement();
            executeSQLStatement(databaseStat, databaseMode);
            flag = true;
        } catch (ClassNotFoundException exp) {
            exp.printStackTrace();
        } catch (SQLException exp) {
            exp.printStackTrace();
        } finally {
            closeDataBaseConnection();
        }
        return flag;
    }

    public boolean runDB(int databaseMode, String databaseStat, double[] balance) {
        boolean flag = runDB(databaseStat, databaseMode);
        try {
            balance[0] = flag ? resultSet.getDouble(1) : 0.0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return flag;
    }

    public boolean runDB(String databaseStat, int databaseMode) {
        boolean flag = false;
        try {
            connectToDataBase();
            JOptionPane.showMessageDialog(null, "You are connected to e-Cheque Bank DB", "DB State", JOptionPane.INFORMATION_MESSAGE);
            createStatement();
            JOptionPane.showMessageDialog(null, "You have created statement", "DB State", JOptionPane.INFORMATION_MESSAGE);

            // run the specific sql statement
            executeSQLStatement(databaseStat, databaseMode);
            flag = resultSet.next();
        } catch (ClassNotFoundException exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();

        } catch (SQLException exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();
        } finally {
            closeDataBaseConnection();
        }
        return flag;
    }
}
