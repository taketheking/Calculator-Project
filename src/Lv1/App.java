package Lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        char operation;
        int firstNumber;
        int secondNumber;
        int result;

        Scanner sc = new Scanner(System.in);

        System.out.println("---- 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 ----");
        // 메인 계산기 반복문
        while (true) {
            System.out.println();

            // -------------- 양의 정수(0포함)을 입력받기 --------------
            // 첫 번째 숫자 반복문
            while (true) {
                System.out.print("첫 번째 숫자(양의 정수, 0포함)를 입력하세요: ");
                // 입력값 오류 발생시 예외 처리
                try {
                    firstNumber = sc.nextInt();
                }
                // nextInt() 메서드에서 숫자가 아닌 문자를 입력하면 InputMismatchException 예외 발생
                // 그래서 catch 문으로 해당 예외를 받아오고 처리한다.
                catch (InputMismatchException e) {
                    System.out.println("숫자가 아닌 다른 것을 입력하셨습니다.");
                    System.out.println();
                    continue;   // 첫 번째 숫자 반복문 처음으로
                }
                if (firstNumber < 0) {
                    System.out.println("0 또는 양의 정수가 아닙니다.");
                    System.out.println();
                }else {
                    break;
                }
            }

            // 두 번째 숫자 반복문
            while (true) {
                System.out.print("두 번째 숫자(양의 정수, 0포함)를 입력하세요: ");
                try {
                    secondNumber = sc.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("숫자가 아닌 다른 것을 입력하셨습니다.");
                    System.out.println();
                    continue;
                }
                if (secondNumber < 0) {
                    System.out.println("0 또는 양의 정수가 아닙니다.");
                    System.out.println();
                }else {
                    break;
                }
            }

            // ------------------------------------------

            // -------------- 사칙연산 --------------
            while (true) {
                System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");

                operation = sc.next().charAt(0);

                if (operation == '+') {
                    result = firstNumber + secondNumber;
                    break;
                } else if (operation == '-') {
                    result = firstNumber - secondNumber;
                    break;
                } else if (operation == '*') {
                    result = firstNumber * secondNumber;
                    break;
                } else if (operation == '/') {
                    // 나눗셈에서 분모가 0일 때
                    if (secondNumber == 0) {
                        System.out.println("연산 오류: 나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        System.out.println();
                        // 분모 숫자 다시 받는 반복문
                        while (true) {
                            System.out.print("두 번째 숫자(양의 정수, 0제외)를 다시 입력하세요: ");
                            try {
                                secondNumber = sc.nextInt();
                            }
                            catch (InputMismatchException e) {
                                System.out.println("숫자가 아닌 다른 것을 입력하셨습니다.");
                                System.out.println();
                                continue;
                            }
                            if (secondNumber <= 0) {
                                System.out.println("양의 정수가 아닙니다.");
                                System.out.println();
                            }else {
                                break;
                            }
                        }
                    }
                    result = firstNumber / secondNumber;
                    break;
                } else {
                    System.out.println("사칙연산 기호를 잘못 입력하셨습니다.");
                    System.out.println();
                }
            }

            // ------------------------------------------

            // -------------- 연산 결과 출력 --------------
            System.out.println();
            System.out.println("결과: "+firstNumber+" "+operation+" "+secondNumber+" = " + result);
            System.out.println();
            // ------------------------------------------

            // -------------- 종료 확인 --------------
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)  ");
            String answer = sc.next();
            if (answer.equals("exit")) {
                break;
            }
            // ------------------------------------------
        }
    }
}