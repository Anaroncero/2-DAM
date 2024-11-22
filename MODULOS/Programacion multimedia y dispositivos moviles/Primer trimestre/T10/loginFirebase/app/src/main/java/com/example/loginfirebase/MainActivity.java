package com.example.loginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText password;
    private Button login;
    private Button registro;

    private FirebaseAuth mAuth; //Objeto bbdd FireBase para auth.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.usuario);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login = findViewById(R.id.registro);

        //Inicializar Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = usuario.getText().toString();
                String pass = password.getText().toString();

                // Uso de MainActivity.this como contexto
                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Inicio de sesión exitoso
                                    Log.d("LOGIN", "Login realizado");
                                    Toast.makeText(MainActivity.this, "Login correcto!", Toast.LENGTH_SHORT).show();
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    //String Uid = user.getUid();
                                    //buscarDatos(Uid);
                                } else {
                                    // Si falla el inicio de sesión
                                    Log.d("LOGIN", "Login no realizado");
                                    Toast.makeText(MainActivity.this, "Login incorrecto", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = usuario.getText().toString();
                String pass = password.getText().toString();

                // Validar los campos antes de intentar el registro
                if (email.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d("REGISTRO", "Registro realizado");
                                    Toast.makeText(MainActivity.this, "Registro correcto!", Toast.LENGTH_SHORT).show();
                                    FirebaseUser user = mAuth.getCurrentUser();
                                } else {
                                    Log.d("REGISTRO", "Registro NO realizado");
                                    Toast.makeText(MainActivity.this, "Registro incorrecto: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }

}