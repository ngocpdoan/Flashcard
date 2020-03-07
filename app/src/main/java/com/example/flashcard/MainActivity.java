package com.example.flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_wronganswer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_wronganswer2).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView rightAnswer = (TextView)findViewById(R.id.flashcard_answer);
                rightAnswer.setTextColor(getResources().getColor(R.color.green));
                findViewById(R.id.flashcard_question).setBackgroundColor(getResources().getColor(R.color.green));
            }
        });

        findViewById(R.id.flashcard_wronganswer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView wrongAnswer = (TextView)findViewById(R.id.flashcard_wronganswer);
                wrongAnswer.setTextColor(getResources().getColor(R.color.red));
                TextView rightAnswer = (TextView)findViewById(R.id.flashcard_answer);
                rightAnswer.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });

        findViewById(R.id.flashcard_wronganswer2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView wrongAnswer2 = (TextView)findViewById(R.id.flashcard_wronganswer2);
                wrongAnswer2.setTextColor(getResources().getColor(R.color.red));
                TextView rightAnswer = (TextView)findViewById(R.id.flashcard_answer);
                rightAnswer.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });

        addButton = (Button) findViewById(R.id.button2);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddCardActivity();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            String string1 = data.getExtras().getString("string1");
            String string2 = data.getExtras().getString("string2");
            TextView newQuestion = (TextView)findViewById(R.id.flashcard_question);
            newQuestion.setText(string1);
            TextView newAnswer = (TextView)findViewById(R.id.flashcard_answer);
            newAnswer.setText(string2);
        }
    }

    public void openAddCardActivity() {
        Intent intent = new Intent(this, AddCardActivity.class);
        startActivityForResult(intent, 100);
    }
}