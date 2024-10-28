package com.example.ejer7_abrir_otras_apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//url en chrome
//correo con el correo marcado
//telefono con el numero marcado

public class MainActivity extends AppCompatActivity {

    // 1.Crear variables

    private Button btnTlf;
    private Button btnEmail;
    private Button btnUrl;
    private EditText tlfInput;
    private EditText emailInput;
    private EditText urlInput;

    // CAE EN EXAMEN Clase Intent: ES FUNDAMENTAL PERMITE LANZAR OTRAS ACTIVITIS (PANTALLA A OTRA O OTRAS APLICACIONES) LANCE UNA PANTALLA O OTRA APLICACION
    // btnTlf = findViewById(R.id.bTlf);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 2.Asociar objetos a XML
        btnTlf = findViewById(R.id.bTlf);
        tlfInput = findViewById(R.id.tlfinput);

        // 3.Métodos

        btnTlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tlfIntent = new Intent(Intent.ACTION_DIAL); // Lanzar la app, eligiendo como
                tlfIntent.setData(Uri.parse("tel: " + tlfInput.getText())); // pasarle datos
                startActivity(tlfIntent); // Lanzarla
            }
        });

    }
}

