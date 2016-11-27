package com.ilyasov.database;

import com.ilyasov.DAO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MessageDAO extends DAO {


    public void addMessage() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ваш id:");
        long senderId = Long.parseLong(scanner.nextLine());
        System.out.println("Введите текст сообщения:");
        String text = scanner.nextLine();
        System.out.println("Введите id получателя");
        long recipientId = Long.parseLong(scanner.nextLine());
        String status = "NEW";
        Statement statement = connection.createStatement();
        preparedStatement = connection.prepareStatement("INSERT INTO message" +
                "(id, text, sender_id, recipient_id, created_at, status) VALUES (?,?,?,?,?,?)");
        ResultSet resultSet = statement.executeQuery("SELECT max(id) FROM message");
        long id = 0;
        while (resultSet.next()) {
            id = resultSet.getLong(1) + 1;
        }
        Timestamp timestamp = new Timestamp(new Date().getTime());
//        Date date = new Date();
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        preparedStatement.setTimestamp(5, timestamp);
        preparedStatement.setLong(1, id);
        preparedStatement.setString(2, text);
        preparedStatement.setLong(3, senderId);
        preparedStatement.setLong(4, recipientId);
        preparedStatement.setString(6, status);
        preparedStatement.executeUpdate();
        System.out.println("Сообщение успешно добавлено!");

    }

}
