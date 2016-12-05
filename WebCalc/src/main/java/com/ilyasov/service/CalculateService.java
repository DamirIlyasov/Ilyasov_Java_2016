package com.ilyasov.service;

import com.ilyasov.Calculator;
import com.ilyasov.Operator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateService implements Operator {
    private final Pattern pattern = Pattern.compile("/calculate/(?<firstNumber>\\d+(\\.\\d)*)(?<operator>(\\+|-|/|\\*))(?<secondNumber>\\d+(\\.\\d)*)");
    private Matcher matcher;
    private Double firstNumber;
    private Double secondNumber;
    private char operator;

    public String calculate(String string) {
        matcher = pattern.matcher(string);
        if (matcher.matches()) {
            parse();
            if (operator == '/' & secondNumber == 0){
                return "Invalid input";
            }
            Calculator calculator = new Calculator();
            double result = 0;
            switch (operator) {
                case PLUS: {
                    result = calculator.sum(firstNumber, secondNumber);
                    break;
                }
                case MINUS: {
                    result = calculator.subtraction(firstNumber, secondNumber);
                    break;
                }
                case DIV: {
                    result = calculator.division(firstNumber, secondNumber);
                    break;
                }
                case MULT: {
                    result = calculator.multiplication(firstNumber, secondNumber);
                    break;
                }
            }
            return String.valueOf(result);
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