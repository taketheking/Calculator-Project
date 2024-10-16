package Lv2;


public class App {
    // 전역 객체
    static final Input INPUT = new Input();                  // 사용자 입력받는 객체
    static final Confirm CONFIRM = new Confirm();            // 입력된 데이터가 조건에 맞는지 확인하는 객체
    static final Calculator CALCULATOR = new Calculator();   // 사칙연산하는 객체 및 연산 결과값 관련 기능 객체

    public static void main(String[] args) {
        // main()메서드의 필드
        char operation;     // 사칙연산 부호
        int firstNumber;    // 첫 번째 입력받는 숫자
        int secondNumber;   // 두 번째 입력받는 숫자
        int result;         // 연산 결과

        Menu menu = new Menu();

        // 계산기 로직 시작
        System.out.println();
        System.out.println("---- 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 ----");
        System.out.println();

        // 메인 계산기 반복문
        do {
            // -------------- 첫 번째 숫자 입력 반복문 --------------
            do {
                System.out.print("첫 번째 숫자(양의 정수, 0포함)를 입력하세요: ");
                firstNumber = INPUT.InputNumber();

            }while (CONFIRM.isPositiveInteger(firstNumber));

            // -------------- 사칙연산 기호 입력 반복문 --------------
            do {
                System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
                operation = INPUT.InputCharacter();

            } while (CONFIRM.isOperations(operation));

            // -------------- 두 번째 숫자 입력 반복문 --------------
            do {
                System.out.print("두 번째 숫자(양의 정수, 0포함)를 입력하세요: ");
                secondNumber = INPUT.InputNumber();
            }while (CONFIRM.isDivideZero(operation, secondNumber));


            // -------------- calculate 연산 --------------
            result = CALCULATOR.calculate(operation, firstNumber, secondNumber);

            // -------------- 연산 결과 출력 --------------
            System.out.println();
            System.out.println("결과: "+firstNumber+" "+operation+" "+secondNumber+" = " + result);

            // -------------- 종료 및 취소 Menu --------------
        } while (menu.showMenu());

    }
}