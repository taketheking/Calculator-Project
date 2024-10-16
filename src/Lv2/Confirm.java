package Lv2;

import Lv2.Exception.BadInputException;

import java.util.regex.Pattern;

public class Confirm {
    static final String OPERATION_REG = "[+\\-*/]"; // 사칙연산 기호 정규식
    static final String NUMBER_REG = "^[0-9]*$";    // 숫자 정규식

    // 예외 발생시키는 메서드
    static public void takeException(String string){
        try {
            throw new BadInputException(string);
        }
        catch (BadInputException e) {
            System.out.println(e.getMessage());
        }
    }

    // 사칙연산 기호 확인하는 메서드
    public boolean isOperations(char operation) {
        if (Pattern.matches(OPERATION_REG, String.valueOf(operation))) {
            return false;
        }
        else{
            // System.out.println("잘못된 입력입니다! 사칙 연산의 연산자를 입력해주세요!");
            takeException("사칙 연산의 연산자");
            return true;
        }

    }

    // 양의 정수 확인하는 메서드
    public boolean isPositiveInteger(int number) {
        if (Pattern.matches(NUMBER_REG, String.valueOf(number))) {
            return false;
        }
        else {
            // System.out.println("잘못된 입력입니다! 0 또는 양의 정수를 입력해주세요!");
            takeException("0 또는 양의 정수");
            return true;
        }
    }

    // 나눗셈에서 분모가 0인지 확인하는 메서드
    public boolean isDivideZero(char operation, int number) {
        if(!isPositiveInteger(number)){
            if (operation == '/' && number == 0) {
                // System.out.println("잘못된 입력입니다! 0을 제외한 양의 정수를 입력해주세요!");
                takeException("0을 제외한 양의 정수");
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
