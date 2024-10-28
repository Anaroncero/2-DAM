package com.example.ejer6_tamano_texto_boton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // 1. Creo variables
    private TextView texto;
    private Button btnAumentar;
    private Button btnReducir;
    private Button btnColor;
    private Button btnTostada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 2. Asociar objetos Java (creados arriba) a id de ocmponentes gráficos XML
        texto = findViewById(R.id.textView);
        btnAumentar= findViewById(R.id.botonAumentar);
        btnReducir = findViewById(R.id.botonReducir);
        btnColor = findViewById(R.id.botonCambiarColor);
        btnTostada = findViewById(R.id.botonTostada);


        // 3. Eventos, lógica, conexiones a bbdd, etc, etc, etc
        btnAumentar.setOnClickListener (new View.OnClickListener() {

            @Override
            public void onClick(View view){
                texto.setTextSize(TypedValue.COMPLEX_UNIT_PX, texto.getTextSize()+20);
            }
        });

        btnReducir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                texto.setTextSize(TypedValue.COMPLEX_UNIT_PX, texto.getTextSize()-20);
                // hay que hacerlo en px en vez de ps porque si no no funciona
            }
        });

        btnColor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                int randomColor = Color.rgb( (int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256) );
                texto.setTextColor(randomColor);
            }
        });

        // Pop up
        btnTostada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "HOLA!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}