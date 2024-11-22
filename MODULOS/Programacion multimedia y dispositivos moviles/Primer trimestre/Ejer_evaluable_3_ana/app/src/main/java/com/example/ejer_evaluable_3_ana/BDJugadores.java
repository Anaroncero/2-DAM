package com.example.ejer_evaluable_3_ana;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BDJugadores extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Usuarios.db";
    private static final int DATABASE_VERSION = 2;  // Incrementa la versión si ya existía la base de datos

    // SQL para crear la tabla con el nombre de columna correcto
    private static final String SQL_CREATE_TABLE = "CREATE TABLE Usuarios (Usuario TEXT PRIMARY KEY, nota INTEGER)";

    // SQL para eliminar la tabla (útil para las actualizaciones)
    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS Usuarios";

    // Constructor de la clase DatabaseHelper
    public BDJugadores(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Este método es llamado cuando se crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);  // Crear la tabla
    }

    // Este método es llamado cuando la versión de la base de datos cambia (para realizar la actualización)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE);   // Eliminar la tabla anterior
        db.execSQL(SQL_CREATE_TABLE);  // Crear la nueva tabla
        verificarEsquema(db);  // Verificar el esquema después de la actualización
    }

    // Método para verificar el esquema de la base de datos y ver las columnas de la tabla
    public void verificarEsquema(SQLiteDatabase db) {
        Cursor cursor = db.rawQuery("PRAGMA table_info(Usuarios);", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String columnName = cursor.getString(cursor.getColumnIndex("name"));
                Log.d("DatabaseHelper", "Columna: " + columnName);  // Imprime el nombre de cada columna
            }
            cursor.close();
        }
    }

    // Método para insertar un nuevo usuario con su puntuación inicial
    public void insertarUsuario(String usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("Usuario", usuario);
        valores.put("nota", 0);  // Inicializamos la nota en 0
        db.insert("Usuarios", null, valores);
        db.close();
    }

    // Método para obtener la mejor puntuación de un usuario
    public int obtenerMejorPuntuacion(String usuario) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT nota FROM Usuarios WHERE Usuario = ?", new String[] {usuario});

        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("nota");
            if (columnIndex >= 0) {  // Verifica si la columna "nota" existe
                int puntuacion = cursor.getInt(columnIndex);
                cursor.close();
                return puntuacion;  // Retorna la puntuación actual del usuario
            } else {
                cursor.close();
                return -1;  // Retorna -1 si la columna "nota" no existe
            }
        } else {
            cursor.close();
            return -1;  // Retorna -1 si el usuario no existe
        }
    }

    // Método para actualizar la puntuación de un usuario
    public boolean actualizarNota(String usuario, int nuevaNota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nota", nuevaNota);
        db.update("Usuarios", valores, "Usuario = ?", new String[]{usuario});
        db.close();
        return true;
    }
}