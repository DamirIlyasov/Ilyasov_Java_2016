package com.ilyasov.DAO;

import com.ilyasov.model.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OneUserNews extends Dao {
    List<News> newsList = new ArrayList<News>();

    public List<News> getOneUsersNews() throws SQLException {
        System.out.println("Введите id пользователя, чьи новости вы хотите посмотреть");
        long authorId = Long.parseLong(scanner.nextLine());
        preparedStatement = connection.prepareStatement("SELECT * FROM news WHERE author_id = ?");
        preparedStatement.setLong(1, authorId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            News news = new News();
            news.setId(resultSet.getLong(1));
            news.setText(resultSet.getString(2));
            news.setCommunityId(resultSet.getLong(3));
            news.setCreatedAt(resultSet.getTimestamp(5));
            newsList.add(news);
        }
        return newsList;
    }
}
