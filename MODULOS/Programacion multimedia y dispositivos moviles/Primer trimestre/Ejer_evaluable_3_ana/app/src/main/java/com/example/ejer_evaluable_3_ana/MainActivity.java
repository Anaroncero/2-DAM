package com.example.ejer_evaluable_3_ana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1.Crear objetos y variables
    private Button botonIniciar;
    private EditText nombreInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.Asociar objetos Java a XML
        botonIniciar = findViewById(R.id.buttonIniciar);
        nombreInput = findViewById(R.id.nombreInput);

        // Botón siguiente pantalla INTENT y pasar datos clase static Datos
        botonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nombreInput != null && !nombreInput.getText().toString().isEmpty()){
                    // Obtener el nombre del EditText
                    String nombre = nombreInput.getText().toString();

                    // Método para pasar dato a través de clase Datos
                    Datos.setNombre(nombre);

                    // Iniciar la nueva activity
                    Intent abrirPantalla = new Intent(MainActivity.this, Test1Activity.class);
                    startActivity(abrirPantalla);

                }else{
                    String mensaje = "Por favor, introduzca su nombre";
                    //Toast personalizado en caso de que no introduzca nombre
                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();


                }

            }
        });


    }
}