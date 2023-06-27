package Sample11;

abstract class Question {
    private String question;
    private String answer;
    public Question(String question, String answer){
        this.question = question;
        this.answer = answer;

    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    public abstract boolean checkAnswer(String userAnswer);


}

class MultipleChoiceQuestion extends  Question{
    private String[] choices;

    public MultipleChoiceQuestion(String question, String answer, String[] choices){
        super(question, answer);
        this.choices = choices;
    }

    public boolean checkAnswer(String userAnswer){
        return userAnswer.equals(getAnswer());
    }

    public String[] getChoices(){
        return choices;
    }


}
