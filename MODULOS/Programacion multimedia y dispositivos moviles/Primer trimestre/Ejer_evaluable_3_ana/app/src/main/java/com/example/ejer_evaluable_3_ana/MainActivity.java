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
    private Button btnIniciar;
    private EditText usuarioInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.Asociar objetos Java a XML
        btnIniciar = findViewById(R.id.buttonIniciar);
        usuarioInput = findViewById(R.id.editTextUsuario);

        // Botón siguiente pantalla INTENT y pasar datos clase static Datos
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usuarioInput != null && !usuarioInput.getText().toString().isEmpty()) {
                    // Obtener el usuario del EditText
                    String usuario = usuarioInput.getText().toString().toLowerCase();

                    // Verificar que no contenga espacios, no sea solo números, tenga un máximo de 20 caracteres y al menos 3
                    if (usuario.matches("^[a-zA-Z0-9]+$") && !usuario.matches("\\d+") && usuario.length() <= 20 && usuario.length() >= 3) {
                        // Método para pasar dato a través de clase Datos
                        Datos.setNombre(usuario);

                        // Iniciar la nueva activity
                        Intent abrirPantalla = new Intent(MainActivity.this, Test1Activity.class);
                        startActivity(abrirPantalla);
                    } else {
                        String mensaje;
                        if (usuario.length() > 20) {
                            mensaje = "El usuario no debe exceder los 20 caracteres.";
                        } else if (usuario.length() < 3) {
                            mensaje = "El usuario debe tener al menos 3 caracteres.";
                        } else {
                            mensaje = "El usuario debe contener solo letras y/o números, sin espacios.";
                        }
                        // Mostrar mensaje de error
                        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    String mensaje = "Por favor, introduzca su nombre";
                    // Toast en caso de que no introduzca nombre
                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}