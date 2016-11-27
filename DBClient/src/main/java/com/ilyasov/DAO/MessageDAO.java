package com.ilyasov.DAO;

import com.ilyasov.ENUMS.MessageStatus;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class MessageDAO extends Dao {

    private final String addMessageRequest = "INSERT INTO message (text, sender_id, recipient_id, created_at, status) VALUES (?,?,?,?,?)";
    public void addMessage() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ваш id:");
        long senderId = Long.parseLong(scanner.nextLine());
        System.out.println("Введите текст сообщения:");
        String text = scanner.nextLine();
        System.out.println("Введите id получателя");
        long recipientId = Long.parseLong(scanner.nextLine());
        preparedStatement = connection.prepareStatement(addMessageRequest);
        Timestamp timestamp = new Timestamp(new Date().getTime());
        preparedStatement.setTimestamp(4, timestamp);
        preparedStatement.setString(1, text);
        preparedStatement.setLong(2, senderId);
        preparedStatement.setLong(3, recipientId);
        preparedStatement.setString(5, MessageStatus.NEW);
        preparedStatement.executeUpdate();
        System.out.println("Сообщение успешно добавлено!");

    }

}
