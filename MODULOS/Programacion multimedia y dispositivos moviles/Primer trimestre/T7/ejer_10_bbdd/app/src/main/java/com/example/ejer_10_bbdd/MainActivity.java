package com.example.ejer_10_bbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Variables
    private EditText nombre;
    private EditText apellido;
    private Button botonComprobar;
    private TextView resultado;
    private DatabaseHelper db; //Instancia de la bbdd

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Asociar objetos java a componentes xml
        nombre = findViewById(R.id.editTextTextNombre);
        apellido = findViewById(R.id.apellido);
        botonComprobar = findViewById(R.id.button);
        resultado = findViewById(R.id.textViewResultado);

        //Inicializar el helper de base de datos
        db = new DatabaseHelper(this);
        db.insertarProfesorEjemplo();

        botonComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Tnombre = nombre.getText().toString();
                String Tapellido = apellido.getText().toString();

                boolean Tresultado = db.comprobarProfesor(Tnombre, Tapellido);

                if(Tresultado){
                    resultado.setText("si, existe este profesor");
                }else{
                    resultado.setText("no, en Medac nadie se llama así");
                }
            }
        });



    }
}