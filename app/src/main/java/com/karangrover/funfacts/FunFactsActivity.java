package com.karangrover.funfacts;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {
    private FactBook mFactBook = new FactBook();
    // Declare our view variables
    private TextView mFactTextView;
    private Button mShowFactButton;
    private ConstraintLayout mRelativeLayout;
    private ColorWheel mColorWheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Assign the views from the layout file to the corresponding variables
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (ConstraintLayout) findViewById(R.id.relativeLayout);
        mColorWheel = new ColorWheel();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update the screen with our dynamic fact and colors
                String fact = mFactBook.getRandomFact();
                mFactTextView.setText(fact);

                int color = mColorWheel.getRandomColor();
                mRelativeLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);
            }
        };
        mShowFactButton.setOnClickListener(listener);
    }
}
