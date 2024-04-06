package com.example.laboratorio2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IndicacionesActivity extends AppCompatActivity {
    public void onBtnCalcularClick(View view) {
        Intent intent = new Intent(IndicacionesActivity.this, CalculosActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicaciones);

        //Pasar  a la vista de calculos
        Button btnCalculos = findViewById(R.id.btnCalcular2);
        btnCalculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndicacionesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }



}
