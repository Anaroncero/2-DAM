package com.example.ejer_evaluable_2_ana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Test5Activity extends AppCompatActivity {
    // Variables
    private Button btnSiguiente;
    private Button btnRes1, btnRes2, btnRes3, btnRes4;
    private ImageView img;

    // Sonido SoundPool
    private SoundPool soundPool;
    private int sonidoCorrecto, sonidoIncorrecto;

    // Variable boton seleccionado
    private boolean respuestaSeleccionada = false;

    // Puntuación del jugador
    private int puntuacion = 0;

    // Contadores para respuestas correctas, erróneas y blancas
    private int correctas = 0;
    private int erroneas = 0;
    private int blancas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test5);

        // Asociar objetos con elementos xml
        btnSiguiente = findViewById(R.id.buttonSiguiente);
        img = findViewById(R.id.imagen);
        btnRes1 = findViewById(R.id.res1);
        btnRes2 = findViewById(R.id.res2);
        btnRes3 = findViewById(R.id.res3);
        btnRes4 = findViewById(R.id.res4);

        // Recuperar datos
        Intent intentRecibido = getIntent();
        String nombreUsuario = intentRecibido.getStringExtra("usuario");
        puntuacion = intentRecibido.getIntExtra("puntuacion", 0);
        correctas = intentRecibido.getIntExtra("correctas", 0);
        erroneas = intentRecibido.getIntExtra("erroneas", 0);
        blancas = intentRecibido.getIntExtra("blancas", 0);

        // SoundPool
        AudioAttributes at = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(at)
                .build();

        // Cargar sonidos
        sonidoCorrecto = soundPool.load(this, R.raw.respuesta_correcta_sonido, 1);
        sonidoIncorrecto = soundPool.load(this, R.raw.respuesta_incorrecta_sonido, 1);


        // Botones de respuesta
        btnRes1.setOnClickListener(view -> comprobarRespuesta(btnRes1, false));
        btnRes2.setOnClickListener(view -> comprobarRespuesta(btnRes2, false));
        btnRes3.setOnClickListener(view -> comprobarRespuesta(btnRes3, true));
        btnRes4.setOnClickListener(view -> comprobarRespuesta(btnRes4, false));

        // Botón Siguiente
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!respuestaSeleccionada) {
                    blancas++;
                }

                // Pasar los datos a la siguiente actividad (o pantalla)
                Intent abrirPantalla = new Intent(Test5Activity.this, resultadosActivity.class); // O la actividad que corresponda

                // Pasar los datos de usuario, puntuación y contadores
                abrirPantalla.putExtra("usuario", nombreUsuario);
                abrirPantalla.putExtra("puntuacion", puntuacion);
                abrirPantalla.putExtra("correctas", correctas);
                abrirPantalla.putExtra("erroneas", erroneas);
                abrirPantalla.putExtra("blancas", blancas);

                startActivity(abrirPantalla);
            }
        });
    }

    // Método comprobar respuesta
    private void comprobarRespuesta(Button botonSeleccionado, boolean esCorrecto) {
        // Deshabilitar los botones
        btnRes1.setEnabled(false);
        btnRes2.setEnabled(false);
        btnRes3.setEnabled(false);
        btnRes4.setEnabled(false);

        respuestaSeleccionada = true; // El usuario seleccionó una respuesta

        // Cambio de imagen
        img.setImageResource(R.drawable.img5color);

        if (esCorrecto) { // Respuesta correcta
            botonSeleccionado.setBackgroundColor(getResources().getColor(R.color.green));
            botonSeleccionado.setTextColor(getResources().getColor(R.color.white));

            soundPool.play(sonidoCorrecto, 1f, 1f, 0, 0, 1f);

            puntuacion += 20;
            correctas++; // Aumentar el contador de respuestas correctas
        } else { // Respuesta incorrecta
            botonSeleccionado.setBackgroundColor(getResources().getColor(R.color.red));
            botonSeleccionado.setTextColor(getResources().getColor(R.color.white));

            soundPool.play(sonidoIncorrecto, 1f, 1f, 0, 0, 1f);

            erroneas++; // Aumentar el contador de respuestas incorrectas

        }
    }
}
