package com.ilyasov.servlets;

import com.ilyasov.service.Calculate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(405);
        response.getWriter().print("Method post is not allowed here");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String string = request.getRequestURI();
        Calculate service = new Calculate();
        response.getWriter().print(service.calculate(string));
    }
}
