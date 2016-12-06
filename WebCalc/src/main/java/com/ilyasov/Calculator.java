package com.ilyasov;

public class Calculator implements Operator {

    private double sum(double a, double b) {
        return a + b;
    }

    private double subtraction(double a, double b) {
        return a - b;
    }

    private double multiplication(double a, double b) {
        return a * b;
    }

    private double division(double a, double b) {
        if (b == 0){
            throw new ArithmeticException("You can't divide by zero");
        }
        return a / b;
    }

    @Override
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
                throw new ArithmeticException("Invalid input");
            }
        }
    }
}
