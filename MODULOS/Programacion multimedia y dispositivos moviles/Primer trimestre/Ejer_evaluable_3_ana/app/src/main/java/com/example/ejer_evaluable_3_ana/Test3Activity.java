package com.example.ejer_evaluable_3_ana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Test3Activity extends AppCompatActivity {

    // Variables
    private Button btnSiguiente;
    private Button btnRes1, btnRes2, btnRes3, btnRes4;
    private ImageView img;

    // Sonido SoundPool
    private SoundPool soundPool;
    private int sonidoCorrecto, sonidoIncorrecto;

    // Variable Boton seleccionado
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
        setContentView(R.layout.activity_test3);

        // Asociar objetos java a componentes xml
        btnSiguiente = findViewById(R.id.buttonSiguiente);
        btnRes1 = findViewById(R.id.res1);
        btnRes2 = findViewById(R.id.res2);
        btnRes3 = findViewById(R.id.res3);
        btnRes4 = findViewById(R.id.res4);
        img = findViewById(R.id.imagen);

        // Recuperar datos de la actividad anterior (usuario y puntuación)
        Intent intentRecibido = getIntent();
        String nombreUsuario = intentRecibido.getStringExtra("usuario");
        puntuacion = intentRecibido.getIntExtra("puntuacion", 0);

        // Recuperar contadores de respuestas
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

        // Métodos y botones


        // Botones de respuesta
        btnRes1.setOnClickListener(view -> comprobarRespuesta(btnRes1, false));
        btnRes2.setOnClickListener(view -> comprobarRespuesta(btnRes2, true));
        btnRes3.setOnClickListener(view -> comprobarRespuesta(btnRes3, false));
        btnRes4.setOnClickListener(view -> comprobarRespuesta(btnRes4, false));

        // Botón SIGUIENTE
        btnSiguiente.setOnClickListener(view -> {
            // Si no seleccionó ninguna respuesta, aumentar el contador de respuestas blancas
            if (!respuestaSeleccionada) {
                blancas++; // Aumentar el contador de respuestas blancas
            }

            // Pasar los datos a la siguiente actividad
            Intent abrirPantalla = new Intent(Test3Activity.this, Test4Activity.class);

            // Pasar los datos (usuario, puntuación y contadores)
            abrirPantalla.putExtra("usuario", nombreUsuario);
            abrirPantalla.putExtra("puntuacion", puntuacion);
            abrirPantalla.putExtra("correctas", correctas);
            abrirPantalla.putExtra("erroneas", erroneas);
            abrirPantalla.putExtra("blancas", blancas);

            startActivity(abrirPantalla);
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
        img.setImageResource(R.drawable.img3color);

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
