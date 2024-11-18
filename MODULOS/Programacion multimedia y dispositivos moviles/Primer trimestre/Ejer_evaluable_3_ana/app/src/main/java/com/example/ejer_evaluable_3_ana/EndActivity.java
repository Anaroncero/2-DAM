package com.example.ejer_evaluable_3_ana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    //Variables
    private Button btnIniciar;
    private TextView mostrarNombre, mostrarRecord, mostrarCorrectas, mostrarErroneas, mostrarBlanco;


    //Almacenar datos
    private String nombreUsuario;
    private int puntuacion;
    private int correctas, erroneas, blancas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        //2. Asociar los elementos de la interfaz con las variables en Java
        mostrarNombre = findViewById(R.id.mostrarNombre);
        mostrarRecord = findViewById(R.id.mostrarRecord);
        mostrarCorrectas = findViewById(R.id.mostrarCorrectas);
        mostrarErroneas = findViewById(R.id.mostrarErroneas);
        mostrarBlanco = findViewById(R.id.mostrarBlanco);
        btnIniciar = findViewById(R.id.buttonIniciar);


        //Recibir los datos de la actividad anterior
        nombreUsuario = getIntent().getStringExtra("usuario");
        puntuacion = getIntent().getIntExtra("puntuacion", 0);
        correctas = getIntent().getIntExtra("correctas", 0);
        erroneas = getIntent().getIntExtra("erroneas", 0);
        blancas = getIntent().getIntExtra("blancas", 0);

        // Mostrar los resultados en los TextViews correspondientes
        mostrarNombre.setText(nombreUsuario);
        mostrarCorrectas.setText(correctas);
        mostrarErroneas.setText(erroneas);
        mostrarBlanco.setText(blancas);  // Asumiendo que no se guarda el número de respuestas sin responder



    }


}