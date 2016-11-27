package com.ilyasov.DAO;

import java.sql.SQLException;

public class CommunityDAO extends Dao {
    private final String renameRequest = "UPDATE community SET name = ? WHERE name = ?";
    private final String changeDescriptionRequest = "UPDATE community SET description = ? WHERE name = ?";
    private String chosenCommunity;

    static {
        connection = PostgreSQL.getConnection();
    }

    public void chooseCommunity() {
        System.out.println("Введите название сообщества, которое хотите изменить");
        this.chosenCommunity = scanner.nextLine();
    }

    public void renameCommunity() throws SQLException {
        preparedStatement = connection.prepareStatement(renameRequest);
        System.out.println("Какое название Вы хотите поставить вместо текущего?");
        String nameOfCommunity = scanner.nextLine();
        preparedStatement.setString(1, nameOfCommunity);
        preparedStatement.setString(2, chosenCommunity);
        preparedStatement.executeUpdate();
        System.out.println("Навание сообщества успешно изменено!");
    }

    public void changeDescription() throws SQLException {
        preparedStatement = connection.prepareStatement(changeDescriptionRequest);
        System.out.println("Введите описание сообщества, которое вы хотите установить");
        String description = scanner.nextLine();
        preparedStatement.setString(1, description);
        preparedStatement.setString(2, chosenCommunity);
        preparedStatement.executeUpdate();
        System.out.println("Описание сообщества успешно изменено!");

    }
}