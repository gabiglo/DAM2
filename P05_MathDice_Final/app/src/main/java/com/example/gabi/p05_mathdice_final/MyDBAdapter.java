package com.example.gabi.p05_mathdice_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Gabi on 12/02/2016.
 */
public class MyDBAdapter {

    //Definición de variables de la BBDD.
    private static final String DATABASE_NAME = "MathdicePerfil.db";//Nombre para nuestra base de datos
    private static final String DATABASE_TABLE = "Usuario";//Este string definira el nombre de nuestra tabla
    private static final int DATABASE_VERSION = 1;

    //Definición campos de la tabla usuarios.
    private static final String NOMBRE = "nombre";
    private static final String APELLIDOS = "apellidos";
    private static final String RUTAFOTO = "ruta";

    //Definición de creacion y borrado de la tabla usuarios.
    private static final String DATABASE_CREATE =
            "CREATE TABLE " + DATABASE_TABLE +
                    " (_id integer primary key autoincrement, nombre text, apellidos text, ruta text);";
    //Variable para el borrado de nuestra BD
    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS " + DATABASE_TABLE + ";";

    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;
    //Pasammos al constructor de nuestra clase el contexto
    public MyDBAdapter(Context c) {
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //METODO QUE NOS PERITIRA ABRIR NUESTRA BD, EN MODO DE ESCRITURA Y SINO DE LECTURA
    public void open() {
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLiteException e) {
            db = dbHelper.getReadableDatabase();
        }
    }

    //Metodo en el que utilizamos el context values para insertar en nuestra BD
    public void insertarUsuario(String name, String apellido, String path){
        //Creamos un objeto ContentValues
        ContentValues contentvalues = new ContentValues();
        //Asignamos los valores de cada campo
        contentvalues.put(NOMBRE, name);
        contentvalues.put(APELLIDOS, apellido);
        contentvalues.put(RUTAFOTO, path);
        //Realizamos el insert en la BBDD.
        db.insert(DATABASE_TABLE, null, contentvalues);
    }

    //Metodo al que llamaremos para recuperar los usuarios de la BBDD.
    public ArrayList<String> recuperarUsuarios(){
        ArrayList<String> usuarios = new ArrayList<>();
        Cursor cursor = db.query(DATABASE_TABLE, null, null, null, null, null, null);
        if(cursor != null && cursor.moveToFirst()){
            do{
                //Recojo todos los datos del usuario(ID, nombre, apellido y ruta).
                usuarios.add(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3));
            }while(cursor.moveToNext());
        }
        return usuarios;
    }
    //Clase de nuestra BD
    private static class MyDbHelper extends SQLiteOpenHelper {
        //Contructor de nuestra clase
        public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        //Creamos nuestra BD
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }
        //Metodo para Borrar nuestra BD
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP);
            onCreate(db);
        }

    }

}