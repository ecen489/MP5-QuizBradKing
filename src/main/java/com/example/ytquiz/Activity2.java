package com.example.ytquiz;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class Activity2 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_2);
//    }
//}

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import java.util.Scanner;

public class Activity2 extends AppCompatActivity {
    String[] questionlist = new String[9];
    String[] answerlist = new String[9];

    public int score = 0;
    public int rowNum;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle intentData = getIntent().getExtras();
         rowNum = intentData.getInt("maininfo");
         score = intentData.getInt("scoreInfo");
        Scanner scanq = new Scanner(getResources().openRawResource(R.raw.questions));
        Scanner scana = new Scanner(getResources().openRawResource(R.raw.answers));

        int i = 0;
        while(scanq.hasNextLine()){
            String lineq = scanq.nextLine();
            String linea = scana.nextLine();
            questionlist[i]=lineq;
            answerlist[i]= linea;
            i++;

            TextView questionView = (TextView) findViewById(R.id.QuestionView);
            questionView.setText(questionlist[rowNum]);


            Button answerButton = (Button) findViewById(R.id.buttoninput);
            answerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                    EditText ansInput = (EditText) findViewById(R.id.usertype);
                    String usersAnswer = ansInput.getText().toString();

                    if ( usersAnswer.equals(answerlist[rowNum]) )
                    {
                        score++;
                    }


                    String scoreS = Integer.toString(score);
                   // Toast.makeText(getApplicationContext(),scoreS,Toast.LENGTH_LONG).show();
                    Intent Malcontent = new Intent(v.getContext(), MainActivity.class);
                    Malcontent.putExtra("ScoreNum", score);
                    startActivity(Malcontent);

                }
            });

        }





    }
}
