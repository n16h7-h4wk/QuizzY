package com.developer.ankit.quizzy;


public class MCQ {
    private int mQuestionID;
    private int mAnswerID ;
    public MCQ(int mQuestionID, int mAnswerID){
        this.mQuestionID = mQuestionID;
        this.mAnswerID = mAnswerID ;
    }

    public int getmQuestionID() {
        return mQuestionID;
    }

    public void setmQuestionID(int mQuestionID) {
        this.mQuestionID = mQuestionID;
    }

    public int getmAnswerID() {
        return mAnswerID;
    }

    public void setmAnswerID(int mAnswerID) {
        this.mAnswerID = mAnswerID;
    }
}
