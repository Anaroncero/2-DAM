package com.example.ejercicio_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    //1.Crear objetos y variables
    private Button botonIr;
    private EditText campoTexto, campoApellido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //2.Asociar objetos Java a XML
        botonIr = findViewById(R.id.btn_ir);
        campoTexto = findViewById(R.id.nombre);
        campoApellido = findViewById(R.id.apellido);

        //Cambia de pantalla
        botonIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent abrirPantalla = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(abrirPantalla);

            }
        });

        ///3. Eventos, logica, conexiones a bbdd, etc, etc, etc
        botonIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //OPCION 1 CON CLASE Datos;
                //Metodo pasar dato a través de clase static
                String apellido = campoApellido.getText().toString();
                Datos.setApellido(apellido);


                //OPCION 2 CON Intent
                //Metodo para pasar dato a través de Intent y putExtra
                String palabra = campoTexto.getText().toString();
                Intent abrirPantalla = new Intent(MainActivity.this, MainActivity2.class);
                abrirPantalla.putExtra("texto", palabra);
                startActivity(abrirPantalla);

            }
        });
    }
}