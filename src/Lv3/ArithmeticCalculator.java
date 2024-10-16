package Lv3;

import Lv3.Exception.SizeOutException;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator <T extends Number> {
    private final ArrayList<Number> ResultList = new ArrayList<>();

    // 연산된 데이터들을 전체 가져오는 메서드
    public List<Number> getResults() {
        return new ArrayList<>(ResultList);
    }


    // 특정 연산 데이터를 확인하는 메서드
    public Number getResult(int index) throws SizeOutException {
        try {
            return ResultList.get(index);
        }
        catch (IndexOutOfBoundsException e) {
            throw new SizeOutException();
        }
    }

    // 특정 연산 데이터를 확인하는 메서드
    public List<Number> getBiggerResults(double number){

            return ResultList.stream().filter(x -> Double.parseDouble(x.toString()) > number).toList();

    }

    // 특정 index 의 연산 데이터를 수정하는 메서드
    public void setResult(int index, T value ) throws SizeOutException {
        try {
            ResultList.set(index, value);
        }
        catch (IndexOutOfBoundsException e) {
            throw new SizeOutException();
        }
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

    // 사칙연산하는 메서드
    public Number calculate(char operator, T firstNumber, T secondNumber) {
        double firstDouble = firstNumber.doubleValue();
        double secondDouble = secondNumber.doubleValue();

        double answer = switch (OperatorType.getOperatorName(operator)) {
            case Addition -> firstDouble + secondDouble;
            case Subtraction -> firstDouble - secondDouble;
            case Multiplication -> firstDouble * secondDouble;
            case Division -> firstDouble / secondDouble;
            default -> 0;
        };

        ResultList.add(answer);
        return answer;
    }
}

