package com.example.triviagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        readQuestionData();

        final Controller aController = (Controller) getApplicationContext();

        for(Question q: aController.getQuestions()){
            Log.v("MainActivity", q.getAnswer() + " " + q.getQuestion());
        }
    }

    private void readQuestionData(){
        InputStream is = getResources().openRawResource(R.raw.trivia);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        //get the global controller class object
        final Controller aController = (Controller) getApplicationContext();

        String line = "";
        try {
            while((line = reader.readLine())!= null){
                String[] fields = line.split(",");
                Log.v("MainActivity", fields[0] + " " + fields[1]);
                Question q = new Question(fields[0], fields[1]);
                aController.addQuestion(q);
            }
        } catch(IOException e){
            Log.wtf("MainActivity", "error" + line);
        }
    }

    public void performStartTrivia(View v){
        Intent intent = new Intent(this, QuestionActivity.class);
    }
}
