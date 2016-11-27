package com.ilyasov.reports;

import com.ilyasov.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MostActiveRecipient extends DAO {

    private final String request = "WITH user_msg AS (\n" +
            "    SELECT\n" +
            "      u.id,\n" +
            "      u.name,\n" +
            "      u.surname,\n" +
            "      count(m_r.id) msg_total\n" +
            "    FROM users u\n" +
            "      LEFT JOIN message m_r ON u.id = m_r.recipient_id AND\n" +
            "                               (date_part('month', m_r.created_at) = ? OR date_part('month', m_r.created_at) = ? OR\n" +
            "                                date_part('month', m_r.created_at) = ?)\n" +
            "    GROUP BY u.id\n" +
            ")\n" +
            "SELECT\n" +
            "  user_msg.id,\n" +
            "  user_msg.name,\n" +
            "  user_msg.surname\n" +
            "FROM user_msg\n" +
            "WHERE user_msg.msg_total = (SELECT max(user_msg.msg_total)\n" +
            "                            FROM user_msg)";

    public List<User> getTheMostActiveRecipient() throws SQLException {
        preparedStatement = connection.prepareStatement(request);
        System.out.println("За какое время года вы хотите увидеть статистику? :Зима, Лето, Осень или Весна");
        String season = scanner.nextLine();
        if (season.equals("Зима")) {
            preparedStatement.setInt(1,12);
            preparedStatement.setInt(2,1);
            preparedStatement.setInt(3,2);
        } else {
            if (season.equals("Лето")) {
                preparedStatement.setInt(1,6);
                preparedStatement.setInt(2,7);
                preparedStatement.setInt(3,8);
            } else {
                if (season.equals("Осень")) {
                    preparedStatement.setInt(1,9);
                    preparedStatement.setInt(2,10);
                    preparedStatement.setInt(3,11);
                } else {
                    if (season.equals("Весна")) {
                        preparedStatement.setInt(1,3);
                        preparedStatement.setInt(2,4);
                        preparedStatement.setInt(3,5);
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
