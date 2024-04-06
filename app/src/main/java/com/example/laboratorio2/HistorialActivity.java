package com.example.laboratorio2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class HistorialActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

//        List<Double> historialResultados = (List<Double>) getIntent().getSerializableExtra("historialResultados");
//
//        LinearLayout linearLayout = findViewById(R.id.linearLayout);
//        for (int i = 0; i < historialResultados.size(); i++) {
//            String resultadoString = "Respuesta " + (i + 1) + ": " + historialResultados.get(i);
//            TextView textView = new TextView(this);
//            textView.setText(resultadoString);
//            linearLayout.addView(textView);
//        }


    }
    public void onBtnCalcularClick3(View view) {
        Intent intent = new Intent(HistorialActivity.this, CalculosActivity.class);
        startActivity(intent);
    }

}
