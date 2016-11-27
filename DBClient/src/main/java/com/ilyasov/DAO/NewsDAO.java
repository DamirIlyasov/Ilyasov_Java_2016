package com.ilyasov.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NewsDAO {
    private static Connection connection;
    private PreparedStatement preparedStatement;
    private Scanner scanner = new Scanner(System.in);

    static {
        connection = PostgreSQL.getConnection();
    }

    public void changeNews() throws SQLException {

        preparedStatement = connection.prepareStatement("UPDATE news SET text = ? WHERE " +
                "id = ?");
        System.out.println("Введите id новости, которую Вы хотите изменить:");
        String newsId = scanner.nextLine();
        System.out.println("Введите новый текст новости:");
        String newsText = scanner.nextLine();
        preparedStatement.setLong(2, Long.parseLong(newsId));
        preparedStatement.setString(1, newsText);
        preparedStatement.executeUpdate();
        System.out.println("Новость успешно изменена!");

    }
}
