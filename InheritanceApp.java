package InheritanceApp;

class Cal{
    public int sum(int a, int b){
        return a + b;
    }
    public int sum(int a, int b,int c){
        return this.sum(a,b) + c;
    }
}

class Cal3 extends Cal{
    public int minus(int a, int b){
        return a - b;
    }

    //Overriding> 부모클래스의 내용을 덮어씌우는것
    public int sum(int a, int b){
        System.out.println("안녕하세요!!!");
        return super.sum(a ,b);

    }

    //Overloading -> 형태가 다른 함수
    public int sum(int a, int b, int c){
        return a + b + c;
    }

}


public class InheritanceApp {
    public static void main(String[] args) {
        Cal c = new Cal();
        Cal3 c3 = new Cal3();
        System.out.println(c.sum(3,4));
        System.out.println(c3.sum(4,5));
        System.out.println(c3.minus(2,2));
        System.out.println(c3.sum(4,2,1));
    }
}
