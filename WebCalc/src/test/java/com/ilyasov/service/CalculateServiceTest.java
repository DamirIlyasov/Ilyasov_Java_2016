package com.ilyasov.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateServiceTest {
    private static CalculateService calculateService;
    private final String INPUT_FOR_SUM = "/calculate/6.0+1.0";
    private final String INPUT_FOR_SUBTRACTION = "/calculate/6.0-1.0";
    private final String INPUT_FOR_MULTIPLICATION = "/calculate/6.0*2.0";
    private final String INPUT_FOR_DIVISION = "/calculate/6.0/2.0";
    private final String INPUT_FOR_DIVISION_BY_ZERO = "/calculate/6.0/0.0";
    private final String INVALID_INPUT = "asdqdasd";
    private final double DELTA = 10e-2;
    @BeforeClass
    public static void setUp(){
        calculateService = new CalculateService();
    }

    @Test
    public void calculateServiceShouldReturnCorrectSum(){
        Assert.assertEquals("7.0",calculateService.calculate(INPUT_FOR_SUM));
    }
    @Test
    public void calculateServiceShouldReturnCorrectSubtraction(){
        Assert.assertEquals("5.0",calculateService.calculate(INPUT_FOR_SUBTRACTION));
    }
    @Test
    public void calculateServiceShouldReturnCorrectMultiplication(){
        Assert.assertEquals("12.0",calculateService.calculate(INPUT_FOR_MULTIPLICATION));
    }
    @Test
    public void calculateServiceShouldReturnCorrectDivision(){
        Assert.assertEquals("3.0",calculateService.calculate(INPUT_FOR_DIVISION));
    }
    @Test
    public void calculateServiceShouldReturnErrorMsgWhenTakesInvalidInput(){
        Assert.assertEquals("Invalid input",calculateService.calculate(INVALID_INPUT));
    }
    @Test
    public void calculateServiceShouldReturnErrorMsgWhenTakesDivWithZero(){
        Assert.assertTrue("Invalid input".equals(calculateService.calculate(INPUT_FOR_DIVISION_BY_ZERO)));
    }
}
