package com.patornp.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button add;
    private Button minus;
    private Button times;
    private Button divide;
    private Button clear;
    private EditText fieldOperatorOne;
    private EditText fieldOperatorTwo;
    private TextView calculatedResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.button);
        minus = (Button) findViewById(R.id.button2);
        times = (Button) findViewById(R.id.button3);
        divide = (Button) findViewById(R.id.button4);
        clear = (Button) findViewById(R.id.button5);
        fieldOperatorOne = (EditText) findViewById(R.id.fieldOne);
        fieldOperatorTwo = (EditText) findViewById(R.id.fieldTwo);
        calculatedResult = (TextView) findViewById(R.id.textView3);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fieldOperatorTwo.getText().toString().length()>0 && fieldOperatorTwo.getText().toString().length()>0) {
                    double firstNum = Double.parseDouble(fieldOperatorOne.getText().toString());
                    double secondNum = Double.parseDouble(fieldOperatorTwo.getText().toString());
                    double result = firstNum + secondNum;
                    calculatedResult.setText(Double.toString(result));
                } else {
                    Toast.makeText(MainActivity.this, "No blanks. Enter numbers again", Toast.LENGTH_LONG).show();
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fieldOperatorTwo.getText().toString().length()>0 && fieldOperatorTwo.getText().toString().length()>0) {
                    double firstNum = Double.parseDouble(fieldOperatorOne.getText().toString());
                    double secondNum = Double.parseDouble(fieldOperatorTwo.getText().toString());
                    double result = firstNum - secondNum;
                    calculatedResult.setText(Double.toString(result));
                } else {
                    Toast.makeText(MainActivity.this, "No blanks. Enter numbers again", Toast.LENGTH_LONG).show();
                }
            }
        });

        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fieldOperatorTwo.getText().toString().length()>0 && fieldOperatorTwo.getText().toString().length()>0) {
                    double firstNum = Double.parseDouble(fieldOperatorOne.getText().toString());
                    double secondNum = Double.parseDouble(fieldOperatorTwo.getText().toString());
                    double result = firstNum * secondNum;
                    calculatedResult.setText(Double.toString(result));
                } else {
                    Toast.makeText(MainActivity.this, "No blanks. Enter numbers again", Toast.LENGTH_LONG).show();
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fieldOperatorTwo.getText().toString().length()>0 && fieldOperatorTwo.getText().toString().length()>0) {
                    double firstNum = Double.parseDouble(fieldOperatorOne.getText().toString());
                    double secondNum = Double.parseDouble(fieldOperatorTwo.getText().toString());
                    double result = firstNum / secondNum;
                    calculatedResult.setText(Double.toString(result));
                } else {
                    Toast.makeText(MainActivity.this, "No blanks. Enter numbers again", Toast.LENGTH_LONG).show();
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatedResult.setText("0.00");
                fieldOperatorOne.setText("");
                fieldOperatorTwo.setText("");
            }
        });
    }
}
