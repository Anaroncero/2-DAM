package com.example.ejer_evaluable_3_ana;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDJugadores extends SQLiteOpenHelper {

    private static final String SQLCREATE = "CREATE TABLE Jugadores (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, puntuacion INTEGER)";
    private static final String SQLDROP = "DROP TABLE IF EXISTS Jugadores";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DBJugadores.db";

    // Constructor de la BBDD
    public BDJugadores(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Métodos obligatorios onCreate y onUpgrade
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLDROP);
        onCreate(db);
    }

    // Método para insertar o actualizar la puntuación de un jugador
    public boolean insertarOActualizarJugador(String nombre, int puntuacion) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("puntuacion", puntuacion);

        boolean esNuevoRecord = false;

        // Comprobar si el jugador ya existe
        Cursor cursor = db.query("Jugadores", new String[]{"puntuacion"}, "nombre = ?", new String[]{nombre}, null, null, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                // Si el jugador existe, obtener su puntuación actual
                int puntuacionActual = cursor.getInt(0);
                // Comparar la nueva puntuación con la actual
                if (puntuacion > puntuacionActual) {
                    // Si la nueva puntuación es mayor, actualizar
                    db.update("Jugadores", valores, "nombre = ?", new String[]{nombre});
                    esNuevoRecord = true; // Se ha establecido un nuevo récord
                }
            } else {
                // Si no existe, insertar nuevo jugador
                db.insert("Jugadores", null, valores);
                esNuevoRecord = true; // Es un nuevo jugador, por lo tanto, es un récord
            }
            cursor.close(); // Cerrar el cursor después de usarlo
        }

        db.close(); // Cerrar la base de datos
        return esNuevoRecord; // Retorna si se ha insertado o actualizado
    }

    // Método para obtener la mejor puntuación de un jugador
    public Integer obtenerMejorPuntuacion(String nombre) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Jugadores", new String[]{"puntuacion"}, "nombre = ?", new String[]{nombre}, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int puntuacion = cursor.getInt(0);
                cursor.close();
                db.close();
                return puntuacion;
            }
            cursor.close();
        }
        db.close();
        return 0; // Retorna 0 si el jugador no existe
    }


}
