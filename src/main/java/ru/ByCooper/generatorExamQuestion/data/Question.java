package ru.ByCooper.generatorExamQuestion.data;

public class Question {
    private final String question;
    private final String answer;

    public Question(String questuion, String answer) {
        this.question = questuion;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questuion='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (!this.question.equals(question.question)) return false;
        return answer.equals(question.answer);
    }

    @Override
    public int hashCode() {
        int result = question.hashCode();
        result = 31 * result + answer.hashCode();
        return result;
    }
}
