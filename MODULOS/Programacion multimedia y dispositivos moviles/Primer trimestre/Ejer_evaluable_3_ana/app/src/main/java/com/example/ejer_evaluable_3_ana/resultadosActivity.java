package com.example.ejer_evaluable_3_ana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class resultadosActivity extends AppCompatActivity {

    //Variables
    private Button btnIniciar;
    private TextView mostrarNombre, mostrarRecord, mostrarCorrectas, mostrarErroneas, mostrarBlanco, resultadoPorc;

    private ProgressBar progressBar;

    //Almacenar datos
    private String nombreUsuario;
    private int puntuacion;
    private int correctas, erroneas, blancas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        System.out.println("resultados");
        //2. Asociar los elementos de la interfaz con las variables en Java
        mostrarNombre = findViewById(R.id.mostrarNombre);
        mostrarRecord = findViewById(R.id.mostrarRecord);
        mostrarCorrectas = findViewById(R.id.mostrarCorrectas);
        mostrarErroneas = findViewById(R.id.mostrarErroneas);
        mostrarBlanco = findViewById(R.id.mostrarBlanco);
        btnIniciar = findViewById(R.id.buttonIniciar);

        progressBar = findViewById(R.id.progressBar);
        resultadoPorc = findViewById(R.id.resultadoPorcentaje);


        //Recibir los datos de la actividad anterior
        nombreUsuario = getIntent().getStringExtra("usuario");
        puntuacion = getIntent().getIntExtra("puntuacion", 0);
        correctas = getIntent().getIntExtra("correctas", 0);
        erroneas = getIntent().getIntExtra("erroneas", 0);
        blancas = getIntent().getIntExtra("blancas", 0);

        // Mostrar los resultados en los TextViews correspondientes
        mostrarNombre.setText(nombreUsuario);
        mostrarCorrectas.setText(String.valueOf(correctas));
        mostrarErroneas.setText(String.valueOf(erroneas));
        mostrarBlanco.setText(String.valueOf(blancas));

        // Progress Bar
        // Configurar el progreso basado en las respuestas correctas
        int correctas = getIntent().getIntExtra("correctas", 0);
        int porcentajeCorrectas = (int) ((correctas / 5.0) * 100); //ejemplo si fueran 3 correctas: // (0.6) * 100 = 60


        //FALLA EL VALUE OF
        if(porcentajeCorrectas >= 50){
            int colorGreen = getResources().getColor(R.color.green);
            progressBar.setProgressTintList(ColorStateList.valueOf(colorGreen));
            resultadoPorc.setTextColor(getResources().getColor(R.color.green));
        }else{
            int colorRed = getResources().getColor(R.color.red);
            progressBar.setProgressTintList(ColorStateList.valueOf(colorRed));
            resultadoPorc.setTextColor(getResources().getColor(R.color.red));
        }

        // Establecer el progreso
        progressBar.setProgress(porcentajeCorrectas);
        resultadoPorc.setText(String.valueOf(porcentajeCorrectas));






    }


}