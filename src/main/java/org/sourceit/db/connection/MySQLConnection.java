package org.sourceit.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum MySQLConnection {

    INSTANCE;

    private Connection connection;

    MySQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            throw new RuntimeException("no class in classpath");
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/PERSONS_DATABASE?user=root&password=admin");
        } catch (SQLException e) {
            throw new RuntimeException("something wrong", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
