package com.ilyasov.model;

import com.ilyasov.dao.RequestDAO;
import com.ilyasov.enums.ApplicationMessages;

import java.sql.SQLException;

public class Request {
    public static void addToDatabase(){
        RequestDAO requestDAO = new RequestDAO();
        try {
            requestDAO.addRequest();
        } catch (SQLException e) {
            System.out.println(ApplicationMessages.OPERATION_IS_NOT_COMPLETED);
        }
    }
}
