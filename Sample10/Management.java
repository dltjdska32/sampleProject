package Sample10;
import java.util.Scanner;
import java.util.Arrays;
public class Management {

    Scanner sc = new Scanner(System.in);
    Student[] students = new Student[100];
    public Management(){}
    public void write(){



        String input = "";
        int i = 0;

        Arrays.fill(students, null);
        System.out.println("학생정보(학교 학과 이름 나이 성별 학점)를 입력하시오. (exit입력 시 중지)");
        while(!input.equals("exit") && i < students.length){
            input = sc.nextLine();
            String tokens[] = input.split(" ");

            if(input.equals("exit")){
                break;
            }

            if(tokens.length != 6){
                System.out.println("입력값이 맞지 않습니다.");
                i--;
                continue;
            }

            String sch = tokens[0];
            String ma = tokens[1];
            String name = tokens[2];
            int year = Integer.parseInt(tokens[3]);
            String sx = tokens[4];
            float gr = Float.parseFloat(tokens[5]);

            students[i] = new Student(sch, ma, name, year, sx, gr);
            i++;


        }

        System.out.println("\n----------학생정보------------\n");
        for(int j = 0; j < students.length; j++) {
            if(students[j] != null) {
                System.out.println(j + 1 + " " + students[j].toString());
            }
        }
    }

    public void modify(){
        System.out.println("\n----------수정 전 학생정보------------");
        for(int j = 0; j < students.length; j++) {
            if(students[j] != null) {
                System.out.println(j + 1 + " " + students[j].toString());
            }
        }
        System.out.println();
        System.out.println("\n수정할 위치를 선택해주세요 : ");
        int j = sc.nextInt();
        sc.nextLine();   //개행문자 소비 nextInt에서 바로 nextLine()을 사용하면 버퍼에 남아있는 개행문자(\n)을 읽어서 오류발생함.
        System.out.println("수정할 내용(학교 학과 이름 나이 성별 학점)을 입력해 주세요 ");
        String input = sc.nextLine();

        for(int i = 0; i < students.length; i++){
            if(i == j-1){
                String[] tokens = input.split(" ");
                String sch = tokens[0];
                String ma = tokens[1];
                String name = tokens[2];
                int year = Integer.parseInt(tokens[3]);
                String sx = tokens[4];
                float gr = Float.parseFloat(tokens[5]);
                students[i] = new Student(sch,ma,name,year,sx,gr);
            }
        }

        System.out.println("\n----------수정 후 학생정보------------");

        for(int i = 0; i <students.length; i++){
            if(students[i] != null){
                System.out.println(i+1 + " " + students[i].toString());
            }
        }
    }

    public void add(){

        System.out.println("\n----------수정 전 학생정보------------");
        for(int j = 0; j < students.length; j++) {
            if(students[j] != null) {
                System.out.println(j + 1 + " " + students[j].toString());
            }
        }

        System.out.println("\n추가하고 싶은 학생정보 번호를 입력하십시오.");
        int j = sc.nextInt();
        sc.nextLine();
        System.out.println("수정할 학생정보(학교 학과 이름 나이 성별 학점)를 입력하십시오. ");
        String input = sc.nextLine();

        //Student 객체 배열의 마지막 인덱스번호는 students[99] j(입력값)보다
        //클때까지 i를 -- 해가면서 배열을 오른쪽으로 한칸씩 미룸
        for(int i = students.length - 1; i > j; i--){
            students[i] = students[i-1];
        }

        String[] tokens = input.split(" ");
        String sch = tokens[0];
        String ma = tokens[1];
        String name = tokens[2];
        int year = Integer.parseInt(tokens[3]);
        String sx = tokens[4];
        float gr = Float.parseFloat(tokens[5]);
        //입력한 문자를 student 객체의 j번째 배열에 배치
        students[j] = new Student(sch, ma, name, year, sx, gr);


        System.out.println("\n---------수정 후 학생정보------------");

        for(int i = 0; i < students.length; i++) {
            if(students[i] != null) {

                System.out.println(i+1 + " " + students[i].toString());
            }

        }



    }

    public void addFirst(){
        System.out.println("\n---------수정 전 학생정보------------");

        for(int i = 0; i < students.length; i++) {
            if(students[i] != null) {

                System.out.println(i+1 + " " + students[i].toString());
            }

        }

        System.out.println("\n첫 번째 열에 추가할 학생정보(학교 학과 이름 나이 성별 학점)를 입력하시오. ");
        String input = sc.nextLine();

        for(int i = students.length - 1; i > 0; i--){
            students[i] = students[i - 1];
        }

        String[] tokens = input.split(" ");
        String sch = tokens[0];
        String ma = tokens[1];
        String name = tokens[2];
        int year = Integer.parseInt(tokens[3]);
        String sx = tokens[4];
        float gr = Float.parseFloat(tokens[5]);
        students[0] = new Student(sch, ma, name, year, sx, gr);

        System.out.println("\n----------수정 후 학생정보------------");
        for(int i = 0; i < students.length; i++) {
            if(students[i] != null) {

                System.out.println(i+1 + " " + students[i].toString());
            }

        }

    }

    public void addLast(){
        System.out.println("\n---------수정 전 학생정보------------");

        for(int i = 0; i < students.length; i++) {
            if(students[i] != null) {

                System.out.println(i+1 + " " + students[i].toString());
            }

        }

        System.out.println("\n마지막에 추가할 학생정보(학교 학과 이름 나이 성별 학점)를 입력하시오. ");

        String input = sc.nextLine();

        for(int i = 0; i < students.length - 1; i++){
            if(students[i] == null){
                String[] tokens = input.split(" ");
                String sch = tokens[0];
                String ma = tokens[1];
                String name = tokens[2];
                int year = Integer.parseInt(tokens[3]);
                String sx = tokens[4];
                float gr = Float.parseFloat(tokens[5]);
                students[i] = new Student(sch, ma, name, year, sx, gr);
                break;
            }

        }

        System.out.println("\n---------수정 후 학생정보------------");

        for(int i = 0; i < students.length; i++) {
            if(students[i] != null) {

                System.out.println(i+1 + " " + students[i].toString());
            }

        }


    }

}



