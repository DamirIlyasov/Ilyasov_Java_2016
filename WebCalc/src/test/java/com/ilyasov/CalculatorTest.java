package com.ilyasov;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static Calculator calculator ;
    private static final double V_1 = 2.0d;
    private static final double V_2 = 4.0d;
    private static final double DELTA = 10e-2;
    @BeforeClass
    public static void setUp(){
        calculator = new Calculator();
    }
    @Test
    public void sumShouldReturnCorrectValue(){
        Assert.assertEquals(V_1+V_2,calculator.sum(V_1,V_2),DELTA);
    }
    @Test
    public void subtractionShouldReturnCorrectValue(){
        Assert.assertEquals(V_1-V_2,calculator.subtraction(V_1,V_2),DELTA);
    }
    @Test
    public void multiplicationShouldReturnCorrectValue(){
        Assert.assertEquals(V_1*V_2,calculator.multiplication(V_1,V_2),DELTA);
    }
    @Test
    public void divisionShouldReturnCorrectValue(){
        Assert.assertEquals(V_1/V_2,calculator.division(V_1,V_2),DELTA);
    }
    @Test(expected = ArithmeticException.class)
    public void divisionShouldReturnErrorMsgWhenTakesZero(){
        calculator.division(5.0,0.0);
    }
    @Test
    public void calculatorShouldReturnZeroWhenTakesInvalidOperator(){
        Assert.assertEquals(0.0,calculator.operate(1,'[',1),DELTA);
    }
}
