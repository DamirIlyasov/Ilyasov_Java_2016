package com.ilyasov.model;

import com.ilyasov.dao.MessageDAO;
import com.ilyasov.enums.ApplicationMessages;

import java.sql.SQLException;

public class Message {
    public static void addToDatabase() {
        MessageDAO messageDAO = new MessageDAO();
        try {
            messageDAO.addMessage();
        } catch (SQLException e) {
            System.out.println(ApplicationMessages.OPERATION_IS_NOT_COMPLETED);
        }
    }

}
