package com.ilyasov.servlets;

import com.ilyasov.Calculator;
import com.ilyasov.service.CalculateService;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculateServletTest {
    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static PrintWriter printWriter;
    private static CalculateServlet calculateServlet;
    private static final String INPUT = "/calculate/6.0+2.0";
    private static CalculateService calculateService;
    private static Calculator calculator;
    private final String ERROR_MSG = "Method POST is not allowed here";

    @BeforeClass
    public static void setUp() throws IOException {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        calculateServlet = new CalculateServlet();
        printWriter = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(printWriter);
        when(request.getRequestURI()).thenReturn(INPUT);
        calculateService = mock(CalculateService.class);
        calculator = mock(Calculator.class);
        when(calculateService.calculate(INPUT)).thenReturn("8.0");
    }

    @Test
    public void doPostShouldPrintErrorMsgAndSetStatus() throws IOException, ServletException {
        calculateServlet.doPost(request, response);
        verify(response.getWriter()).print(ERROR_MSG);
        verify(response).setStatus(405);
    }

    @Test
    public void doGetShouldTakeRequestURI() throws ServletException, IOException {
        calculateServlet.doGet(request, response);
        verify(request).getRequestURI();
    }

}
