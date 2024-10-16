package Lv2;

import Lv2.Exception.SizeOutException;

import java.util.ArrayList;

public class Calculator {
    private final ArrayList<Integer> ResultList = new ArrayList<>();

    // 연산된 데이터들을 전체 가져오는 메서드
    public ArrayList<Integer> getResults() {
        return new ArrayList<>(ResultList);
    }

    // 가장 먼저 연산되어 저장된 데이터를 삭제하는 메서드
    public void removeResult() throws SizeOutException {
        try {
            ResultList.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            throw new SizeOutException();
        }
    }

    // 특정 연산 데이터를 확인하는 메서드
    public int getResult(int index) throws SizeOutException {
        try {
            return ResultList.get(index);
        }
        catch (IndexOutOfBoundsException e) {
            throw new SizeOutException();
        }

    }

    // 특정 index 의 연산 데이터를 수정하는 메서드
    public void setResult(int index, int value ) throws SizeOutException {
        try {
            ResultList.set(index, value);
        }
        catch (IndexOutOfBoundsException e) {
            throw new SizeOutException();
        }
    }

    // 사칙연산하는 메서드
    public int calculate(char operator, int firstNumber, int secondNumber) {
        int answer = switch (operator) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/' -> firstNumber / secondNumber;
            default -> 0;
        };

        ResultList.add(answer);
        return answer;
    }
}

