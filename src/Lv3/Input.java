package Lv3;

import java.util.Scanner;

public class Input {

    private final Scanner sc = new Scanner(System.in);

    // scanner 객체의 입력을 닫는 메서드
    public void closeSc(){
        sc.close();
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
        string = sc.next().trim();
        sc.nextLine();

        return string;
    }
}
