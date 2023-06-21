package sample6;

public class Main  {
    public static void main(String[] args) {
      /*  Main main = new Main();
        main.play("윤민수 - 인연");
        main.pause();
        main.stop();
        */

        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.crying();
        dog.crying();

    }



   /*@Override
    void play(String songName) {
        System.out.println(songName + " 곡을 재생합니다. ");
    }

    @Override
    void pause() {
        System.out.println("곡을 일시정지 합니다.");
    }

    @Override
    void stop() {
        System.out.println("곡을 정지합니다.");
    } */

}
