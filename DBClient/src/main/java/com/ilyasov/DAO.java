package com.ilyasov;

import com.ilyasov.database.PostgreSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public abstract class DAO {
    protected static Connection connection;
    protected PreparedStatement preparedStatement;
    protected Scanner scanner = new Scanner(System.in);
    static {
        connection = PostgreSQL.getConnection();
    }
}
