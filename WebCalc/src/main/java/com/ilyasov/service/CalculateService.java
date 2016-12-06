package com.ilyasov.service;

import com.ilyasov.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateService  {
    private final Pattern pattern = Pattern.compile("/calculate/(?<firstNumber>\\d+(\\.\\d)*)(?<operator>(\\+|-|/|\\*))(?<secondNumber>\\d+(\\.\\d)*)");
    private Matcher matcher;
    private Double firstNumber;
    private Double secondNumber;
    private char operator;
    private Calculator calculator = new Calculator();

    public String calculate(String string) {
        matcher = pattern.matcher(string);
        if (matcher.matches()) {
            parse();
            try{
                return String.valueOf(calculator.operate(firstNumber,operator,secondNumber));
            } catch (ArithmeticException e){
                return e.getMessage();
            }
        } else {
            return "Invalid input";
        }
    }

    private void parse() {
        firstNumber = Double.valueOf(matcher.group("firstNumber"));
        operator = matcher.group("operator").charAt(0);
        secondNumber = Double.valueOf(matcher.group("secondNumber"));
    }
}