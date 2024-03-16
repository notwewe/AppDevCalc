package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class ButtonExercise extends AppCompatActivity {

    Button open, hide, exit, toast, bgcolor, btncolor;
    View rootView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);

        rootView = findViewById(R.id.constraintLayout);

        open = findViewById(R.id.btnOpen);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ig = new Intent(ButtonExercise.this, LayoutExercise.class);
                startActivity(ig);
            }
        });

        hide = findViewById(R.id.btnHide);
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hide.setVisibility(View.GONE);
            }
        });

        toast = findViewById(R.id.btnToast);
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonExercise.this, "This is my Toast message!",
                        Toast.LENGTH_LONG).show();
            }
        });

        exit = findViewById(R.id.btnExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ret = new Intent(ButtonExercise.this, MainActivity.class);
                startActivity(ret);
            }
        });

        bgcolor = findViewById(R.id.bgcolorchng);
        bgcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = generateRandomColor();
                bgcolor.setBackgroundColor(color);
            }
        });

        btncolor = findViewById(R.id.btnclrchng);
        btncolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = generateRandomColor();
                rootView.setBackgroundColor(color);
            }
        });
    }

    private int generateRandomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return Color.rgb(red, green, blue);
    }
}

