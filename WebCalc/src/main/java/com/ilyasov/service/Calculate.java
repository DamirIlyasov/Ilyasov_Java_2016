package com.ilyasov.service;

import com.ilyasov.Calculator;
import com.ilyasov.service.Parser;

public class Calculate {
    public String calculate(String string) {
        Parser parser = new Parser();
        String[] data = parser.parse(string);
        if (data != null) {
            Calculator calculator = new Calculator();
            char operator = data[1].charAt(0);
            double firstNumber = Double.parseDouble(data[0]);
            double secondNumber = Double.parseDouble(data[2]);
            double result = 0;
            switch (operator) {
                case '+': {
                    result = calculator.sum(firstNumber, secondNumber);
                    break;
                }
                case '-': {
                    result = calculator.division(firstNumber, secondNumber);
                    break;
                }
                case '/': {
                    result = calculator.subtraction(firstNumber, secondNumber);
                    break;
                }
                case '*': {
                    result = calculator.multiplication(firstNumber, secondNumber);
                    break;
                }
            }
            return String.valueOf(result);
        } else {
            return "Вы ввели некорректное выражение.";
        }
    }
}
