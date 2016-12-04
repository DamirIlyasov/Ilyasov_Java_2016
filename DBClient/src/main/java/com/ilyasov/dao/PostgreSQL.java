package com.ilyasov.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgreSQL {
    static public Connection getConnection() {
        String url;
        String user;
        String password;
        Connection connection = null;
        InputStream in = UserDAO.class.getClassLoader()
                .getResourceAsStream("persistence.properties");
        Properties properties = new Properties();

        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return connection;
    }
}
