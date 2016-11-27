package com.ilyasov.DAO;

import java.sql.*;
import java.util.Date;

public class RequestDAO extends Dao {
    private final String addRequestRequest = "INSERT INTO request (needy_id, address, latitude, longitude, created_at, service_type, status) VALUES (?,?,?,?,?,?,?)";
    public void addRequest() throws SQLException {
        preparedStatement = connection.prepareStatement(addRequestRequest);
        System.out.println("Введите id того, кому нужна помощь:");
        long needyId = Long.parseLong(scanner.nextLine());
        System.out.println("Введите адрес:");
        String adress = scanner.nextLine();
        System.out.println("Введите широту");
        Float latitude = Float.valueOf(scanner.nextLine());
        System.out.println("Введите долготу");
        Float longitude = Float.valueOf(scanner.nextLine());
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println("Введите тип услуги:");
        String serviceType = scanner.nextLine();
        String status = "PENDING";
        preparedStatement.setLong(1, needyId);
        preparedStatement.setString(2, adress);
        preparedStatement.setFloat(3, latitude);
        preparedStatement.setFloat(4, longitude);
        preparedStatement.setTimestamp(5, timestamp);
        preparedStatement.setString(6, serviceType);
        preparedStatement.setString(7, status);
        preparedStatement.executeUpdate();
        System.out.println("Заявка успешно добавлена!");
    }
}
