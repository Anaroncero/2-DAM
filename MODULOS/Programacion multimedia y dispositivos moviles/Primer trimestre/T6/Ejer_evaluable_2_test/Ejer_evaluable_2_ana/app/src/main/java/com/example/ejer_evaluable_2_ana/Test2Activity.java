package com.example.ejer_evaluable_2_ana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Test2Activity extends AppCompatActivity {

    // 1. Variables objeto
    private Button btnSiguiente;
    private Button btnRes1, btnRes2, btnRes3, btnRes4;
    private ImageView img;

    // Sonido SOUNDPOOL
    private SoundPool soundPool;
    private int sonidoCorrecto, sonidoIncorrecto;

    // Variable si hay algún botón seleccionado
    private boolean respuestaSeleccionada = false; // Cambia al presionar un botón y llamar al método

    // Puntuación del jugador
    private int puntuacion = 0;

    // Contadores de respuestas correctas, erróneas y blancas
    private int correctas = 0;
    private int erroneas = 0;
    private int blancas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        // 2. Asociar objetos java a componentes xml
        btnSiguiente = findViewById(R.id.buttonSiguiente);
        btnRes1 = findViewById(R.id.res1);
        btnRes2 = findViewById(R.id.res2);
        btnRes3 = findViewById(R.id.res3);
        btnRes4 = findViewById(R.id.res4);
        img = findViewById(R.id.imagen);

        // Recuperar datos de la actividad anterior (nombre del usuario y puntuación)
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

        // Cargar los sonidos de la carpeta creada raw en res
        sonidoCorrecto = soundPool.load(this, R.raw.respuesta_correcta_sonido, 1);
        sonidoIncorrecto = soundPool.load(this, R.raw.respuesta_incorrecta_sonido, 1);

        // 3. Métodos..


        // Respuestas botones, llamamos al método comprobarRespuesta
        btnRes1.setOnClickListener(view -> comprobarRespuesta(btnRes1, false));
        btnRes2.setOnClickListener(view -> comprobarRespuesta(btnRes2, false));
        btnRes3.setOnClickListener(view -> comprobarRespuesta(btnRes3, false));
        btnRes4.setOnClickListener(view -> comprobarRespuesta(btnRes4, true));

        // Botón siguiente
        btnSiguiente.setOnClickListener(view -> {
            // Si no se ha seleccionado una respuesta, aumentar el contador de respuestas blancas
            if (!respuestaSeleccionada) {
                blancas++; // Aumentar el contador de respuestas blancas
            }

            // Pasar los datos (usuario, puntuación y contadores) a la siguiente actividad
            Intent abrirPantalla = new Intent(Test2Activity.this, Test3Activity.class);

            // Pasar los datos (usuario, puntuación, correctas, erróneas, blancas)
            abrirPantalla.putExtra("usuario", nombreUsuario);
            abrirPantalla.putExtra("puntuacion", puntuacion);
            abrirPantalla.putExtra("correctas", correctas);
            abrirPantalla.putExtra("erroneas", erroneas);
            abrirPantalla.putExtra("blancas", blancas);

            startActivity(abrirPantalla);
        });
    }

    // Método comprobarRespuesta
    private void comprobarRespuesta(Button botonSeleccionado, boolean esCorrecto) {
        // Deshabilitar todos los botones después de la selección
        btnRes1.setEnabled(false);
        btnRes2.setEnabled(false);
        btnRes3.setEnabled(false);
        btnRes4.setEnabled(false);

        // Cambiar la variable de estado a que se ha seleccionado una respuesta
        respuestaSeleccionada = true;

        // Cambio de imagen
        img.setImageResource(R.drawable.img2color);

        if (esCorrecto) {  // Respuesta correcta
            // Cambiar fondo del botón a verde y texto a blanco
            botonSeleccionado.setBackgroundColor(getResources().getColor(R.color.green));
            botonSeleccionado.setTextColor(getResources().getColor(R.color.white));

            // Reproducir sonido de respuesta correcta
            soundPool.play(sonidoCorrecto, 1f, 1f, 0, 0, 1f);

            // Sumar puntos
            puntuacion += 20;
            correctas++; // Aumentar el contador de respuestas correctas
        } else {  // Respuesta incorrecta
            // Cambiar fondo del botón a rojo y texto a blanco
            botonSeleccionado.setBackgroundColor(getResources().getColor(R.color.red));
            botonSeleccionado.setTextColor(getResources().getColor(R.color.white));

            // Reproducir sonido de respuesta incorrecta
            soundPool.play(sonidoIncorrecto, 1f, 1f, 0, 0, 1f);

            erroneas++; // Aumentar el contador de respuestas incorrectas
        }
    }
}