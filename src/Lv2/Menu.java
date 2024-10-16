package Lv2;

import java.util.ArrayList;

import static Lv2.App.*;

public class Menu {

    public boolean showMenu(){
        label:
        while (true){
            System.out.println();
            System.out.println("-------------------------------------------------------------");
            System.out.println("1. 더 계산하시겠습니까? (exit 입력 시 종료.)  ");
            System.out.println("2. 가장 먼저 저장된 데이터(연산값)를 삭제하시겠습니까? (remove 입력 시 삭제)");
            System.out.println("3. 연산된 데이터들을 확인하시겠습니까? (values 입력 시 확인)");
            System.out.println("4. 특정 데이터(연산값)을 확인하시겠습니까? (value 입력 시 확인)");
            System.out.println("5. 특정 데이터를 수정하시겠습니까? (modify 입력 시 수정)");
            System.out.println("위의 제시된 숫자나 단어가 아닌 문자를 입력하면 다시 계산합니다.");
            System.out.println("-------------------------------------------------------------");

            try {
                String answer = INPUT.InputString();    // 사용자 답변 받기
                System.out.println();
                System.out.println();

                // 답변에 따른 동작
                switch (answer) {
                    case "exit":
                    case "1":
                        INPUT.closeSc();    // scanner 객체 예기치못한 종료를 방지하기 위함.
                        return false;     // 프로그램 종료

                    case "remove":
                    case "2":
                        CALCULATOR.removeResult();      // 삭제 처리

                        System.out.println("가장 먼저 저장된 데이터가 삭제되었습니다.");
                        break;
                    case "values":
                    case "3":
                        System.out.print("연산된 데이터 리스트 : ");
                        ArrayList<Integer> list = CALCULATOR.getResults();  // ArrayList 컬렉션의 값들을 가져오기

                        for (int num : list) {
                            System.out.print(num + " ");
                        }
                        System.out.println();
                        break;
                    case "value":
                    case "4": {
                        System.out.print("가져올 데이터의 index(0부터 시작)를 입력해주세요: ");
                        int index;
                        do {
                            index = INPUT.InputNumber();
                        } while (CONFIRM.isPositiveInteger(index));

                        System.out.println(CALCULATOR.getResult(index));
                        break;
                    }
                    case "modify":
                    case "5": {
                        System.out.print("수정하실 데이터의 index(0부터 시작)를 입력해주세요: ");
                        int index;
                        do {
                            index = INPUT.InputNumber();
                        } while (CONFIRM.isPositiveInteger(index));

                        System.out.print("해당 데이터를 대체할 숫자을 입력해주세요: ");
                        int modifyNum = INPUT.InputNumber();

                        CALCULATOR.setResult(index, modifyNum);
                        System.out.println("수정되었습니다.");
                        break;
                    }
                    default:
                        break label;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }
}
