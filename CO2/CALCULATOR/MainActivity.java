package com.example.c2calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private String currentInput = "";
    private String operator = "";
    private double firstOperand = 0;
    private double secondOperand = 0;
    private boolean isNewInput = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextView
        textView = findViewById(R.id.textView);

        // Initialize GridLayout
        GridLayout gridLayout = findViewById(R.id.gridLayout);

        // Define button labels
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        // Create and add buttons to GridLayout
        for (String label : buttonLabels) {
            Button button = new Button(this);
            button.setText(label);
            button.setTextSize(24);
            button.setOnClickListener(this);
            gridLayout.addView(button);
        }
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "=":
                calculateResult();
                break;
            case "C":
                clearInput();
                break;
            default:
                handleInput(buttonText);
                break;
        }
    }
