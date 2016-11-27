package com.ilyasov.model;

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
