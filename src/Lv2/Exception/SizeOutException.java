package Lv2.Exception;

public class SizeOutException extends Exception {
    public SizeOutException() {
        super("입력하신 번호는 컬렉션의 크기를 넘어갑니다.");
    }
}