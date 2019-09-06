package com.example.probandojava;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.probandojava.config.Config;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Button buttonCarreraRobot, buttonLaberintoRobot,buttonPeleaRobot,buttonSeguirLinea;

    HttpTransport transport = AndroidHttp.newCompatibleTransport();
    JsonFactory factory = JacksonFactory.getDefaultInstance();
    final Sheets sheetsService = new Sheets.Builder(transport, factory, null)
            .setApplicationName("Competencia Robotica")
            .build();

    final String spreadsheetId = Config.spreadsheet_id;


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

        new Thread() {
            @Override
            public void run() {
                try {
                    String range = "CarreraRobot!A2:B6";
                    ValueRange result = sheetsService.spreadsheets().values()
                            .get(spreadsheetId, range)
                            .setKey(Config.google_api_key)
                            .execute();

                    List<List<Object>> values = result.getValues();

                    System.out.println(values);
                    System.out.println("Equipos" + "Puntajes");
                    for (List row : values){
                        System.out.println(values.get(0));
                        System.out.println(values.get(1));
                    }
                }
                catch (IOException e) {
                    System.out.println("Sheets failed" + e.getLocalizedMessage());
                }
            }
        }.start();
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

    public void openPeleaRobot(){
        Intent intent = new Intent(this, PeleaRobot.class);
        startActivity(intent);
    }
}