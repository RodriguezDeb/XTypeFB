package com.example.xtypee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class choice extends AppCompatActivity {

    private Button buttonl,buttonr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_choice1);

        buttonl = findViewById(R.id.buttonL);
        buttonr = findViewById(R.id.buttonR);

        buttonr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice.this, registro.class);
                startActivity(intent);
            }
        });
        buttonl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choice.this, login.class);
                startActivity(intent);
            }
        });

    }
}