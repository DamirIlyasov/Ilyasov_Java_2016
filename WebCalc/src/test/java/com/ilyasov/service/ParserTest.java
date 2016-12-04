package com.ilyasov.service;

import com.ilyasov.service.Parser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;

public class ParserTest {
    private static Matcher matcher;
    private static Parser parser;
    private static final String [] ARRAY = new String[]{"5.0","+","2.0"};

    private static final String INVALID_VALUE = "6.0+2.0";

    @BeforeClass
    public static void setUp() {

        parser = new Parser();

    }

    @Test
    public void parseShouldReturnFalseWhenTakesIncorrectData() {
        Assert.assertFalse(Arrays.equals(ARRAY,parser.parse(INVALID_VALUE)));

    }

}
