package com.ilyasov.service;

import com.ilyasov.Calculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateServiceTest {
    private static CalculateService calculateService;
    private final String INPUT_FOR_SUM = "/calculate/6.0+1.0";
    private final String INPUT_FOR_SUBTRACTION = "/calculate/6.0-1.0";
    private final String INPUT_FOR_MULTIPLICATION = "/calculate/6.0*2.0";
    private final String INPUT_FOR_DIVISION = "/calculate/6.0/2.0";
    private final String INPUT_FOR_DIVISION_BY_ZERO = "/calculate/6.0/0.0";
    private final String INVALID_INPUT = "asdqdasd";
    private final String ERROR_MSG = "Invalid input";
    private final String ERROR_MSG_FOR_DIVIDE_BY_ZERO = "You can't divide by zero";
    private static Calculator calculator;
    @BeforeClass
    public static void setUp(){
        calculateService = new CalculateService();
        calculator = mock(Calculator.class);
    }

    @Test
    public void calculateServiceShouldReturnCorrectSum(){
        when(calculator.sum(6.0,1.0)).thenReturn(7.0);
        Assert.assertEquals("7.0",calculateService.calculate(INPUT_FOR_SUM));
    }
    @Test
    public void calculateServiceShouldReturnCorrectSubtraction(){
        when(calculator.subtraction(6.0,1.0)).thenReturn(5.0);
        Assert.assertEquals("5.0",calculateService.calculate(INPUT_FOR_SUBTRACTION));
    }
    @Test
    public void calculateServiceShouldReturnCorrectMultiplication(){
        when(calculator.multiplication(6.0,2.0)).thenReturn(12.0);
        Assert.assertEquals("12.0",calculateService.calculate(INPUT_FOR_MULTIPLICATION));
    }
    @Test
    public void calculateServiceShouldReturnCorrectDivision(){
        when(calculator.division(6.0,2.0)).thenReturn(3.0);
        Assert.assertEquals("3.0",calculateService.calculate(INPUT_FOR_DIVISION));
    }
    @Test
    public void calculateServiceShouldReturnErrorMsgWhenTakesInvalidInput(){
        Assert.assertEquals(ERROR_MSG,calculateService.calculate(INVALID_INPUT));
    }
    @Test
    public void calculateServiceShouldReturnErrorMsgWhenTakesDivWithZero(){
        Assert.assertEquals(ERROR_MSG_FOR_DIVIDE_BY_ZERO,calculateService.calculate(INPUT_FOR_DIVISION_BY_ZERO));
    }
}
