package com.ilyasov.DAO;

import com.ilyasov.ENUMS.UserRole;
import com.ilyasov.ENUMS.UserStatus;

import java.sql.*;
import java.util.Scanner;

public class UserDAO extends Dao {
    private final String ADD_USER_REQUEST = "INSERT INTO users (name, surname, email, password, role, status) VALUES (?,?,?,?,?,?)";

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
            role = UserRole.ADMIN;
        } else {
            if (role.equals("2")) {
                role = UserRole.USER;
            } else {
                throw new SQLException();
            }
        }
        preparedStatement = connection.prepareStatement(ADD_USER_REQUEST);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        preparedStatement.setString(5, role);
        preparedStatement.setString(6, UserStatus.ACTIVE);
        preparedStatement.executeUpdate();
        System.out.println("Пользователь " + name + " " + surname + " успешно добавлен!");
    }
}
