package com.example.ejer_evaluable_3_ana;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDJugadores extends SQLiteOpenHelper {

    private Context contexto;
    private final String SQLCREATE = "CREATE TABLE Jugadores (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, puntuacion INTEGER)";
    private final String SQLDROP = "DROP TABLE IF EXISTS Jugadores";

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
    public void insertarOActualizarJugador(String nombre, int puntuacion) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("puntuacion", puntuacion);

        // Comprobar si el jugador ya existe
        Cursor cursor = db.query("Jugadores", new String[]{"puntuacion"}, "nombre = ?", new String[]{nombre}, null, null, null);
        if (cursor.moveToFirst()) {
            // Si el jugador existe, actualizar su puntuación si es mayor
            int puntuacionActual = cursor.getInt(0);
            if (puntuacion > puntuacionActual) {
                db.update("Jugadores", valores, "nombre = ?", new String[]{nombre});
            }
        } else {
            // Si no existe, insertar nuevo jugador
            db.insert("Jugadores", null, valores);
        }
        cursor.close();
        db.close();
    }

    // Método para obtener la mejor puntuación de un jugador
    public Integer obtenerMejorPuntuacion(String nombre) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Jugadores", new String[]{"puntuacion"}, "nombre = ?", new String[]{nombre}, null, null, null);
        if (cursor.moveToFirst()) {
            int puntuacion = cursor.getInt(0);
            cursor.close();
            db.close();
            return puntuacion;
        }
        cursor.close();
        db.close();
        return 0; // Retorna 0 si el jugador no existe
    }


    // Método para comprobar si la nueva puntuación es un récord
    public boolean esNuevoRecord(String nombreUsuario, int nuevaPuntuacion) {
        int mejorPuntuacion = obtenerMejorPuntuacion(nombreUsuario);
        return nuevaPuntuacion > mejorPuntuacion; // Esto ahora funcionará correctamente
    }

}