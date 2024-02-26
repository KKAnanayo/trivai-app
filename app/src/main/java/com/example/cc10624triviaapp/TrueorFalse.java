package com.example.cc10624triviaapp;

import kotlin.contracts.Returns;

public class TrueorFalse
{
    //declare the attributes
    private int idxQuestion;
    private boolean keyAnswer;

    //constructor
    public TrueorFalse(int idxQuestion, boolean keyAnswer)
    {
        this.idxQuestion = idxQuestion;
        this.keyAnswer = keyAnswer;
    }
    //mutator & accessor method
     public boolean isKeyAnswer(){
         return keyAnswer;
     }

    public int getIdxQuestion() {
        return idxQuestion;
    }

    public void setIdxQuestion(int idxQuestion) {
        this.idxQuestion = idxQuestion;
    }
}
