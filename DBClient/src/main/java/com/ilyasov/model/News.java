package com.ilyasov.model;

import com.ilyasov.dao.NewsDAO;
import com.ilyasov.enums.ApplicationMessages;

import java.sql.SQLException;
import java.sql.Timestamp;

public class News {
    private long id;
    private String text;
    private long communityId;
    private Timestamp createdAt;



    public void setId(long id) {
        this.id = id;
    }

    public void setText(String text) {

        this.text = text;
    }
    public static void change(){
        NewsDAO newsDAO = new NewsDAO();
        try {
            newsDAO.changeNews();
        } catch (SQLException e) {
            System.out.println(ApplicationMessages.OPERATION_IS_NOT_COMPLETED);
        }
    }
    public void setCommunityId(long communityId) {
        this.communityId = communityId;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Новость:" +'\n'+
                "id=" + id + '\n'+
                "текст='" + text + '\n' +
                "id сообщества=" + communityId + '\n'+
                "дата написания=" + createdAt+'\n'+
                '\n';
    }
}
