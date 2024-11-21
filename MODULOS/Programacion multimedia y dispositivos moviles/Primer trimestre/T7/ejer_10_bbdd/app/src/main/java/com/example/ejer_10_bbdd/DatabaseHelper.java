package com.example.ejer_10_bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class
DatabaseHelper extends SQLiteOpenHelper {

    private Context contexto;
    private final String SQLCREATE = "CREATE TABLE Profesores (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellido TEXT)";
    private final String SQLDROP = "DROP TABLE IF EXISTS Profesores";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DBProfesores.db";

    //Constructor de la bbdd
    public DatabaseHelper(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Metodo obligatorio onCreate (al crear la bbdd, creamos la tabla)
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCREATE);
    }

    //Metodo obligatorio onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLDROP);
        db.execSQL(SQLCREATE);
    }


    ////////////////////// Metodos opcionales, segun necesidad ////////////////////////

    //Metodo para insertar un profesor de ejemplo
    public void insertarProfesorEjemplo() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", "Juan");
        valores.put("apellido", "Perez");
        db.insert("Profesores", null, valores);

        db.close();
    }


    //Método para comprobar si un profesor esta en la tabla
    public boolean comprobarProfesor(String nombre, String apellido) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Profesores WHERE nombre = ? AND apellido = ?";
        Cursor cursor = db.rawQuery(query, new String[]{nombre, apellido});

        boolean existe = cursor.getCount() > 0;

        cursor.close();
        db.close();
        return existe;
    }



}
