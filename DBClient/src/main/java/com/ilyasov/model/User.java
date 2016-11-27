package com.ilyasov.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String name;
    private String surname;


    private void setId(long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    public static List<User> buildListOfUsers(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<User>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong(1));
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
            users.add(user);
        }
        return users;
    }

    @Override
    public String toString() {
        return "Информация о пользователе{" +
                "id:" + id + "\n" +
                "Имя:" + name + '\n' +
                "Фамилия:" + surname + '\n' +
                '\n';
    }
}
