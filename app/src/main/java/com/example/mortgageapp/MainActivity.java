package com.example.mortgageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int years;
    double interest;
    int principal;
    double result;

    EditText principalInput;
    EditText yearsInput;
    EditText interestInput;
    TextView resultsOutput;

    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principalInput = (EditText) findViewById(R.id.principalInput);
        yearsInput = (EditText) findViewById(R.id.yearsInput);
        interestInput = (EditText) findViewById(R.id.interestInput);
        resultsOutput = (TextView) findViewById(R.id.resultsOutput);

        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if( TextUtils.isEmpty(yearsInput.getText()) || TextUtils.isEmpty(interestInput.getText()) || TextUtils.isEmpty(principalInput.getText()))
                {
                    showOutput("Please fill all fields correctly.");
                }
                else {
                    years = Integer.parseInt(yearsInput.getText().toString()) * 12;
                    interest = Float.parseFloat(interestInput.getText().toString()) / 1200;
                    principal = Integer.parseInt(principalInput.getText().toString());
                    result = principal * ((interest * Math.pow((1 + interest), years)) / (Math.pow((1 + interest), (years)) - 1));
                    resultsOutput.setText(String.format("%.2f", result));
                }
            }
        });



    }

    private void showOutput(String text){
        Toast.makeText(MainActivity.this,text, Toast.LENGTH_SHORT).show();
    }
}