package com.ilyasov.servlets;

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
    static HttpServletRequest request;
    static HttpServletResponse response;
    static PrintWriter printWriter;
    static CalculateServlet calculateServlet;
    static final String INPUT = "/calculate/6.0+2.0";
    static CalculateService calculateService;

    @BeforeClass
    public static void setUp() throws IOException {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        calculateServlet = new CalculateServlet();
        printWriter = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(printWriter);
        when(request.getRequestURI()).thenReturn(INPUT);
        calculateService = mock(CalculateService.class);


    }

    @Test
    public void doPostShouldPrintMsgAndSetStatus() throws IOException, ServletException {
        calculateServlet.doPost(request, response);
        verify(response.getWriter()).print("Method post is not allowed here");
        verify(response).setStatus(405);
    }


    @Test
    public void doGetShouldTakeRequestURI() throws ServletException, IOException {
        calculateServlet.doGet(request, response);
        verify(request).getRequestURI();
    }

}
