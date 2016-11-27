package com.ilyasov.reports;

import com.ilyasov.DAO;
import com.ilyasov.reports.classes.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MostActiveVolunteer extends DAO {

    private final String request = "WITH volunteers AS (SELECT u.id, u.name, u.surname, count(r_v) r_v_total FROM users u JOIN request r_v ON u.id = r_v.volunteer_id AND r_v.address LIKE ? GROUP BY u.id) SELECT volunteers.id, volunteers.name, volunteers.surname FROM volunteers WHERE r_v_total = (SELECT max(volunteers.r_v_total) FROM volunteers)";

    public List<User> getTheMostActiveVolunteer() throws SQLException {
        preparedStatement = connection.prepareStatement(request);
        System.out.println("По какому адресу будет сортировать?");
        String regEx = scanner.nextLine();
        regEx = "%" + regEx + "%";
        preparedStatement.setString(1, regEx);
        ResultSet resultSet = preparedStatement.executeQuery();
        return User.buildListOfUsers(resultSet);
    }
}
