package iiitd.nishant.primequiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNext;
    private TextView Question;

    private static final String TAG = "QuizActivity";

    private int Q = GenerateNumber(1, 1000);

    public static int GenerateNumber(int min, int max) {

        Random rand = new Random();
        int number = min + rand.nextInt((max - min) + 1);
        return number;
    }

    public static Boolean VerifyPrime(int num) {
        Boolean isPrime = true;
        int var;

        for(int i = 2; i <= num/2; i++)
        {
            var = num % i;
            if(var == 0)
            {
                isPrime=false;
                break;
            }
        }
        return isPrime;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mFalseButton = (Button) findViewById(R.id.FalseButton);
        mNext = (Button) findViewById(R.id.Next);
        Question = (TextView) findViewById(R.id.textView);

        Log.d(TAG, String.valueOf(Q));
        Question.setText(String.valueOf(Q));

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (VerifyPrime(Q)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "InCorrect", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!VerifyPrime(Q)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "InCorrect", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Q = GenerateNumber(1, 1000);
                Question.setText(String.valueOf(Q));
                Log.d(TAG, String.valueOf(Q));
            }
        });

    }


}
