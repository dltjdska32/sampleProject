package Sample10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Management management = new Management();
   //     Student[] students = new Student[100];

   /*     for(int i = 0; i < students.length; i++){
            System.out.print("학교를 입력하시오 : ");
            String sch = sc.next();   //학교
            System.out.print("학과를 입력하시오 : ");
            String ma = sc.next();   //학과
            System.out.print("이름를 입력하시오 : ");
            String name = sc.next(); //이름
            System.out.print("나이를 입력하시오 : ");
            int year = sc.nextInt();    //나이
            System.out.print("성별을 입력하시오 : ");
            String sx = sc.next();   // 성별
            System.out.print("학점를 입력하시오 : ");
            float gr = sc.nextFloat();   // 학점
            students[i] = new Student(sch, ma, name, year, sx, gr);
        }
*/

     /*   for(int i = 0; i < students.length; i++){
            System.out.println("학생정보(학교 학과 이름 나이 성별 학점)를 입력하십시오 : ");
            String input = sc.nextLine();

            String[] tokens = input.split(" ");
            if(tokens.length != 6){
                System.out.println("입력값이 바르지 않습니다.");
                i--;
                continue;
            }


            String sch = tokens[0];
            String ma = tokens[1];
            String name = tokens[2];
            int year = Integer.parseInt(tokens[3]); //String 형태 int로 변환
            String sx = tokens[4];
            float gr = Float.parseFloat(tokens[5]);

            students[i] = new Student(sch, ma, name, year, sx, gr);
        }
*/
/*
        System.out.println("학생정보(학교 학과 이름 나이 성별 학점)를 입력하십시오 (exit 입력 시 종료) : ");

        int j = 0;
        while(j < students.length) {
            String input = sc.nextLine();
            String[] tokens = input.split(" ");

            if(input.equals("exit")){
                break;
            }


            if(tokens.length != 6){
                System.out.println("입력값이 바르지 않습니다.");
                j--;
                continue;
            }


            String sch = tokens[0];
            String ma = tokens[1];
            String name = tokens[2];
            int year = Integer.parseInt(tokens[3]); //String 형태 int로 변환
            String sx = tokens[4];
            float gr = Float.parseFloat(tokens[5]);

            students[j] = new Student(sch, ma, name, year, sx, gr);
          j++;
        }

            for(int i = 0; i <students.length; i++){
                if(students[i] != null) {  // 배열에 입력된 값만 출력
                    System.out.println(students[i].toString());
                }
        }
*/
        boolean b = true;

        System.out.println("학생정보 관리 시스텝입니다.\n 옵션을 입력하세요.");

        while(b){

            System.out.println("\n1. 학생정보 입력 / 2. 정보수정 / 3. 첫번째에 정보추가 / 4. 정보추가 / 5. 마지막에 정보추가 / 6. 종료");
            int i = sc.nextInt();
            switch(i){
                case 1:
                    management.write();
                    break;

                case 2:
                    management.modify();
                    break;

                case 3:
                    management.addFirst();
                    break;

                case 4:
                    management.add();
                    break;

                case 5:
                    management.addLast();
                    break;

                case 6:
                    b = false;
                    break;

                default:
                    System.out.println("입력값이 옵션에 없습니다.");
                    continue;
            }
        }

    }
}
