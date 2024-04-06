package com.example.laboratorio2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        getSupportActionBar().setTitle("Lab2 - IoT");

        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.textMain);
        registerForContextMenu(textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContextMenu(v);
            }
        });

        //Para pasar a la vista de indicaciones
        Button btnIndicaciones = findViewById(R.id.btnIndicaciones);
        btnIndicaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IndicacionesActivity.class);
                startActivity(intent);
            }
        });

        //Pasar  a la vista de calculos
        Button btnCalculos = findViewById(R.id.btnCalcular1);
        btnCalculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculosActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        TextView textView = findViewById(R.id.textMain);

        if (item.getItemId() == R.id.menu_blue) {
            textView.setTextColor(Color.BLUE);
            return true;
        } else if (item.getItemId() == R.id.menu_green) {
            textView.setTextColor(Color.GREEN);
            return true;
        } else if (item.getItemId() == R.id.menu_red) {
            textView.setTextColor(Color.RED);
            return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // Manejar la acción de la configuración aquí
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
