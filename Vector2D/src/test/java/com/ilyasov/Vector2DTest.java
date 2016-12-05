package com.ilyasov;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Vector2DTest {
    private static Vector2D firstVector2D;
    private static Vector2D secondVector2D;
    private static final double X_1 = 5.0;
    private static final double X_2 = 10.0;
    private static final double Y_1 = 2.0;
    private static final double Y_2 = 4.0;
    private static final double DELTA = 10e-2;
    @BeforeClass
    public static void setUp() {
        firstVector2D = new Vector2D(X_1, Y_1);
        secondVector2D = new Vector2D(X_2, Y_2);
    }

    @Test
    public void lengthShouldReturnCorrectLength(){
        Assert.assertEquals(Math.sqrt(Math.pow(X_1,X_1)+Math.pow(Y_1,Y_1)),firstVector2D.length(),DELTA);
    }

    @Test
    public void addShouldReturnCorrectVector(){
        Assert.assertTrue(new Vector2D(X_1+X_2,Y_1+Y_2).equals(firstVector2D.add(secondVector2D)));
    }

    @Test
    public void multShouldReturnCorrectVector(){
        Assert.assertTrue(new Vector2D(X_1*2,Y_1*2).equals(firstVector2D.mult(2)));
    }

    @Test
    public void sqalarMultShouldReturnCorrectVector(){
        Assert.assertTrue(new Vector2D(X_1*X_2,Y_1*Y_2).equals(firstVector2D.scalarMult(secondVector2D)));
    }

    @Test
    public void equalsShouldReturnTrue(){
        Assert.assertTrue(firstVector2D.equals(new Vector2D(5.0,2.0)));
    }

    @Test
    public void equalsShouldReturnFalse(){
        Assert.assertFalse(firstVector2D.equals(secondVector2D));
    }


}
