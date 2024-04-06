package com.example.laboratorio2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;



public class CalculosActivity extends AppCompatActivity {
    public void onBtnCalcularClick2(View view) {
        Intent intent = new Intent(CalculosActivity.this, HistorialActivity.class);
        startActivity(intent);
    }

    private List<Double> historialResultados = new ArrayList<>();

    // Lista para almacenar los números y operaciones ingresadas
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.btnHistorial2) {
//            Intent intent = new Intent(CalculosActivity.this, HistorialActivity.class);
//            intent.putExtra("historialResultados", new ArrayList<>(historialResultados));
//            startActivity(intent);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    List<Double> numeros = new ArrayList<>();
    List<String> operaciones = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);




        // Obtener referencia al TextView B
        TextView textViewB = findViewById(R.id.textViewB);
        TextView textViewA = findViewById(R.id.textViewA);

        // Obtener referencias a los botones numéricos
        Button button0 = findViewById(R.id.btCero);
        Button button1 = findViewById(R.id.bt1);
        Button button2 = findViewById(R.id.bt2);
        Button button3 = findViewById(R.id.bt3);
        Button button4 = findViewById(R.id.bt4);
        Button button5 = findViewById(R.id.bt5);
        Button button6 = findViewById(R.id.bt6);
        Button button7 = findViewById(R.id.bt7);
        Button button8 = findViewById(R.id.bt8);
        Button button9 = findViewById(R.id.bt9);

        // Crear un método genérico para manejar los clicks de los botones numéricos

        // USE CHATGPT PARA HACERME UNA IDEA DE COMO CREAR UNA FUNCION GENERAL PARA LOS BOTONES DE NUMEROS

        View.OnClickListener numClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String currentText = textViewB.getText().toString();
                String newText = button.getText().toString();

                if(currentText == "ERROR"){
                    textViewB.setText("0");
                    currentText = textViewB.getText().toString();
                    if (currentText.equals("0")) {
                        textViewB.setText(newText);
                    } else {
                        newText = currentText + newText;
                        textViewB.setText(newText);
                    }
                }
                else{
                    if (currentText.equals("0")) {
                        textViewB.setText(newText);
                    } else {
                        newText = currentText + newText;
                        textViewB.setText(newText);
                    }
                }

            }

        };


        // Asignar el método onClickListener a los botones numéricos
        button0.setOnClickListener(numClickListener);
        button1.setOnClickListener(numClickListener);
        button2.setOnClickListener(numClickListener);
        button3.setOnClickListener(numClickListener);
        button4.setOnClickListener(numClickListener);
        button5.setOnClickListener(numClickListener);
        button6.setOnClickListener(numClickListener);
        button7.setOnClickListener(numClickListener);
        button8.setOnClickListener(numClickListener);
        button9.setOnClickListener(numClickListener);

        //Identificar el tipo de operacion

        Button buttonDiv = findViewById(R.id.btDiv);
        Button buttonSum = findViewById(R.id.btPlus);
        Button buttonRes = findViewById(R.id.btRes);
        Button buttonMult = findViewById(R.id.btMult);

        // Crear un método genérico para manejar los clicks de los botones de operación

        View.OnClickListener opClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;

                String textb = textViewB.getText().toString();
                if(textb == "ERROR"){
                    textViewA.setText("0");
                    textViewB.setText("0");

                }
                else{
                    //Se obtiene la operacion
                    String op = button.getText().toString();
                    operaciones.add(op);

                    numeros.add(Double.parseDouble(textb));

                    String extra = textb + op;
                    textViewA.setText(extra);

                    textViewB.setText("0");
                }

            }
        };

        // Asignar el método onClickListener a los botones de operación
        buttonDiv.setOnClickListener(opClickListener);
        buttonSum.setOnClickListener(opClickListener);
        buttonRes.setOnClickListener(opClickListener);
        buttonMult.setOnClickListener(opClickListener);


        //Boton borrar
        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewB.setText("0");
                numeros.clear();
                operaciones.clear();
                System.out.println("Listas limpiadas");
            }
        });


        //Boton Igual
        Button btIgual = findViewById(R.id.btIgual);
        btIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String operador = operaciones.get(0);
                Double num1 = numeros.get(0);
                Double num2 = Double.parseDouble(textViewB.getText().toString());
                Double resultado = 0.0;
                switch (operador) {
                    case "+":
                        resultado = num1 + num2;
                        break;
                    case "-":
                        resultado = num1 - num2;
                        break;
                    case "*":
                        resultado = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            resultado = num1 / num2;
                        } else {
                            textViewA.setText("0");
                            textViewB.setText("ERROR");
                            return;
                        }
                        break;
                }

                // Verificar si el resultado tiene más de 6 decimales
                String resultadoString = String.valueOf(resultado);
                int index = resultadoString.indexOf('.');
                if (index != -1 && resultadoString.length() - index - 1 > 6) {
                    // Redondear el resultado a 6 decimales
                    BigDecimal bd = new BigDecimal(resultado).setScale(6, RoundingMode.HALF_UP);
                    resultado = bd.doubleValue();
                }

                textViewA.setText(String.valueOf(resultado));
                operaciones.clear();
                textViewB.setText(resultado.toString());
                numeros.set(0, resultado);
                textViewA.setText("0");
                textViewB.setText(resultado.toString());

                historialResultados.add(resultado);

            }

        });
    }
}