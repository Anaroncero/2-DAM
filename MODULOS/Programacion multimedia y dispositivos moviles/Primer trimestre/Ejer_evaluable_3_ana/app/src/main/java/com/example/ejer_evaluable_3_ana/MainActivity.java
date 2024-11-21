package com.example.ejer_evaluable_3_ana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 1. Crear objetos y variables
    private Button btnIniciar;
    private EditText usuarioInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Asociar objetos Java a XML
        btnIniciar = findViewById(R.id.buttonIniciar);
        usuarioInput = findViewById(R.id.editTextUsuario);

        // Botón iniciar para ir a la siguiente pantalla (Test1Activity)
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = usuarioInput.getText().toString().trim(); // Obtener el usuario y eliminar espacios en blanco

                // Verificar si el usuario no está vacío
                if (!usuario.isEmpty()) {
                    // Validar que el nombre solo contenga letras y números, no sea solo números, y tenga una longitud válida
                    if (usuario.matches("^[a-zA-Z0-9]+$") && !usuario.matches("\\d+") && usuario.length() <= 9 && usuario.length() >= 3) {
                        // Inicializar la base de datos


                        // Iniciar la nueva activity (Test1Activity) y pasar el nombre del usuario
                        Intent abrirPantalla = new Intent(MainActivity.this, Test1Activity.class);
                        abrirPantalla.putExtra("usuario", usuario); // Pasamos el nombre al Intent
                        startActivity(abrirPantalla);

                    } else {
                        // Validaciones para los casos donde el nombre no cumple con los requisitos
                        String mensaje;
                        if (usuario.length() > 20) {
                            mensaje = "El usuario no debe exceder los 20 caracteres.";
                        } else if (usuario.length() < 3) {
                            mensaje = "El usuario debe tener al menos 3 caracteres.";
                        } else {
                            mensaje = "El usuario debe contener solo letras y/o números, sin espacios.";
                        }
                        // Mostrar el mensaje de error
                        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Mensaje de error si el campo de texto está vacío
                    Toast.makeText(MainActivity.this, "Por favor, introduzca su nombre", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
