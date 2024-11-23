package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botonCorreo;
    private Button botonTelefono;
    private Button botonNav;

    private EditText correo;
    private EditText telefono;
    private EditText url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonTelefono = findViewById(R.id.buttonTelefono);
        telefono = findViewById(R.id.telefonoInput);

        botonCorreo = findViewById(R.id.buttonCorreo);
        correo = findViewById(R.id.correoInput);

        botonNav = findViewById(R.id.buttonNav);
        url = findViewById(R.id.navInput);

        botonTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el número de teléfono del campo de entrada
                String numeroTelefono = telefono.getText().toString().trim();

                // Validar que no esté vacío
                if (!numeroTelefono.isEmpty()) {
                    Intent tlfIntent = new Intent(Intent.ACTION_DIAL);
                    tlfIntent.setData(Uri.parse("tel:" + numeroTelefono)); // Usar el número de teléfono ingresado
                    startActivity(tlfIntent);
                } else {
                    // Mostrar un mensaje si el campo está vacío
                    Toast.makeText(MainActivity.this, "Por favor, ingresa un número de teléfono", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Funcionalidad del botón de correo
        botonCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener la dirección de correo del campo de entrada
                String email = correo.getText().toString().trim();

                // Validar que no esté vacío
                if (!email.isEmpty()) {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse("mailto:" + email)); // Usar la dirección de correo ingresada

                    try {
                        startActivity(emailIntent);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "No hay aplicaciones de correo instaladas", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Mostrar un mensaje si el campo está vacío
                    Toast.makeText(MainActivity.this, "Por favor, ingresa una dirección de correo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Funcionalidad del botón de navegador
        botonNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener la URL del campo de entrada
                String urlTexto = url.getText().toString().trim();

                // Validar que no esté vacío
                if (!urlTexto.isEmpty()) {
                    // Validar que la URL comienza con "http://" o "https://"

                    Intent navIntent = new Intent(Intent.ACTION_VIEW);
                    navIntent.setData(Uri.parse(urlTexto));
                    try {
                        startActivity(navIntent);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "No se pudo abrir el navegador", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Mostrar un mensaje si el campo está vacío
                    Toast.makeText(MainActivity.this, "Por favor, ingresa una URL", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




    }

