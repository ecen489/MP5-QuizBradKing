package com.example.ytquiz;


import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
public int Score;
Random rng = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ScoreBoard = (TextView) findViewById(R.id.ScoreView);

        Bundle intentData = getIntent().getExtras();
        if(intentData == null)
        {
            ScoreBoard.setText("Score = " + Score);
            return;
        }
        int scoreAdder = intentData.getInt("ScoreNum");
        Toast.makeText(this,Integer.toString(scoreAdder),Toast.LENGTH_LONG).show();
        Score = Score+scoreAdder;
        ScoreBoard.setText("Score = " + Score);
    }

    public void pewClick(View v) {
        int row = rng.nextInt(3);
        Intent intent2 = new Intent(this, Activity2.class);
        intent2.putExtra("maininfo", row);
        intent2.putExtra("scoreInfo", Score);
        startActivity(intent2);
    }

    public void h3Click(View v) {
        Intent intent2 = new Intent(this, Activity2.class);
        int row = rng.nextInt(3)+3;
        intent2.putExtra("maininfo", row);
        intent2.putExtra("scoreInfo", Score);
        startActivity(intent2);
    }

    public void rtClick(View v) {
        Intent intent2 = new Intent(this, Activity2.class);
        int row = rng.nextInt(3)+6;
        intent2.putExtra("maininfo", row);
        intent2.putExtra("scoreInfo", Score);
        startActivity(intent2);
    }

    public void scoreReset(View v)
    {
        TextView ScoreBoard = (TextView) findViewById(R.id.ScoreView);
        Score = 0;
        ScoreBoard.setText("Score = " + Score);
    }

}
