package com.ilyasov.servlets;

import com.ilyasov.service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result ="";
        double firstNum = Double.parseDouble(request.getParameter("firstNum"));
        double secondNum = Double.parseDouble(request.getParameter("secondNum"));
        char operation =request.getParameter("operation").charAt(0);
        CalculatorService service = new CalculatorService();
        try {
            result = String.valueOf(service.service(firstNum, secondNum, operation));
        }catch (ArithmeticException e){
            result = "Can't divide by 0";
        }
        request.setAttribute("result",result);
        request.getRequestDispatcher("jsp/result.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
