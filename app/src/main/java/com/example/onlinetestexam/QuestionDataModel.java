package com.example.onlinetestexam;

public class QuestionDataModel {

    String Question,A,B,C,D;
    public QuestionDataModel()
    {

    }

    public QuestionDataModel(String question, String a, String b, String c, String d) {
        Question = question;
        A = a;
        B = b;
        C = c;
        D = d;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }
}
