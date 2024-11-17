package com.example.ejer_evaluable_3_ana;

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
import android.widget.Toast;

public class Test1Activity extends AppCompatActivity {

    //2. Asociar objetos Java a elementos xml
    //1.Crear objetos y variables
    private ImageButton btnAtras;
    private Button btnSiguiente;

    private Button btnRes1, btnRes2, btnRes3, btnRes4;

    //Imagen
    private ImageView img;

    //Sonido corto
    private SoundPool soundPool;
    private int sonidoCorrecto, sonidoIncorrecto;

    //variable inicializada en false, no hay respuestas elegidas
    private boolean respuestaSeleccionada = false; //cambia a true si se llama al metodo respuesta elegida (se llama cuando el usuario pulsa un boton de respuesta)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        //SOUNDPOOL
        // Inicialización de SoundPool
        AudioAttributes at = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(1) // Número máximo de streams de sonido
                .setAudioAttributes(at)
                .build();
            // Cargar los sonidos (asegúrate de tener los archivos en 'res/raw')
            sonidoCorrecto = soundPool.load(this, R.raw.respuesta_correcta_sonido, 1);
            sonidoIncorrecto = soundPool.load(this, R.raw.respuesta_incorrecta_sonido, 1);


        //2. Asociar los objetos java a los componentes xml
        setContentView(R.layout.activity_test1);
        btnAtras = findViewById(R.id.buttonAtras);
        img = findViewById(R.id.imagen);
        btnSiguiente = findViewById(R.id.buttonSiguiente);
        btnRes1 = findViewById(R.id.res1);
        btnRes2 = findViewById(R.id.res2);
        btnRes3 = findViewById(R.id.res3);
        btnRes4 = findViewById(R.id.res4);


        //3. Métodos, botones, funciones..
        //Botón hacia atrás
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Mostrar ventana confirmar que quiere salir
                new AlertDialog.Builder(Test1Activity.this)
                        .setTitle("Confirmación")
                        .setMessage("¿Estás seguro de que quieres salir?")
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Si el usuario acepta, vuelve a la otra activity
                                //Volver a la otra activity
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
        btnRes1.setOnClickListener(view -> respuestaElegida(btnRes1, false));
        btnRes2.setOnClickListener(view -> respuestaElegida(btnRes2, true));
        btnRes3.setOnClickListener(view -> respuestaElegida(btnRes3, false));
        btnRes4.setOnClickListener(view -> respuestaElegida(btnRes4, false));


        //Botón siguiente (tendra que guardar también la respuesta correcta)
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(respuestaSeleccionada == false){
                    Toast.makeText(Test1Activity.this, "Por favor, seleccione una respuesta", Toast.LENGTH_SHORT).show();
                }else{
                    //Pasamos a la siguiente ventanaç
                    Intent abrirPantalla = new Intent(Test1Activity.this, Test2Activity.class);
                    startActivity(abrirPantalla);
                }
            }
        });


    }


        //Método respuestaElegida
        private void respuestaElegida(Button botonSeleccionado, boolean esCorrecto){
            //Deshabilitamos todos los botones, para que no se puedan seleccionar varios
            btnRes1.setEnabled(false);
            btnRes2.setEnabled(false);
            btnRes3.setEnabled(false);
            btnRes4.setEnabled(false);

            //Se ha seleccionado una respuesta
            respuestaSeleccionada = true;

            //Cambio imagen
            img.setImageResource(R.drawable.img1color);

            if(esCorrecto){ //Si es la respuesta correcta (parametro en true)
                //Botón cambia a color verde
                botonSeleccionado.setBackgroundColor(getResources().getColor(R.color.green));
                botonSeleccionado.setTextColor(getResources().getColor(R.color.white));
                //Sonido correcto
                soundPool.play(sonidoCorrecto, 1f, 1f, 0, 0, 1f);

            }else{
                //color rojo
                botonSeleccionado.setBackgroundColor(getResources().getColor(R.color.red));
                botonSeleccionado.setTextColor(getResources().getColor(R.color.white));
                //Sonido incorrecto
                soundPool.play(sonidoIncorrecto, 1f, 1f, 0, 0, 1f);
            }
    }
}