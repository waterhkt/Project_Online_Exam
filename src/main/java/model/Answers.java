package model;

import java.io.Serializable;

public class Answers implements Serializable {
    private int id;
    private int userId;
    private int questionId;
    private String answersChoosecol;

    public Answers() {
    }

    public Answers(int id, int userId, int questionId, String answersChoosecol) {
        this.id = id;
        this.userId = userId;
        this.questionId = questionId;
        this.answersChoosecol = answersChoosecol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswersChoosecol() {
        return answersChoosecol;
    }

    public void setAnswersChoosecol(String answersChoosecol) {
        this.answersChoosecol = answersChoosecol;
    }
}
