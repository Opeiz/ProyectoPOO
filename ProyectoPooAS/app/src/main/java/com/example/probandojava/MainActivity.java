package com.example.probandojava;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonCarreraRobot, buttonLaberintoRobot,buttonPeleaRobot,buttonSeguirLinea;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCarreraRobot = (Button) findViewById(R.id.CarreraRobot);
        buttonLaberintoRobot = (Button) findViewById(R.id.LaberintoRobot);
        buttonPeleaRobot = (Button) findViewById(R.id.PeleaRobot);
        buttonSeguirLinea = (Button) findViewById(R.id.SeguirLinea);

        buttonCarreraRobot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCarreraRobot();
            }
        });

        buttonLaberintoRobot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openLaberintoRobot();
            }
        });

        buttonPeleaRobot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openPeleaRobot();
            }
        });

        buttonSeguirLinea.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSeguirLinea();
            }
        });
    }

    public void openCarreraRobot() {
        Intent intent = new Intent(this, CarreraRobot.class);
        startActivity(intent);
    }

    public void openLaberintoRobot() {
        Intent intent = new Intent(this, LaberintoRobot.class);
        startActivity(intent);
    }

    public void openSeguirLinea() {
        Intent intent = new Intent(this, SeguirLinea.class);
        startActivity(intent);
    }

    public void openPeleaRobot() {
        Intent intent = new Intent(this, PeleaRobot.class);
        startActivity(intent);
    }
}