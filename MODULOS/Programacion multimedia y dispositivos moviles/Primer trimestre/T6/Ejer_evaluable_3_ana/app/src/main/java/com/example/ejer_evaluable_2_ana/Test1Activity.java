package com.example.ejer_evaluable_2_ana;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Test1Activity extends AppCompatActivity {

    //1. Crear objetos y variables
    private ImageButton btnAtras;
    private Button btnSiguiente;
    private Button btnRes1, btnRes2, btnRes3, btnRes4;
    private ImageView img;

    //Sonido corto SoundPool
    private SoundPool soundPool;
    private int sonidoCorrecto, sonidoIncorrecto;

    //Variable inicializada en false, no hay respuestas elegidas
    private boolean respuestaSeleccionada = false; // Cambia a true si se llama al método respuesta elegida (se llama cuando el usuario pulsa un botón de respuesta)

    //Puntuación del jugador
    private int puntuacion = 0;

    //Contadores de respuestas correctas, erróneas y blancas
    private int correctas = 0;
    private int erroneas = 0;
    private int blancas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        //2. Asociar los objetos java a los componentes xml
        img = findViewById(R.id.imagen);
        btnSiguiente = findViewById(R.id.buttonSiguiente);
        btnRes1 = findViewById(R.id.res1);
        btnRes2 = findViewById(R.id.res2);
        btnRes3 = findViewById(R.id.res3);
        btnRes4 = findViewById(R.id.res4);
        btnAtras = findViewById(R.id.buttonAtras);

        //Obtener el nombre del usuario desde el Intent
        String nombreUsuario = getIntent().getStringExtra("usuario");

        //3. SOUNDPOOL
        //Inicialización de SoundPool
        AudioAttributes at = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(1) // Número máximo de streams de sonido
                .setAudioAttributes(at)
                .build();
        //Cargar los sonidos (asegúrate de tener los archivos en 'res/raw')
        sonidoCorrecto = soundPool.load(this, R.raw.respuesta_correcta_sonido, 1);
        sonidoIncorrecto = soundPool.load(this, R.raw.respuesta_incorrecta_sonido, 1);

        //4. Métodos, botones, funciones..
        //Botón hacia atrás
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mostrar ventana confirmar que quiere salir
                new AlertDialog.Builder(Test1Activity.this)
                        .setTitle("Confirmación")
                        .setMessage("¿Estás seguro de que quieres salir?")
                        .setCancelable(false)
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Si el usuario acepta, vuelve a la otra activity
                                Intent abrirPantalla = new Intent(Test1Activity.this, MainActivity.class);
                                startActivity(abrirPantalla);
                                finish();
                            }
                        })
                        .setNegativeButton("No", null) // No hacer nada si elige "No"
                        .show();
            }
        });

        //Botones Respuesta
        btnRes1.setOnClickListener(view -> comprobarRespuesta(btnRes1, false));
        btnRes2.setOnClickListener(view -> comprobarRespuesta(btnRes2, true));
        btnRes3.setOnClickListener(view -> comprobarRespuesta(btnRes3, false));
        btnRes4.setOnClickListener(view -> comprobarRespuesta(btnRes4, false));

        //Botón siguiente, comprueba si se ha seleccionado una respuesta antes de cambiar de activity
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Si no se ha seleccionado una respuesta, aumentar el contador de respuestas blancas
                if (!respuestaSeleccionada) {
                    blancas++; // Aumentar el contador de respuestas blancas
                }

                //Pasar los datos (usuario, puntuación y contadores) a la siguiente actividad
                Intent abrirPantalla = new Intent(Test1Activity.this, Test2Activity.class);

                //Pasar los datos (usuario, puntuación, correctas, erróneas, blancas)
                abrirPantalla.putExtra("usuario", nombreUsuario);
                abrirPantalla.putExtra("puntuacion", puntuacion);
                abrirPantalla.putExtra("correctas", correctas);
                abrirPantalla.putExtra("erroneas", erroneas);
                abrirPantalla.putExtra("blancas", blancas);

                startActivity(abrirPantalla);
            }
        });
    }

    //Método comprobarRespuesta
    private void comprobarRespuesta(Button botonSeleccionado, boolean esCorrecto) {
        //Deshabilitar todos los botones después de la selección
        btnRes1.setEnabled(false);
        btnRes2.setEnabled(false);
        btnRes3.setEnabled(false);
        btnRes4.setEnabled(false);

        //Cambiar la variable de estado a que se ha seleccionado una respuesta
        respuestaSeleccionada = true;

        //Cambio de imagen
        img.setImageResource(R.drawable.img1color);

        if (esCorrecto) {  //Respuesta correcta
            //Cambiar fondo del botón a verde y texto a blanco
            botonSeleccionado.setBackgroundColor(getResources().getColor(R.color.green));
            botonSeleccionado.setTextColor(getResources().getColor(R.color.white));

            //Reproducir sonido de respuesta correcta
            soundPool.play(sonidoCorrecto, 1f, 1f, 0, 0, 1f);

            puntuacion += 20;
            correctas++; // Aumentar el contador de respuestas correctas

        } else {  // Respuesta incorrecta
            // Cambiar fondo del botón a rojo y texto a blanco
            botonSeleccionado.setBackgroundColor(getResources().getColor(R.color.red));
            botonSeleccionado.setTextColor(getResources().getColor(R.color.white));

            //Reproducir sonido de respuesta incorrecta
            soundPool.play(sonidoIncorrecto, 1f, 1f, 0, 0, 1f);

            erroneas++;
        }
    }
}
