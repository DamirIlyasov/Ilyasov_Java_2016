package com.ilyasov.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateServiceTest {
    private static CalculateService calculateService;
    private String INPUT;
    private final double DELTA = 10e-2;
    @BeforeClass
    public static void setUp(){
        calculateService = new CalculateService();
    }

    @Test
    public void calculateServiceShouldReturnCorrectSum(){
        INPUT = "/calculate/6.0+1.0";
        Assert.assertEquals("7.0",calculateService.calculate(INPUT));
    }
    @Test
    public void calculateServiceShouldReturnCorrectSubtraction(){
        INPUT = "/calculate/6.0-1.0";
        Assert.assertEquals("5.0",calculateService.calculate(INPUT));
    }
    @Test
    public void calculateServiceShouldReturnCorrectMultiplication(){
        INPUT = "/calculate/6.0*2.0";
        Assert.assertEquals("12.0",calculateService.calculate(INPUT));
    }
    @Test
    public void calculateServiceShouldReturnCorrectDivision(){
        INPUT = "/calculate/6.0/2.0";
        Assert.assertEquals("3.0",calculateService.calculate(INPUT));
    }
    @Test
    public void calculateServiceShouldReturnErrorMsgWhenTakesInvalidInput(){
        INPUT = "qweasdasd";
        Assert.assertEquals("Invalid input",calculateService.calculate(INPUT));
    }
    @Test
    public void calculateServiceShouldReturnErrorMsgWhenTakesDivWithZero(){
        INPUT = "/calculate/6/0";
        Assert.assertEquals("Invalid input",calculateService.calculate(INPUT));
    }
}
