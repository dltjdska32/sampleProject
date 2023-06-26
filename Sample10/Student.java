package Sample10;

public class Student { //학생정보 클래스
    private String sch;   //학교
    private String ma;   //학과
    private String name; //이름
    private int year;    //나이
    private String sx;   // 성별
    float gr;   // 학점

    public Student(String sch, String ma, String name, int year, String sx, float gr){
        this.sch = sch;
        this.ma = ma;
        this.name = name;
        this.year = year;
        this.sx = sx;
        this.gr = gr;
    }

    public Student(){}

    public String sch() {
        return sch;
    }

    public Student setSch(String sch) {
        this.sch = sch;
        return this;
    }

    public String ma() {
        return ma;
    }

    public Student setMa(String ma) {
        this.ma = ma;
        return this;
    }


    public String name() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int year() {
        return year;
    }

    public Student setYear(int year) {
        this.year = year;
        return this;
    }

    public String sx() {
        return sx;
    }

    public Student setSx(String sx) {
        this.sx = sx;
        return this;
    }

    public float gr() {
        return gr;
    }

    public Student setGr(float gr) {
        this.gr = gr;
        return this;
    }

    public String toString(){
        return sch + " " + ma + " " + name + " " + year + " " + sx + " " + gr;
    }

}
