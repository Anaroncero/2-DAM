package com.example.ejer_evaluable_3_ana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    //Variables
    private Button btnIniciar;
    private TextView mostrarNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        //2. Asociar los elementos de la interfaz con las variables en Java
        btnIniciar = findViewById(R.id.buttonIniciar);
        mostrarNombre = findViewById(R.id.mostrarNombre);

        //Obtenemos el nombre de la clase Datos static
        String nombreObtenido = Datos.getNombre();

        //Mostramos el nombre cojido en el textField
        mostrarNombre.setText(nombreObtenido);


    }
}