package com.example.triviagame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
    }

    private void readQuestionData(){
        InputStream is = getResources().openRawResource(R.raw.trivia);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = "";
        try {
            while((line = reader.readLine())!= null){
                String[] fields = line.split(",");
                Log.v("MainActivity", fields[0] + " " + fields[1]);
                Question q = new Question(fields[0], fields[1]);
            }
        } catch(IOException e){

        }
    }
}
