package com.example.ejer4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Crear variables y objetos que vayamos a necesitar
    private int contador = 0;
    private TextView contadorTextView;
    private Button botonContar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //El código que sirve para enlazar interfaz con java

        // Asociamos el objeto al elemento correspondiente del xml
        contadorTextView = findViewById(R.id.textView);
        botonContar = findViewById(R.id.button);

        // Boton
        botonContar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                contadorTextView.setText(Integer.toString(contador));
            }
        });
    }
}


