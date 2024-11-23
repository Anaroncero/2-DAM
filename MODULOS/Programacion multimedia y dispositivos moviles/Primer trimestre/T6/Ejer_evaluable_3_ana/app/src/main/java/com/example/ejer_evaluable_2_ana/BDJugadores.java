package com.example.ejer_evaluable_2_ana;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BDJugadores extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Usuarios.db";
    private static final int DATABASE_VERSION = 2;

    // SQL para crear la tabla
    private static final String SQL_CREATE_TABLE = "CREATE TABLE Usuarios (Usuario TEXT PRIMARY KEY, nota INTEGER)";
    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS Usuarios";

    public BDJugadores(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE);
        db.execSQL(SQL_CREATE_TABLE);
    }

    // Verificar esquema de la base de datos
    public void verificarEsquema(SQLiteDatabase db) {
        Cursor cursor = db.rawQuery("PRAGMA table_info(Usuarios);", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String columnName = cursor.getString(cursor.getColumnIndex("name"));
                Log.d("DatabaseHelper", "Columna: " + columnName);
            }
            cursor.close();
        }
    }

    // Insertar un nuevo usuario
    public void insertarUsuario(String usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("Usuario", usuario);
        valores.put("nota", 0);  // Inicializamos la nota en 0
        db.insert("Usuarios", null, valores);
        db.close();
    }

    // Obtener la mejor puntuación de un usuario
    public int obtenerMejorPuntuacion(String usuario) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT nota FROM Usuarios WHERE Usuario = ?", new String[]{usuario});

        if (cursor != null && cursor.moveToFirst()) {
            int puntuacion = cursor.getInt(cursor.getColumnIndex("nota"));
            cursor.close();
            return puntuacion;
        } else {
            if (cursor != null) cursor.close();
            return -1;  // El usuario no existe
        }
    }

    // Actualizar la puntuación de un usuario solo si es mayor
    public boolean actualizarNota(String usuario, int nuevaNota) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Obtener la puntuación actual
        int puntuacionActual = obtenerMejorPuntuacion(usuario);

        // Solo actualizar si el nuevo puntaje es mayor
        if (nuevaNota > puntuacionActual) {
            ContentValues valores = new ContentValues();
            valores.put("nota", nuevaNota);
            db.update("Usuarios", valores, "Usuario = ?", new String[]{usuario});
            db.close();
            return true;  // Nuevo récord
        }

        db.close();
        return false;  // No es un nuevo récord
    }
}
