package com.ilyasov.reports;

import java.sql.Timestamp;
import java.util.Date;

public class News {
    private long id;
    private String text;
    private long communityId;
    private Timestamp createdAt;

    void setId(long id) {
        this.id = id;
    }

    public long getId() {

        return id;
    }

    public String getText() {
        return text;
    }

    public long getCommunityId() {
        return communityId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    void setText(String text) {

        this.text = text;
    }

    void setCommunityId(long communityId) {
        this.communityId = communityId;
    }

    void setCreatedAt(Timestamp createdAt) {
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
