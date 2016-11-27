package com.ilyasov.database;

import com.ilyasov.DAO;

import java.sql.*;
import java.util.Scanner;

public class UserDAO extends DAO {

    public void addUser() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя будущего пользователя:");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию будущего пользователя:");
        String surname = scanner.nextLine();
        System.out.println("Введите email будущего пользователя:");
        String email = scanner.nextLine();
        System.out.println("Введите пароль будущего пользователя:");
        String password = scanner.nextLine();
        System.out.println("Введите 1, если пользователь будет администратором. Введите 2, если это будет обычный пользователь");
        String role = scanner.nextLine();

        if (role.equals("1")) {
            role = "ROLE_ADMIN";
        } else {
            if (role.equals("2")) {
                role = "ROLE_USER";
            } else {
                throw new SQLException();
            }
        }

        String status = "ACTIVE";
        Statement statement = connection.createStatement();
        preparedStatement = connection.prepareStatement("INSERT " +
                "INTO users (id, name, surname, email, password, role, status) VALUES " +
                "(?,?,?,?,?,?,?)");
        ResultSet resultSet = statement.executeQuery("SELECT max(id) FROM users");
        long id = 0;

        while (resultSet.next()) {
            id = resultSet.getLong(1) + 1;
        }

        preparedStatement.setLong(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, surname);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, password);
        preparedStatement.setString(6, role);
        preparedStatement.setString(7, status);
        preparedStatement.executeUpdate();
        System.out.println("Пользователь " + name + " " + surname + " успешно добавлен!");
    }
}
