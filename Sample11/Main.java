package Sample11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Question[] questions = {
                new MultipleChoiceQuestion("다음 중 최조의 인공위성은?", "스푸트니크", new String[]{"스푸트니크", "아폴로 11", "히메네스", "국제우주정거장"}),
                new MultipleChoiceQuestion("다음 중 소설이 아닌 것은?", "토지", new String[]{"토지", "어린왕자", "1984", "데미안"}),
                new MultipleChoiceQuestion("다음 중 한국의 수도는?", "서울", new String[]{"도쿄", "베이징", "뉴욕", "서울"})
        };

        int score = 0;

        System.out.println("\n퀴즈 게임을 시작합니다.");
        System.out.println("--------------------------");

        for(int i = 0; i < questions.length; i++){
            //문제 질문 출력 -> ex) [1]다음중 최초의 인공위성은?
            System.out.println("[" + (i + 1) + "]" + questions[i].getQuestion());

            if(questions[i] instanceof MultipleChoiceQuestion){
                String[] choices = ((MultipleChoiceQuestion)questions[i]).getChoices();
                for(int j = 0; j < choices.length; j++){
                    System.out.println((char)('A' + j) + ". " + choices[j]);
                }
            }

            System.out.print("정답을 입력하세요 : ");
            String uAnswer = sc.nextLine();

            if(questions[i].checkAnswer(uAnswer) == true){
                System.out.println("정답입니다.");
                score++;
            }else{
                System.out.println("오답입니다.");
            }

            System.out.println("----------------");

        }

        System.out.println("----------- 퀴즈 종료 ---------------");
        System.out.println("점수 : " + score + " / " + questions.length);


        sc.close();
    }
}
