package sample8;

public class Main {
    public static void main(String[] args) {
        Hero[] heroes = new Hero[3];
        heroes[0] = new Warrior("전사");
        heroes[1] = new Archer("궁수");
        heroes[2] = new Wizard("마법사");

        for(int i = 0; i < heroes.length; i++){
            heroes[i].attack();

            if(heroes[i] instanceof Wizard) {   //i번째 히어로의 내용물이 위자드면 실행
                Wizard temp = (Wizard) heroes[i]; //hero[i]를 위자드 이스턴스로 형 변환하고 temp에 저장
                temp.wizardSkill();
            }
            else if(heroes[i] instanceof Warrior){ // i 번재 히어로의 내용물이 전사일 경우 실행
                Warrior temp = (Warrior) heroes[i]; //hero[i]를 전사 인스턴스로 형변환후 temp에 저장
                temp.warriorSkill();
            }
            else if(heroes[i] instanceof Archer){  // i번째 히어로의 내용이 아쳐면 실행
                Archer temp = (Archer) heroes[i];    // hero[i]를 아쳐 인스턴스로 형 변환후 temp에 저장
                temp.archerSkill();
            }
        }

    }
}
