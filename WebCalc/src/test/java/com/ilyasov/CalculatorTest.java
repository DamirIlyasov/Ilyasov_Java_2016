package com.ilyasov;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static Calculator calculator;
    private static final double V_1 = 2.0d;
    private static final double V_2 = 4.0d;
    private static final double DELTA = 10e-2;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void operateShouldReturnCorrectSum() {
        Assert.assertEquals(V_1 + V_2, calculator.operate(V_1,'+',V_2), DELTA);
    }

    @Test
    public void operateShouldReturnCorrectSubtraction() {
        Assert.assertEquals(V_1 - V_2, calculator.operate(V_1,'-',V_2), DELTA);
    }

    @Test
    public void operateShouldReturnCorrectMultiplication() {
        Assert.assertEquals(V_1 * V_2, calculator.operate(V_1,'*',V_2), DELTA);
    }

    @Test
    public void operateShouldReturnCorrectDivision() {
        Assert.assertEquals(V_1 / V_2, calculator.operate(V_1,'/',V_2), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void operateShouldReturnErrorMsgWhenTakesDivisionByZero() {
        calculator.operate(5.0,'/',0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void operateShouldThrowExceptionWhenTakesInvalidOperator() {
        calculator.operate(1, '[', 1);
    }
}
