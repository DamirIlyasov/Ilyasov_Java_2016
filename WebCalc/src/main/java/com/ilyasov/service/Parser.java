package com.ilyasov.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String[] data = new String[3];
    private final Pattern pattern = Pattern.compile("/calculate/(?<firstNumber>\\d+(\\.\\d)*)(?<operator>(\\+|-|/|\\*))(?<secondNumber>\\d+(\\.\\d)*)");
    private Matcher matcher;


    public String[] parse(String string) {
        matcher = pattern.matcher(string);
        if (matcher.matches()) {
            data[0] = matcher.group("firstNumber");
            data[1] = matcher.group("operator");
            data[2] = matcher.group("secondNumber");
            return data;
        } else {
            return null;
        }
    }

}
