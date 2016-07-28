package com.patornp.clickfrenzy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button myButton;
    private Button myClear;
    private TextView myMessage;
    private int numberClicked = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button) findViewById(R.id.button);
        myMessage = (TextView) findViewById(R.id.textView);
        myClear = (Button) findViewById(R.id.button2);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked++;
                myMessage.setText("Button was clicked " + numberClicked);
            }
        };

        View.OnClickListener onClickListenerClear = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked = 0;
                myMessage.setText("CLICK ME");
            }
        };

        myButton.setOnClickListener(onClickListener);
        myClear.setOnClickListener(onClickListenerClear);
    }


}
