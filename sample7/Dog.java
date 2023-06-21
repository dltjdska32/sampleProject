package sample7;

public interface Dog {
    abstract void crying();
    abstract void show();
    public void one();
   // public void show(); // 아래와 같이 함수 작성 불가능.
   /*            //인터페이스에서는 일반 메소드 작성 불가 <-> abstract에서는 일반메소드 작성가능
    public void show(){
        System.out.println("hi");
    }
    */
}

