package com.example.laboratorio2;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HistorialActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        // Obtener el ScrollView y el LinearLayout
        ScrollView scrollView = findViewById(R.id.scrollView2);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        // Recibir el resultado enviado desde CalculosActivity
        Double resultado = getIntent().getDoubleExtra("resultado", 0.0);

        // Crear un nuevo TextView con el resultado
        TextView textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setText("Respuesta: " + resultado.toString());

        linearLayout.addView(textView);
    }
}
