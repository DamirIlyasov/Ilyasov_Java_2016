package com.ilyasov;

public class Calculator implements Operator {

    public double operate(double firstNumber, char operator, double secondNumber) {
        switch (operator) {
            case PLUS: {
                return sum(firstNumber, secondNumber);

            }
            case MINUS: {
                return subtraction(firstNumber, secondNumber);

            }
            case DIV: {
                return division(firstNumber, secondNumber);

            }

            case MULT: {
                return multiplication(firstNumber, secondNumber);

            }
            default:{
                return 0;
            }
        }
    }
    public double sum(double a, double b) {
        return a + b;
    }

    public double subtraction(double a, double b) {
        return a - b;
    }

    public double multiplication(double a, double b) {
        return a * b;
    }

    public double division(double a, double b) {
        if (b == 0){
            throw new ArithmeticException("You can't divide by zero");
        }
        return a / b;
    }
}
