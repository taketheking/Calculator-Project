package Lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private final Scanner sc = new Scanner(System.in);

    // scanner 객체의 입력을 닫는 메서드
    public void closeSc(){
        sc.close();
    }

    // 숫자 입력 받는 메서드
    public int InputNumber() {
        int number;
        while (true) {
            try {
                number = sc.nextInt();
                sc.nextLine();
                return number;
            }
            // nextInt() 메서드에서 숫자가 아닌 문자를 입력하면 InputMismatchException 예외 발생
            // 그래서 catch 문으로 해당 예외를 받아오고 takeException 메서드로 전환?
            catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("잘못된 입력입니다! 숫자를 다시 입력해주세요: ");
            }
        }
    }

    // 문자를 받는 메서드
    public char InputCharacter() {
        char character;
        character =  sc.next().trim().charAt(0);
        sc.nextLine();

        return character;

    }

    // 문자열을 받는 메서드
    public String InputString() {
        String string;
        string = sc.next();
        sc.nextLine();

        return string;
    }
}
