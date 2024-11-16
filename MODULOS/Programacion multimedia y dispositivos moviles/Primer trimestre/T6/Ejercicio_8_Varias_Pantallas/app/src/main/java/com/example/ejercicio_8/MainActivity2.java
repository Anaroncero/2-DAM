package com.example.ejercicio_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    //Variables
    private Button btnVolver;
    private TextView textoNombre, textoApellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //2. Asociar los elementos de la interfaz con las variales de Java
        btnVolver = findViewById(R.id.btn_volver);
        textoNombre = findViewById(R.id.textViewNombre);
        textoApellido = findViewById(R.id.textViewapellido);

        //OPCION 1 con clase Datos
        //Método para obtener el apellido a través de clase static
        String apellido = Datos.getApellido();
        textoApellido.setText(apellido);

        //OPCION 2 con Intent
        //obten el Intent y el valor palabra que le llega de la otra pantalla
        Intent intent = getIntent();
        String palabra = intent.getStringExtra("texto");

        //Configura el texto en el TextView
        textoNombre.setText(palabra);



        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent VolverPantalla = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(VolverPantalla);
            }
        });
    }
}