package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //this class has access to the two labels, the two edit text boxes, the four buttons, and the answer label
    //step 1: Get the values from the two text boxes
    //step 2: perform the respective calculation
    //step 3: display the answer to the answer label
    //step 4: open up a new screen, pass the answer and show it on the new screen

    private double getFirstNum(){
        EditText firstNumText = findViewById(R.id.firstNum);
        String firstNumStr = firstNumText.getText().toString();
        if(firstNumStr.isEmpty())
            firstNumStr = "0";
        return Double.parseDouble(firstNumStr);
    }

    private double getSecondNum(){
        EditText secondNumText = findViewById(R.id.secondNum);
        String secondNumStr = secondNumText.getText().toString();
        if(secondNumStr.isEmpty())
            secondNumStr = "0";
        return Double.parseDouble(secondNumStr);
    }

    private void setAnswer(double ans){
        TextView ansText = findViewById(R.id.answerLabel);
        String ansStr = Double.toString(ans);
        ansText.setText("Answer: " + ansStr);

        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra("answer", ansStr);//key value pair, lookup answer in the new activity
        startActivity(intent);
    }

    public void performAddition(View v){

        double fNum = getFirstNum();
        double sNum = getSecondNum();

        double ans = fNum + sNum;

        setAnswer(ans);

        Toast toast = Toast.makeText(getApplicationContext(), "Adding values " + fNum + " " + sNum, Toast.LENGTH_LONG); //popup message with helpful information
        toast.show();
    }

    public void performSubtraction(View v){

        double fNum = getFirstNum();
        double sNum = getSecondNum();

        double ans = fNum - sNum;

        setAnswer(ans);

        Toast toast = Toast.makeText(getApplicationContext(), "Subtracting values " + fNum + " " + sNum, Toast.LENGTH_LONG); //popup message with helpful information
        toast.show();
    }

    public void performMultiplication(View v){

        double fNum = getFirstNum();
        double sNum = getSecondNum();

        double ans = fNum * sNum;

        setAnswer(ans);

        Toast toast = Toast.makeText(getApplicationContext(), "Multiplying values " + fNum + " " + sNum, Toast.LENGTH_LONG); //popup message with helpful information
        toast.show();
    }

    public void performDivision(View v){

        double fNum = getFirstNum();
        double sNum = getSecondNum();
        double ans;
        if(sNum != 0){
            ans = fNum / sNum;
            Toast toast = Toast.makeText(getApplicationContext(), "Dividing values " + fNum + " " + sNum, Toast.LENGTH_LONG); //popup message with helpful information
            toast.show();
            setAnswer(ans);
        }else {
            Toast toast = Toast.makeText(getApplicationContext(), "error dividing by 0", Toast.LENGTH_LONG); //popup message with helpful information
            toast.show();
        }
    }
}
