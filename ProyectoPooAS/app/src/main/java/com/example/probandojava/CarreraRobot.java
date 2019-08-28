package com.example.probandojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.ObjectStreamException;
import java.util.List;

public class CarreraRobot extends AppCompatActivity {
    private Button buttonRefresh;
    final AskInfo info = new AskInfo();
    private List<List<Object>> Valores = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_robot);

        buttonRefresh = (Button) findViewById(R.id.RefreshCarreraRobot);

        Valores = info.AskInfoCR();

        String Equipo1 = (String) Valores.get(0).get(0);
        String Equipo2 = (String) Valores.get(1).get(0);
        String Equipo3 = (String) Valores.get(2).get(0);
        String Equipo4 = (String) Valores.get(3).get(0);
        String Equipo5 = (String) Valores.get(4).get(0);

        int Puntaje1 = (Integer) Valores.get(0).get(1);
        int Puntaje2 = (Integer) Valores.get(1).get(1);
        int Puntaje3 = (Integer) Valores.get(2).get(1);
        int Puntaje4 = (Integer) Valores.get(3).get(1);
        int Puntaje5 = (Integer) Valores.get(4).get(1);

        TextView Equipo1TV = (TextView)findViewById(R.id.Equipo1);
        TextView Equipo2TV = (TextView)findViewById(R.id.Equipo2);
        TextView Equipo3TV = (TextView)findViewById(R.id.Equipo3);
        TextView Equipo4TV = (TextView)findViewById(R.id.Equipo4);
        TextView Equipo5TV = (TextView)findViewById(R.id.Equipo5);

        TextView Puntaje1TV = (TextView)findViewById(R.id.Puntaje1);
        TextView Puntaje2TV = (TextView)findViewById(R.id.Puntaje2);
        TextView Puntaje3TV = (TextView)findViewById(R.id.Puntaje3);
        TextView Puntaje4TV = (TextView)findViewById(R.id.Puntaje4);
        TextView Puntaje5TV = (TextView)findViewById(R.id.Puntaje5);

        Equipo1TV.setText(Equipo1);
        Equipo2TV.setText(Equipo2);
        Equipo3TV.setText(Equipo3);
        Equipo4TV.setText(Equipo4);
        Equipo5TV.setText(Equipo5);

        Puntaje1TV.setText(Puntaje1);
        Puntaje2TV.setText(Puntaje2);
        Puntaje3TV.setText(Puntaje3);
        Puntaje4TV.setText(Puntaje4);
        Puntaje5TV.setText(Puntaje5);

        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });


    }
}