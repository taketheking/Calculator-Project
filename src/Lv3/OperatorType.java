package Lv3;

import java.util.Arrays;

public enum OperatorType {
    Addition('+'), Subtraction('-'), Multiplication('*'), Division('/'), X(' ');

    private final char operator;

    OperatorType(char operator) {
        this.operator = operator;
    }

    public static OperatorType getOperatorName(char operator) {
        return Arrays.stream(OperatorType.values())
                .filter(x -> x.operator==operator).findFirst().orElse(X);
    }
}
