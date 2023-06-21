package sample7;

public class Main implements Dog,Cat{   //추상클래스의 경우 이중상속 불가 BUT 인터페이스클래스는 이중상속가능.
    public static void main(String[] args) {
        Main main = new Main();
        main.crying();
        main.show();
        main.one();
        main.Crying1();
        main.show1();
        main.two();
    }

    @Override
    public void crying() {
        System.out.println("멍멍");
            }

    @Override
    public void one() {
        System.out.println("으으아악");
    }

    @Override
    public void show() {
        System.out.println("hello world");
    }

    @Override
    public void Crying1() {
        System.out.println("냥");
    }

    @Override
    public void show1() {
        System.out.println("bye world");
    }

    @Override
    public void two() {
        System.out.println("흐어어억");
    }
}
