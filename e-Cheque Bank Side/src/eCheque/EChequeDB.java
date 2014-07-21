/*
 * EChequeDB.java
 *
 * Created on June 6, 2007, 6:02 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package eCheque;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * @author Saad
 */


public class EChequeDB {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/ebank";
    private String userName;
    private String password;
    private Connection connection = null;
    private Statement sqlStatement = null;
    private ResultSet resultSet;

    /**
     * Creates a new instance of EChequeDB
     */
    public EChequeDB() {
        userName = "seng426";
        password = "log2IT05";
    }

    private boolean connectToDataBase() throws ClassNotFoundException, SQLException {
        // Initialize Connection to DB:
        Class.forName(JDBC_DRIVER); // load database driver class
        connection = DriverManager.getConnection(DATABASE_URL, userName, password);
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