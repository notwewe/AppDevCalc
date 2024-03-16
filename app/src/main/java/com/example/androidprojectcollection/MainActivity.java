package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button layout, button, calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layout = (Button) findViewById(R.id.btnlayout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent out = new Intent(MainActivity.this, LayoutExercise.class);
                startActivity(out);
            }
        });

        button = (Button) findViewById(R.id.btnButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buttonExercise = new Intent(MainActivity.this, ButtonExercise.class);
                startActivity(buttonExercise);
            }
        });

        calc = (Button) findViewById(R.id.btnCalc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CalculatorExercise = new Intent(MainActivity.this, CalculatorExercise.class);
                startActivity(CalculatorExercise);
            }
        });
    }
}