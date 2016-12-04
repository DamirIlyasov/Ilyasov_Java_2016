package com.ilyasov.servlets;

import com.ilyasov.servlets.CalculateServlet;
import org.junit.*;
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
    private static CalculateServlet calculateServlet;
    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static PrintWriter printWriter;

    @BeforeClass
    public static void setUp() throws IOException {
       calculateServlet = new CalculateServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        printWriter = mock(PrintWriter.class);
        when(request.getRequestURI()).thenReturn("/calculate/5.0+1.0");
        when(response.getWriter()).thenReturn(printWriter);

    }

    @Test
    public void doGetShouldWorkCorrect() throws ServletException, IOException {
        calculateServlet.doGet(request,response);
        verify(request).getRequestURI();
            verify(printWriter).print("6.0");
    }
    @Test
    public void doPostShouldWorkCorrect() throws ServletException, IOException {
        calculateServlet.doPost(request,response);
        verify(response).setStatus(405);
        verify(printWriter).print("Method post is not allowed here");
    }
}
