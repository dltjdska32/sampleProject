package Sample12;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean b = true;

        CustomerManagement cm = new CustomerManagement();

        System.out.println("------------ NK 뱅킹 어플입니다 --------------");

        while(b){
            System.out.println("옵션을 선택하십시오 : 1 아이디 생성 / 2. 로그인 /  3. 종료");
            int i = sc.nextInt();
            switch (i){
                case 1:
                    cm.createCustomer();
                    System.out.println(cm.toString());
                    break;
                case 2:
                    cm.login();

                    break;
                case 3:
                    b = false;
                    break;

                default:
                    System.out.println("입력값이 잘못 되었습니다.");
                    break;

            }
        }
    }
}

