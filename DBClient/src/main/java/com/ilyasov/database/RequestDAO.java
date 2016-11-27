package com.ilyasov.database;

import com.ilyasov.DAO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RequestDAO extends DAO {

    public void addRequest() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Statement statement = connection.createStatement();
        preparedStatement = connection.prepareStatement("INSERT INTO request (id, needy_id, address, latitude, longitude, created_at, service_type, status) " +
                "VALUES (?,?,?,?,?,?,?,?)");
        ResultSet resultSet = statement.executeQuery("SELECT max(id) FROM request");
        resultSet.next();
        long id = resultSet.getLong(1) + 1;
        System.out.println("Введите id того, кому нужна помощь:");
        long needyId = Long.parseLong(scanner.nextLine());
        System.out.println("Введите адрес:");
        String adress = scanner.nextLine();
        System.out.println("Введите ширину");
        Float latitude = Float.valueOf(scanner.nextLine());
        System.out.println("Введите высоту");
        Float longitude = Float.valueOf(scanner.nextLine());
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println("Введите тип услуги:");
        String serviceType = scanner.nextLine();
        String status = "PENDING";
        preparedStatement.setLong(1, id);
        preparedStatement.setLong(2, needyId);
        preparedStatement.setString(3, adress);
        preparedStatement.setFloat(4, latitude);
        preparedStatement.setFloat(5, longitude);
        preparedStatement.setTimestamp(6,timestamp);
        preparedStatement.setString(7, serviceType);
        preparedStatement.setString(8, status);
        preparedStatement.executeUpdate();
        System.out.println("Заявка успешно добавлена!");
    }
}
