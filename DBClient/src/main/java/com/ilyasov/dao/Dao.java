package com.ilyasov.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public abstract class Dao {
    protected static Connection connection;
    PreparedStatement preparedStatement;
    protected Scanner scanner = new Scanner(System.in);
    static {
        connection = PostgreSQL.getConnection();
    }
}
