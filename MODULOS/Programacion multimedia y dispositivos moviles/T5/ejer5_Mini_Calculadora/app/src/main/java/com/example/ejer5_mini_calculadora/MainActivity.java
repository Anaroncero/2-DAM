package com.example.ejer5_mini_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Crear variables
    private double resultado = 0;
    private EditText num1;
    private EditText num2;
    private Button botonSumar;
    private Button botonRestar;
    private Button botonMultiplicar;
    private Button botonDividir;
    private TextView textoResultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asociamos el objeto al elemento
        num1 = findViewById(R.id.editTextNum1);
        num2 = findViewById(R.id.editTextNum2);
        textoResultado = findViewById(R.id.textoResultado);
        botonSumar = findViewById(R.id.buttonSumar);

        botonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = Integer.parseInt(num1.getText().toString());
                double n2 = Integer.parseInt(num2.getText().toString());
                resultado = n1 + n2;
                textoResultado.setText("" + resultado);
            }
        });

        botonRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = Integer.parseInt(num1.getText().toString());
                double n2 = Integer.parseInt(num2.getText().toString());
                resultado = n1 - n2;
                textoResultado.setText("" + resultado);
            }
        });


    }
}