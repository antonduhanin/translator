package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ANTON DUKHANIN on 06.02.2018.
 */
    public class DataSource {
        private static DataSource dataSource;
        private ComboPooledDataSource comboPooledDataSource;

        private DataSource() {
            comboPooledDataSource = new ComboPooledDataSource();
            try {
                comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost:5433/words");
                comboPooledDataSource.setUser("postgres");
                comboPooledDataSource.setPassword("root");
                comboPooledDataSource.setDriverClass("org.postgresql.Driver");
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }

        public static DataSource getInstance() {
            if (dataSource == null)
                dataSource = new DataSource();
            return dataSource;
        }

        public Connection getConnection() {
            Connection con = null;
            try {
                con = comboPooledDataSource.getConnection();
                con.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return con;
        }
    }
