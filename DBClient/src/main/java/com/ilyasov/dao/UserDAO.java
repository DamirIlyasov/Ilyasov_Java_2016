package com.ilyasov.dao;

import com.ilyasov.enums.UserRole;
import com.ilyasov.enums.UserStatus;
import com.ilyasov.model.News;
import com.ilyasov.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAO extends Dao {
    private final String MOST_ACTIVE_VOLUNTEER_REQUEST = "WITH volunteers AS (SELECT u.id, u.name, u.surname, count(r_v) r_v_total FROM users u JOIN request r_v ON u.id = r_v.volunteer_id AND r_v.address LIKE ? GROUP BY u.id) SELECT volunteers.id, volunteers.name, volunteers.surname FROM volunteers WHERE r_v_total = (SELECT max(volunteers.r_v_total) FROM volunteers)";
    private final String ADD_USER_REQUEST = "INSERT INTO users (name, surname, email, password, role, status) VALUES (?,?,?,?,?,?)";
    private final String MOST_ACTIVE_RECIPIENT_REQUEST = "WITH user_msg AS (SELECT u.id,u.name,u.surname,count(m_r.id) msg_total FROM users u LEFT JOIN message m_r ON u.id = m_r.recipient_id AND(date_part('month', m_r.created_at) = ? OR date_part('month', m_r.created_at) = ? OR date_part('month', m_r.created_at) = ?) GROUP BY u.id) SELECT user_msg.id,user_msg.name,user_msg.surname FROM user_msg WHERE user_msg.msg_total = (SELECT max(user_msg.msg_total)FROM user_msg)";
    private final String PERCENTAGE_OF_BANNED_USERS = "SELECT ((SELECT count(*)FROM users WHERE status = 'BANNED')*100/(SELECT count(*) FROM users )) percents";
    List<News> newsList = new ArrayList<News>();

    public List<News> getOneUsersNews(long id) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM news WHERE author_id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            News news = new News();
            news.setId(resultSet.getLong(1));
            news.setText(resultSet.getString(2));
            news.setCommunityId(resultSet.getLong(3));
            news.setCreatedAt(resultSet.getTimestamp(5));
            newsList.add(news);
        }
        return newsList;
    }
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
    public List<User> getTheMostActiveRecipient(int season) throws SQLException {
        preparedStatement = connection.prepareStatement(MOST_ACTIVE_RECIPIENT_REQUEST);
        System.out.println("За какое время года вы хотите увидеть статистику? " + '\n' +
                "1)Зима" + '\n' +
                "2)Весна" + '\n' +
                "3)Лето" + '\n' +
                "4)Осень");
        if (season == 1) {
            preparedStatement.setInt(1, 12);
            preparedStatement.setInt(2, 1);
            preparedStatement.setInt(3, 2);
        } else {
            if (season == 2) {
                preparedStatement.setInt(1, 3);
                preparedStatement.setInt(2, 4);
                preparedStatement.setInt(3, 5);
            } else {
                if (season == 3) {
                    preparedStatement.setInt(1, 6);
                    preparedStatement.setInt(2, 7);
                    preparedStatement.setInt(3, 8);
                } else {
                    if (season == 4) {
                        preparedStatement.setInt(1, 9);
                        preparedStatement.setInt(2, 10);
                        preparedStatement.setInt(3, 11);
                    } else {
                        throw new SQLException();
                    }
                }
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        return User.buildListOfUsers(resultSet);

    }
    public List<User> getTheMostActiveVolunteer(String regEx) throws SQLException {
        preparedStatement = connection.prepareStatement(MOST_ACTIVE_VOLUNTEER_REQUEST);
        regEx = "%" + regEx + "%";
        preparedStatement.setString(1, regEx);
        ResultSet resultSet = preparedStatement.executeQuery();
        return User.buildListOfUsers(resultSet);
    }
    public int getThePercentageOfBannedUsers() throws SQLException {
        preparedStatement = connection.prepareStatement(PERCENTAGE_OF_BANNED_USERS);
        ResultSet resultSet= preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }
}
