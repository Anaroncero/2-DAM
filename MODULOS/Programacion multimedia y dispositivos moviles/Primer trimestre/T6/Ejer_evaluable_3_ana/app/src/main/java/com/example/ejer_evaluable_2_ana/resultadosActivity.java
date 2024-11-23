package com.example.ejer_evaluable_2_ana;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class resultadosActivity extends AppCompatActivity {

    // Variables
    private Button btnIniciar;
    private TextView mostrarNombre, mostrarRecord, mostrarCorrectas, mostrarErroneas, mostrarBlanco, resultadoPorc;
    private ProgressBar progressBar;

    // Almacenar datos
    private String nombreUsuario;
    private int correctas, erroneas, blancas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        // Asociar los elementos de la interfaz con las variables en Java
        mostrarNombre = findViewById(R.id.mostrarNombre);
        mostrarRecord = findViewById(R.id.mostrarRecord);
        mostrarCorrectas = findViewById(R.id.mostrarCorrectas);
        mostrarErroneas = findViewById(R.id.mostrarErroneas);
        mostrarBlanco = findViewById(R.id.mostrarBlanco);
        btnIniciar = findViewById(R.id.buttonIniciar);
        progressBar = findViewById(R.id.progressBar);
        resultadoPorc = findViewById(R.id.resultadoPorcentaje);

        // Recibir los datos de la actividad anterior
        nombreUsuario = getIntent().getStringExtra("usuario");
        correctas = getIntent().getIntExtra("correctas", 0);
        erroneas = getIntent().getIntExtra("erroneas", 0);
        blancas = getIntent().getIntExtra("blancas", 0);

        // Mostrar los resultados en los TextViews correspondientes
        mostrarNombre.setText(nombreUsuario);
        mostrarCorrectas.setText(String.valueOf(correctas));
        mostrarErroneas.setText(String.valueOf(erroneas));
        mostrarBlanco.setText(String.valueOf(blancas));

        // Calcular el porcentaje de respuestas correctas
        int totalPreguntas = 5; // Suponiendo que 5 es el total de preguntas
        int porcentajeCorrectas = (int) ((correctas / (float) totalPreguntas) * 100);

        // Configurar el color de la Progress Bar y el texto según el porcentaje
        int color;
        if (porcentajeCorrectas >= 50) {
            color = getResources().getColor(R.color.green);
        } else {
            color = getResources().getColor(R.color.red);
        }
        progressBar.setProgressTintList(ColorStateList.valueOf(color));
        progressBar.setProgress(porcentajeCorrectas);
        resultadoPorc.setText(String.valueOf(porcentajeCorrectas) + "%");

        // Inicializar el helper de base de datos
        BDJugadores bdJugadores = new BDJugadores(this);

        // Obtener la mejor puntuación anterior
        int mejorPuntuacion = bdJugadores.obtenerMejorPuntuacion(nombreUsuario);

        // Si el usuario no existe (puntuación -1), crearlo
        boolean esUsuarioNuevo = false;
        if (mejorPuntuacion == -1) {
            bdJugadores.insertarUsuario(nombreUsuario);
            mejorPuntuacion = 0;  // La puntuación inicial es 0
            esUsuarioNuevo = true;  // Marcar que es un usuario nuevo
        }

        // Actualizar la puntuación si es mayor
        boolean esNuevoRecord = false;
        if (porcentajeCorrectas > mejorPuntuacion) {
            bdJugadores.actualizarNota(nombreUsuario, porcentajeCorrectas);
            esNuevoRecord = true;
        }

        // Mostrar el mensaje adecuado
        if (esUsuarioNuevo) {
            mostrarRecord.setText("Puntuación inicial registrada: " + porcentajeCorrectas + " / 100");
        } else if (esNuevoRecord) {
            mostrarRecord.setText(porcentajeCorrectas + " - ¡Has tenido un RECORD, respecto a la última vez!");
            mostrarRecord.setTextColor(color);
        } else {
            mostrarRecord.setText("Puntuación más alta: " + mejorPuntuacion + " / 100");
        }

        // Configurar el botón para iniciar la actividad principal
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirPantalla = new Intent(resultadosActivity.this, MainActivity.class);
                startActivity(abrirPantalla);
            }
        });
    }
}
