package com.example.cc10624triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 private Button tButton, fButton, nButton, pButton;
 private TextView tQuestion, tScore;
 private int currentidx = 0, score = 0;

 private TrueorFalse[] questionBank = new TrueorFalse[]{
         new TrueorFalse(R.string.q1, true),
         new TrueorFalse(R.string.q2,false),
         new TrueorFalse(R.string.q3,false),
         new TrueorFalse(R.string.q4,false ),
         new TrueorFalse(R.string.q5,true),
         new TrueorFalse(R.string.q6,true),
         new TrueorFalse(R.string.q7,false),
         new TrueorFalse(R.string.q8,true),
         new TrueorFalse(R.string.q9,false),
         new TrueorFalse(R.string.q10,false),
         new TrueorFalse(R.string.end, false)


 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tButton=(Button) findViewById(R.id.btn_True);
        fButton =(Button) findViewById(R.id.btn_False);
        nButton=(Button) findViewById(R.id.btn_Next);
        pButton=(Button) findViewById(R.id.btn_Previous);

        tQuestion = findViewById(R.id.txtQuestion);
        tScore = findViewById(R.id.txtScore);

        int IdxQuestion =questionBank[currentidx].getIdxQuestion();
        tQuestion.setText(IdxQuestion);

        //next button
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentidx = (currentidx+1);
                int idxQuestion =questionBank[currentidx].getIdxQuestion();
                tQuestion.setText(idxQuestion);
            if(currentidx ==11){
            nButton.setEnabled(false);
            }
            else {
                nButton.setEnabled(true);
            }
            }
        });
        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentidx = (currentidx-1);
                int idxQuestion =questionBank[currentidx].getIdxQuestion();
                tQuestion.setText(idxQuestion);

            }
        });

        //true button
        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean keyAnswer = questionBank[currentidx].isKeyAnswer();
                if(keyAnswer == true){
                    score++;
                    Toast.makeText(MainActivity.this, R.string.msgcorrect, Toast.LENGTH_SHORT).show();
                    tScore.setText(String.valueOf(score));
                }
                else {
                    Toast.makeText(MainActivity.this, R.string.msgincorrect, Toast.LENGTH_SHORT).show();
                }
            }
        });
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean keyAnswer = questionBank[currentidx].isKeyAnswer();
                if(keyAnswer == false){
                    Toast.makeText(MainActivity.this, R.string.msgcorrect, Toast.LENGTH_SHORT).show();
                    score++;
                    tScore.setText(String.valueOf(score));
                }
                else{
                    Toast.makeText(MainActivity.this, R.string.msgincorrect, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}