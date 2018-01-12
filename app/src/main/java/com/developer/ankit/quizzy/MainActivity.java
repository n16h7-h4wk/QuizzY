package com.developer.ankit.quizzy;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    Button mOptionAButton , mOptionBButton, mOptionCButton , mOptionDButton ;
    TextView mScoreTextView , mQuestionTextView ;
    ProgressBar mProgressBar ;
    int mScore ;
    int mIndex = 0;
    int mQuestion ;
    private MCQ[] mQuestionBank = new MCQ[]{
            new MCQ(R.string.question_1,R.string.option_1C),
            new MCQ(R.string.question_2,R.string.option_2B),
            new MCQ(R.string.question_3,R.string.option_3A),
            new MCQ(R.string.question_4,R.string.option_4D),
            new MCQ(R.string.question_5,R.string.option_5B),
            new MCQ(R.string.question_6,R.string.option_6B),
            new MCQ(R.string.question_7,R.string.option_7D),
            new MCQ(R.string.question_8,R.string.option_8B),
            new MCQ(R.string.question_9,R.string.option_9C),
            new MCQ(R.string.question_10,R.string.option_10A)



    };
    private optionClass[] mOptionBank = new optionClass[]{
            new optionClass(R.string.option_1A,R.string.option_1B,R.string.option_1C,R.string.option_1D),
            new optionClass(R.string.option_2A,R.string.option_2B,R.string.option_2C,R.string.option_2D),
            new optionClass(R.string.option_3A,R.string.option_3B,R.string.option_3C,R.string.option_3D),
            new optionClass(R.string.option_4A,R.string.option_4B,R.string.option_4C,R.string.option_4D),
            new optionClass(R.string.option_5A,R.string.option_5B,R.string.option_5C,R.string.option_5D),
            new optionClass(R.string.option_6A,R.string.option_6B,R.string.option_6C,R.string.option_6D),
            new optionClass(R.string.option_7A,R.string.option_7B,R.string.option_7C,R.string.option_7D),
            new optionClass(R.string.option_8A,R.string.option_8B,R.string.option_8C,R.string.option_8D),
            new optionClass(R.string.option_9A,R.string.option_9B,R.string.option_9C,R.string.option_9D),
            new optionClass(R.string.option_10A,R.string.option_10B,R.string.option_10C,R.string.option_10D),
    };
    final int PROGRESS_BAR_INCREMENT = (int)Math.ceil(100.0/mQuestionBank.length);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOptionAButton = findViewById(R.id.option_A);
        mOptionBButton = findViewById(R.id.option_B);
        mOptionCButton = findViewById(R.id.option_C);
        mOptionDButton = findViewById(R.id.option_D);
        mQuestionTextView = findViewById(R.id.question_text_view);
        mScoreTextView = findViewById(R.id.score);
        mProgressBar = findViewById(R.id.progress_bar);


        mOptionAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(mOptionBank[mIndex].getA());
                updateView();

            }
        });
        mOptionBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(mOptionBank[mIndex].getB());
                updateView();
            }
        });
        mOptionCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(mOptionBank[mIndex].getC());
                updateView();
            }
        });
        mOptionDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(mOptionBank[mIndex].getD());
                updateView();
            }
        });

    }
    private void updateView(){
        mIndex = (mIndex +1)%mQuestionBank.length;
        if(mIndex==0){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("You Scored " + mScore + " points");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }

            });
            alert.show();
        }
        mQuestion = mQuestionBank[mIndex].getmQuestionID();
        mQuestionTextView.setText(mQuestion);
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        mScoreTextView.setText("Score " + mScore + "/" + mQuestionBank.length);
        mOptionAButton.setText(mOptionBank[mIndex].getA());
        mOptionBButton.setText(mOptionBank[mIndex].getB());
        mOptionCButton.setText(mOptionBank[mIndex].getC());
        mOptionDButton.setText(mOptionBank[mIndex].getD());

    }
    private void checkAnswer(int ans){
        int myAns = mQuestionBank[mIndex].getmAnswerID();
        if(myAns==ans){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            mScore++;
        }else{
            Toast.makeText(getApplicationContext(),R.string.wrong_toast,Toast.LENGTH_SHORT).show();
        }

    }
}
