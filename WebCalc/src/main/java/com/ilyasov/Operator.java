package com.ilyasov;

public interface Operator {
    char PLUS = '+';
    char MINUS = '-';
    char MULT = '*';
    char DIV = '/';
    double operate(double firstNumber, char operator, double secondNumber);
}
