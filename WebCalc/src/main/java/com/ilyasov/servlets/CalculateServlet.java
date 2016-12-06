package com.ilyasov.servlets;

import com.ilyasov.service.CalculateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(405);
        response.getWriter().print("Method POST is not allowed here");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getRequestURI();
        PrintWriter out = response.getWriter();
        CalculateService calculateService = new CalculateService();
        out.print(calculateService.calculate(input));
    }
}
