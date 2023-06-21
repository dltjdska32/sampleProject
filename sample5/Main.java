package sample5;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        int number;
        boolean b = true;
        Scanner sc = new Scanner(System.in);
      /*  Student[] students = new Student[100];
        for(int i = 0;  i < 100; i++){
            students[i] = new Student("홍길동",21,180,90,i + "",1,3.2);
            students[i].show();
        }*/

        System.out.print("몇명의 학생이 존재합니까? : ");
        number = sc.nextInt();
        Student[] students = new Student[number];
        System.out.println();


        while(b){
            System.out.println("옵션을 선택하시오.");
            System.out.println("1. 학생정보 추가 /2. 학생정보 출력 /3. 나가기");
            num = sc.nextInt();
            switch (num){
                case 1 :
                    for(int i = 0; i < number; i++){
                        String name;
                        int age;
                        int height;
                        int weight;
                        String studentID;
                        int grade;
                        double gPA;
                        System.out.println("학생이름을 입력하시오 : ");
                        name = sc.next();
                        System.out.println("학생나이을 입력하시오 : ");
                        age = sc.nextInt();
                        System.out.println("학생 키를 입력하시오 : ");
                        height = sc.nextInt();
                        System.out.println("학생 몸무게를 입력하시오 : ");
                        weight = sc.nextInt();
                        System.out.println("학생 학번울 입력하시오 : ");
                        studentID = sc.next();
                        System.out.println("학생 학년을 입력하시오 : ");
                        grade = sc.nextInt();
                        System.out.println("학생 학점을 입력하시오 : ");
                        gPA = sc.nextDouble();
                        students[i] = new Student(name, age, height, weight, studentID, grade, gPA);
                    }
                    break;

                case 2:
                    for(int i = 0; i < number; i++){
                        students[i].show();
                    }
                    break;
                case 3:
                    b = false;
                    break;
                default:
                    System.out.println("번호없음 다시입력하시오");
                    break;


            }


        }
    }
}