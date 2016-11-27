package com.ilyasov.DAO;

import com.ilyasov.Request;
import com.ilyasov.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MostActiveRecipient extends Dao {
    private final String request = "WITH user_msg AS (SELECT u.id,u.name,u.surname,count(m_r.id) msg_total FROM users u LEFT JOIN message m_r ON u.id = m_r.recipient_id AND(date_part('month', m_r.created_at) = ? OR date_part('month', m_r.created_at) = ? OR date_part('month', m_r.created_at) = ?) GROUP BY u.id) SELECT user_msg.id,user_msg.name,user_msg.surname FROM user_msg WHERE user_msg.msg_total = (SELECT max(user_msg.msg_total)FROM user_msg)";
    public List<User> getTheMostActiveRecipient() throws SQLException {
        preparedStatement = connection.prepareStatement(request);
        System.out.println("За какое время года вы хотите увидеть статистику? " + '\n' +
                "1)Зима" + '\n' +
                "2)Весна" + '\n' +
                "3)Лето" + '\n' +
                "4)Осень");
        String season = scanner.nextLine();
        if (season.equals("1")) {
            preparedStatement.setInt(1, 12);
            preparedStatement.setInt(2, 1);
            preparedStatement.setInt(3, 2);
        } else {
            if (season.equals("3")) {
                preparedStatement.setInt(1, 6);
                preparedStatement.setInt(2, 7);
                preparedStatement.setInt(3, 8);
            } else {
                if (season.equals("4")) {
                    preparedStatement.setInt(1, 9);
                    preparedStatement.setInt(2, 10);
                    preparedStatement.setInt(3, 11);
                } else {
                    if (season.equals("2")) {
                        preparedStatement.setInt(1, 3);
                        preparedStatement.setInt(2, 4);
                        preparedStatement.setInt(3, 5);
                    } else {
                        throw new SQLException();
                    }
                }
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        return User.buildListOfUsers(resultSet);
    }
}
