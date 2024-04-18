package com.example.ass1_1190618;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz extends AppCompatActivity {

    private RadioGroup options1;
    private RadioGroup options2;
    private EditText answer3;
    private Button checkButton;
    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        options1 = findViewById(R.id.options1);
        options2 = findViewById(R.id.options2);
        answer3 = findViewById(R.id.answer3);
        checkButton = findViewById(R.id.check_button);
        scoreTextView = findViewById(R.id.score_text_view);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });
    }

    private void checkAnswers() {
        int score = 0;

        RadioButton radioButton1 = findViewById(options1.getCheckedRadioButtonId());
        if (radioButton1 != null && radioButton1.getId() == R.id.option1_1) {
            score++;
        }

        RadioButton radioButton2 = findViewById(options2.getCheckedRadioButtonId());
        if (radioButton2 != null && radioButton2.getId() == R.id.option2_2) {
            score++;
        }

        String answerText = answer3.getText().toString().trim();
        if (answerText.equalsIgnoreCase("eagle")) {
            score++;
        }

        scoreTextView.setText("Your score: " + score);
        scoreTextView.setVisibility(View.VISIBLE);
    }
}
