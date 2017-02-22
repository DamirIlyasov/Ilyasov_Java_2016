package com.ilyasov.service;

import com.ilyasov.Calculator;

import static com.ilyasov.enums.Operation.*;


public class CalculatorService {
    Calculator calculator = new Calculator();


    public double service(double a, double b, char operation) {
        switch (operation) {
            case DIV: {
                if (b == 0){
                    throw new ArithmeticException();
                }
                return calculator.division(a, b);
            }
            case SUM: {
                return calculator.sum(a, b);
            }
            case MULT: {
                return calculator.multiplication(a, b);
            }
            case SUB: {
                return calculator.subtraction(a, b);
            }
            default: {
                return 0;
            }
        }
    }
}
