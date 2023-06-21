package sample3;

public class Max {
    public static int max(int a, int b) {
        return (a > b) ? a : b;  // a 가 b 보다 크다면? a를 반환  그렇지 않으면 b를 반환
    }

    public static int function(int a, int b, int c){
        int result = max(a,b);
        result = max(result, c);
        return result;
    }
    public static void main(String[] args) {
        System.out.println("11, 20, 34중 최댓값은 " + function(11,20,34) + "입니다.");
    }


}
