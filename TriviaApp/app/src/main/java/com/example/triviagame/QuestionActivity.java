package com.example.triviagame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    private Question q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final Controller aController = (Controller) getApplicationContext();

        q = aController.getQuestion();

        TextView questionText = findViewById(R.id.questionText);
        questionText.setText(q.getQuestion());
    }

    public void performCheckAnswer(View v){
        EditText answerText = findViewById(R.id.answerText);
        String answer = answerText.getText().toString();

        Button answerButton = findViewById(R.id.answerButton);

        if(q.checkAnswer(answer)){
            answerButton.setBackgroundColor(Color.GREEN);
            answerButton.setText("Nice Job You Got This");
        } else{
            answerButton.setBackgroundColor(Color.RED);
            answerButton.setText("Try Again");
        }

    }

    public void performNext(View v){
        final Controller aController = (Controller) getApplicationContext();
        q = aController.getQuestion();
        TextView questionText = findViewById(R.id.questionText);
        questionText.setText(q.getQuestion());

        Button answerButton = findViewById(R.id.answerButton);
        answerButton.setBackgroundColor(Color.GRAY);
        answerButton.setText("Check Answer");
    }


}
