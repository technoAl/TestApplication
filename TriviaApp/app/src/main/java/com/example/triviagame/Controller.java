package com.example.triviagame;

import android.app.Application;

import java.util.ArrayList;
import java.util.Random;

public class Controller extends Application {

    ArrayList<Question> questions = new ArrayList<>();

    public ArrayList<Question> getQuestions(){
        return questions;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

    public Question getQuestion(){
        Random rand = new Random();
        int rNum = rand.nextInt(questions.size());
        return questions.get(rNum);
    }

}
